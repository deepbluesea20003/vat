package mde.lbg_cohort4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        take_input();
    }
    public static void take_input(){

        Double VAT_rate;
        Double current_item = 0.0;
        ArrayList<Double> items = new ArrayList<>();
        Double total = 0.0;

        VAT_rate = convert("Please enter the VAT rate (%): ");

        System.out.println("Enter each item's amount or enter QUIT to end the program");

        while(current_item != null){

            current_item = convert("Please enter the item amount: ");

            // if null then quit has been entered, so loop will end
            if (current_item != null){
                items.add(current_item);
                total = calculate(items,VAT_rate);
                System.out.printf("Current total is £%.2f\n",total);
            }
        }

        System.out.printf("Final total is £%.2f\n",total);
        System.out.println("Items in ascending order are:");
        Collections.sort(items);
        items.forEach(item -> System.out.printf("£%.2f\n",item));

    }
    public static Double convert(String message){
        do{
            System.out.print(message);
            String user_inp = sc.next();
            try{
                return Double.parseDouble(user_inp);
            }catch (NumberFormatException e){
                if (user_inp.compareToIgnoreCase("QUIT")!=0){
                    System.out.println("Invalid input, please try again");
                }else{
                    return null;
                }
            }
        }while(true);
    }

    public static Double calculate(ArrayList<Double> items, Double rate){
        Double sum = 0.0;
        for(Double item:items) sum += item;

        return sum*(1+rate/100);
    }
}

class PurchasedItem{
    private double price = 0;
    private double quantity = 0;
    private double VAT_rate = 20;

    private PurchasedItem(double price, double quantity, double VAT_rate){
        this.price = price;
        this.quantity = quantity;
        this.VAT_rate = VAT_rate;
    }
    private double totalPrice(){
        return quantity*price*VAT_rate;
    }
}