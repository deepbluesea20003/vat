package mde.lbg_cohort4;

import java.util.Scanner;

abstract class DoubleInterface implements CommonInterface {
    @Override
    public void getUserInput() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(this.message);
            String rawUserInput = sc.next();
            try {
                input =  Double.parseDouble(rawUserInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (input==null);
    }

    @Override
    public abstract void displayMessage();

}
