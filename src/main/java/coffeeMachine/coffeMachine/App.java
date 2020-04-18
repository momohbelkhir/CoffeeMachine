package coffeeMachine.coffeMachine;

import coffeeMachineImpl.CoffeeMachine;
import coffeeMachineImpl.Drink;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Coffee Machine !" );
        
        CoffeeMachine coffeeMachine = new CoffeeMachine();
     
        System.out.println(coffeeMachine.makeCommand(Drink.CHOCOLATE, 3, 0.5,true));
        
        System.out.println(coffeeMachine.makeCommand(Drink.TEA, 0, 0.6,false));
        
        System.out.println(coffeeMachine.makeCommand(Drink.COFFEE, 1, 0.6,true));
        
        System.out.println(coffeeMachine.makeCommand(Drink.CHOCOLATE, 2, 0.4,false));
        
        System.out.println(coffeeMachine.makeCommand(Drink.ORANGE, 10, 0.7,false));
        
        System.out.println(coffeeMachine.makeCommand(Drink.TEA, 1, 0.7,true));
        
        coffeeMachine.printCommands();
    }
}
