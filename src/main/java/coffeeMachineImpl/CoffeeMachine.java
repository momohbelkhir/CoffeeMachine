package coffeeMachineImpl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

	public static final int MAX_SUGAR = 2;
	public static final double MIN_MONEY = 0.4;
	private Map<Drink, Integer> commandes;
	private double totalPrice;

	public CoffeeMachine() {
		super();
		this.commandes = new HashMap<Drink, Integer>();
		this.totalPrice = 0;
	}

	public String makeCommand(Drink drink, int numberOfSugar, double money, boolean isExtra) {

		   if (drink.getPrice()  > money) {
			 
			 return "M: vous n'avez pas assez de crédit, il vous manque " + new BigDecimal((drink.getPrice() - money), MathContext.DECIMAL32) + "€"; 
			 
			 }
		
		 
		if (commandes.containsKey(drink)) {

			commandes.put(drink, commandes.get(drink) + 1);

		} else {
			commandes.put(drink, 1);

		}

		this.totalPrice = this.totalPrice + drink.getPrice();
		String extra = makeExtraHot(drink, isExtra);

		String sugar = makeSugar(drink,numberOfSugar);

		String touillette = makeTouillette(sugar);

		return drink.getCode() +extra +": " + sugar + ": " + touillette;
	}

	private String makeTouillette(String sugar) {
		if(sugar.equals("")) {
			return "";
		}else {
			return "0";
		}
		
	}

	private String makeSugar(Drink drink,int numberOfSugar) {
		String sugar="";
	     if (!drink.equals(drink.ORANGE)) {
	    	 
	    	 if (numberOfSugar > MAX_SUGAR) {
	             numberOfSugar = MAX_SUGAR;
	         }
	         if (numberOfSugar > 0) {

	             sugar = String.valueOf(numberOfSugar);
	         }
	     }
	    
         return sugar;
	}
	private String makeExtraHot(Drink drink, boolean isExtra) {
		String extra="";
	     if (!drink.equals(drink.ORANGE) && isExtra) {
	    	 
	    	extra="h";
	     }
	    
         return extra;
	}
	public void printCommands() {
		
		System.out.println("******");
		commandes.forEach((k,v)-> clientMessage("Drink : " + k +", price : "+ k.getPrice() + "€, Quantities : " + v));
		clientMessage("total price : "+new BigDecimal(getTotalPrice(), MathContext.DECIMAL32)+"€");
		System.out.println("******");
	}
	
	public void clientMessage(String msg) {
		System.out.println("M: "+msg); 
		
	}

	public Map<Drink, Integer> getCommandes() {
		return commandes;
	}

	public void setCommandes(Map<Drink, Integer> commandes) {
		this.commandes = commandes;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
