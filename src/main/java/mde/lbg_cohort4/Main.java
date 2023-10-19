package mde.lbg_cohort4;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        take_input();
    }
    public static void take_input(){

        float VAT_rate;
        Float current_item;
        ArrayList<Float> items = new ArrayList<>();
        float total;


        System.out.println("Please enter the VAT rate (%):");
        VAT_rate = sc.nextFloat();

        System.out.println("Enter each item's amount or enter QUIT to end the program");

        String input_amount = "";

        while(!Objects.equals(input_amount, "QUIT")){

            current_item = convert("Please enter the item amount:");

            // if null then quit has been entered
            if (current_item == null){
                break;
            }

            items.add(current_item);
            total = calculate(items,VAT_rate);
            System.out.println("Current total is £"+total);
        }

        System.out.println("Final total is £"+calculate(items,VAT_rate));

    }
    public static Float convert(String message){
        do{
            System.out.println(message);
            String user_inp = sc.next();
            try{
                return Float.parseFloat(user_inp);
            }catch (NumberFormatException e){
                if (user_inp.compareToIgnoreCase("QUIT")!=0){
                    System.out.println("Invalid input, please try again");
                }else{
                    return null;
                }
            }
        }while(true);
    }

    public static float calculate(ArrayList<Float> items, float rate){
        float sum = 0;
        for(Float item:items) sum += item;

        return sum*(1+rate/100);
    }
}