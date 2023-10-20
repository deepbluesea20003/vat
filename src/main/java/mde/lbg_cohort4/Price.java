package mde.lbg_cohort4;

import java.util.ArrayList;

public class Price extends DoubleInterface {
    private ArrayList<Double> prices;

    public ArrayList<Double> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Double> prices) {
        this.prices = prices;
    }

    public void addPrice(Double price){
        prices.add(price);
    }

    @Override
    public void displayMessage() {
        System.out.println("Please enter the price: ");
    }
}
