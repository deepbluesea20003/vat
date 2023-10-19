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

        while(true){

            price = convert("Please enter the item amount: ");
            if (price == null) break;

            quantity = convert("Please enter the quantity of items: ");
            if (quantity == null) break;

            VAT_rate = convert("Please enter the VAT rate: ");
            if (VAT_rate == null) break;

            PurchasedItem newPurchase = new PurchasedItem(price,quantity,VAT_rate);
            items.add(newPurchase);
            total += newPurchase.totalPrice();
            System.out.printf("Current total is £%.2f\n",total);

        }

        System.out.printf("Final total is £%.2f\n",total);

        System.out.println("Items in ascending order are:");
        items.sort(Comparator.comparingDouble(PurchasedItem::totalPrice));
        items.forEach(item -> System.out.printf("£%.2f\n",item.totalPrice()));

    }
}

class Interface{
    private Double userInput = 0.0;
    private boolean quit = false;
    public void convert(String message){
        do{
            System.out.print(message);
            Scanner sc = new Scanner(System.in);
            String rawUserInput = sc.next();
            boolean validInput = false;

            try{
                this.userInput =  Double.parseDouble(rawUserInput);
            }catch (NumberFormatException e){
                if (rawUserInput.compareToIgnoreCase("QUIT")!=0){
                    System.out.println("Invalid input, please try again");
                }else{
                    quit=true;
                }
            }
        }while(userInput == 0.0);
    }

    public Double getUserInput() {
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