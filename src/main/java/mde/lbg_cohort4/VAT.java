package mde.lbg_cohort4;

import java.util.ArrayList;

public class VAT extends DoubleInterface {
    private ArrayList<Double> rates;

    public ArrayList<Double> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Double> rates) {
        this.rates = rates;
    }

    public void addRate(Double rate){
        rates.add(rate);
    }

    @Override
    public void displayMessage() {
        System.out.println("Please enter the quantity: ");
    }
}
