package mde.lbg_cohort4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        take_input();
    }
    public static void take_input(){
        Double price;
        Double quantity;
        int VAT_rate;
        ArrayList<PurchasedItem> items = new ArrayList<>();
        double total = 0.0;

        System.out.println("Enter each item's price, quantity and VAT rate or enter QUIT to end the program");

        String quit = "";

        while(quit.compareToIgnoreCase("QUIT")!=0){
            // should be changed to inherit this and specify the type that's reqiured

            StringInterface stringInter = new StringInterface();
            IntegerInterface intInter = new IntegerInterface();
            DoubleInterface doubleInter = new DoubleInterface();

            doubleInter.getUserInput("Please enter the item price: ");
            price = doubleInter.getInput();
            doubleInter.getUserInput("Please enter the quantity of items: ");
            quantity = doubleInter.getInput();
            intInter.getUserInput("Please enter the VAT rate: ");
            VAT_rate = intInter.getInput();


            PurchasedItem newPurchase = new PurchasedItem(price,quantity,VAT_rate);
            items.add(newPurchase);
            total += newPurchase.totalPrice();
            System.out.printf("Current total is £%.2f\n",total);

            stringInter.getUserInput("Enter QUIT to leave, or ENTER to add other items\n");
            quit = stringInter.getInput();
        }

        System.out.printf("Final total is £%.2f\n",total);

        System.out.println("Items in ascending order are:");
        items.sort(Comparator.comparingDouble(PurchasedItem::totalPrice));
        items.forEach(item -> System.out.printf("£%.2f\n",item.totalPrice()));

    }
}

// this is stupid to be done like this
class InterfaceFactory{


}

interface CommonInterface{
    void getUserInput(String message);
}

class StringInterface implements CommonInterface{
    private String input;
    @Override
    public void getUserInput(String message) {
        System.out.print(message);
        Scanner sc = new Scanner(System.in);
        input = sc.next();
    }

    public String getInput() {
        return input;
    }
}

class IntegerInterface implements CommonInterface {
    private Integer input = null;
    @Override
    public void getUserInput(String message) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(message);
            String rawUserInput = sc.next();
            try {
                input = Integer.parseInt(rawUserInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (input == null);
    }

    public int getInput() {
        return input;
    }
}

class DoubleInterface implements CommonInterface {
    private Double input = null;
    @Override
    public void getUserInput(String message) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(message);
            String rawUserInput = sc.next();
            try {
                input =  Double.parseDouble(rawUserInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (input==null);

    }

    public Double getInput() {
        return input;
    }
}


//class UserInterface {
//    private Double userInput = 0.0;
//
//    public Double convert(String message) {
//        boolean validInput = false;
//        do {
//            System.out.print(message);
//            Scanner sc = new Scanner(System.in);
//            String rawUserInput = sc.next();
//            try {
//                this.userInput = Double.parseDouble(rawUserInput);
//                validInput = true;
//            } catch (NumberFormatException e) {
//                if (rawUserInput.compareToIgnoreCase("QUIT") != 0) {
//                    System.out.println("Invalid input, please try again");
//                } else {
//                    validInput = true;
//                }
//            }
//        } while (!validInput);
//        return userInput;
//    }
//}

class PurchasedItem{
    private final double price;
    private final double quantity;
    private final double VAT_rate;

    PurchasedItem(double price, double quantity, double VAT_rate){
        this.price = price;
        this.quantity = quantity;
        this.VAT_rate = VAT_rate;
    }
    final double totalPrice(){
        return quantity*price*(1+VAT_rate/100);
    }
}