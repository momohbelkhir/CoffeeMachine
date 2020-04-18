package coffeeMachineImpl;

public enum Drink {

	COFFEE("C", 0.6), TEA("T", 0.4), CHOCOLATE("H",0.5), ORANGE("O",0.6);

    private final String code;
    private double price;

    Drink(String code, double price) {
        this.code = code;
        this.price = price;
     
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    
}
