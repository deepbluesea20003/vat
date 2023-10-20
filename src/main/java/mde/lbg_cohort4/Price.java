package mde.lbg_cohort4;

import java.util.ArrayList;

public class Price extends DoubleInterface {
    public void getValue( PurchasedItem item ){
        this.getUserInput( item );
    }

    @Override
    public void displayMessage() {
        System.out.println("Please enter the price: ");
    }
}
