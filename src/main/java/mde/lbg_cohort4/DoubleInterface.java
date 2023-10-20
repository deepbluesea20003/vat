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
                item.setPrice(Double.parseDouble(rawUserInput));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (true);
    }

    @Override
    public abstract void displayMessage();

}
