package mde.lbg_cohort4;

import java.util.Scanner;

class StringInterface implements CommonInterface{

    @Override
    public void getUserInput(PurchasedItem item) {
        Scanner sc = new Scanner(System.in);
        //item.set = sc.next();
    }

    @Override
    public void displayMessage() {

    }

}
