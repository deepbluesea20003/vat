package mde.lbg_cohort4;

import java.util.ArrayList;

public class Quantity extends IntegerInterface {
    private ArrayList<Integer> quantities;

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(ArrayList<Integer> quantities) {
        this.quantities = quantities;
    }

    public void addQuantity(Integer quantity){
        quantities.add(quantity);
    }
}