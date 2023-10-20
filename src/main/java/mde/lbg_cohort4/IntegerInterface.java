package mde.lbg_cohort4;

import java.util.Scanner;

class IntegerInterface implements CommonInterface {



    @Override
    public void getUserInput(PurchasedItem item) {
        Scanner sc = new Scanner(System.in);

        do {
            String rawUserInput = sc.next();
            try {
                item.setQuantity(Integer.parseInt(rawUserInput));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (true);
    }

    @Override
    public void displayMessage() {

    }
}