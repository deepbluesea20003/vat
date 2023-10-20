package mde.lbg_cohort4;

import java.util.ArrayList;
import java.util.Scanner;

abstract class DoubleInterface implements CommonInterface {

    @Override
    public void getUserInput(PurchasedItem item ) {
        Scanner sc = new Scanner(System.in);

        do {
            String rawUserInput = sc.next();
            try {
                this.input =  Double.parseDouble(rawUserInput);
                item.setPrice( input );
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (input==null);
    }

    @Override
    public abstract void displayMessage();

}
