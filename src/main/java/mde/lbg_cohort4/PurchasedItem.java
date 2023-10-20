package mde.lbg_cohort4;

class PurchasedItem{
    private final double price;
    private final int quantity;
    private final int VAT_rate;

    PurchasedItem(double price, int quantity, int VAT_rate){
        this.price = price;
        this.quantity = quantity;
        this.VAT_rate = VAT_rate;
    }

    PurchasedItem(){
        this.price=0;
        this.quantity=0;
        this.VAT_rate=0;
    }
    final double totalPrice(){
        return quantity*price*(1+ (double) VAT_rate /100);
    }
}