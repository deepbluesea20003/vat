package mde.lbg_cohort4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        Main mm = new Main();
        mm.run_program();
    }
    public void run_program(){

        ArrayList<PurchasedItem> items = new ArrayList<>();
        double total = 0.0;

        System.out.println("Enter each item's price, quantity and VAT rate or enter QUIT to end the program");

        String quit = "";

        Price prices = new Price();
        Quantity quantities = new Quantity();
        VAT rates = new VAT();

        ArrayList<CommonInterface> values = new ArrayList<>();
        values.add(prices);
//        values.add(quantities);
//        values.add(rates);

        while(quit.compareToIgnoreCase("QUIT")!=0){
            PurchasedItem newItem = new PurchasedItem();
            for(CommonInterface value:values) {
                value.displayMessage();
                value.getUserInput( newItem );
            }

            items.add(newItem);
            total += newItem.totalPrice();
            System.out.printf("Current total is £%.2f\n",total);

            System.out.println("Enter QUIT to leave, or ENTER to add other items\n");
            Scanner sc = new Scanner(System.in);
            quit = sc.next();
        }

        System.out.printf("Final total is £%.2f\n",total);

        System.out.println("Items in ascending order are:");
        items.sort(Comparator.comparingDouble(PurchasedItem::totalPrice));
        items.forEach(item -> System.out.printf("£%.2f\n",item.totalPrice()));

    }
}

interface CommonInterface{
    void getUserInput( PurchasedItem item);

    void displayMessage();
}







