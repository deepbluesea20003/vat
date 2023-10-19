package mde.lbg_cohort4;

import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        take_input();
    }
    public static void take_input(){
        float amount;
        float VAT_rate;
        float total;
        String again;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Please enter the amount:");
            amount = sc.nextFloat();
            System.out.println("Please enter the VAT rate (%):");
            VAT_rate = sc.nextFloat();
            total = calculate(amount,VAT_rate);
            System.out.println("Total: £" + total);
            System.out.println("Quit application by typing QUIT, enter to continue");
            again = sc.next();
        }while(!Objects.equals(again, "QUIT"));
    }

    public static float calculate(float amount, float rate){
        return amount*(1+rate/100);
    }
}