package mde.lbg_cohort4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        take_input();
    }
    public static void take_input(){
        Double price;
        Double quantity;
        Double VAT_rate;
        ArrayList<PurchasedItem> items = new ArrayList<>();
        double total = 0.0;

        System.out.println("Enter each item's price, quantity and VAT rate or enter QUIT to end the program");

        boolean again = true;

        while(again){
            // should be changed to inherit this and specify the type that's reqiured

            UserInterface inter = new UserInterface();
            price = inter.convert("Please enter the item amount: ");
            quantity = inter.convert("Please enter the quantity of items: ");
            VAT_rate = inter.convert("Please enter the VAT rate: ");


            PurchasedItem newPurchase = new PurchasedItem(price,quantity,VAT_rate);
            items.add(newPurchase);
            total += newPurchase.totalPrice();
            System.out.printf("Current total is £%.2f\n",total);

            System.out.println("Enter QUIT to leave, or ENTER to add other items");
            String quit = sc.nextLine();
            again = quit.compareToIgnoreCase("QUIT")!=0;
        }

        System.out.printf("Final total is £%.2f\n",total);

        System.out.println("Items in ascending order are:");
        items.sort(Comparator.comparingDouble(PurchasedItem::totalPrice));
        items.forEach(item -> System.out.printf("£%.2f\n",item.totalPrice()));

    }
}

class UserInterface {
    private Double userInput = 0.0;

    public Double convert(String message) {
        boolean validInput = false;
        do {
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            String rawUserInput = sc.next();
            try {
                this.userInput = Double.parseDouble(rawUserInput);
                validInput = true;
            } catch (NumberFormatException e) {
                if (rawUserInput.compareToIgnoreCase("QUIT") != 0) {
                    System.out.println("Invalid input, please try again");
                } else {
                    validInput = true;
                }
            }
        } while (!validInput);
        return userInput;
    }
}

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