package mde.lbg_cohort4;

class PurchasedItem{

    private  double price;
    private  int quantity;
    private  int VAT_rate;

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
        return price;
        //return quantity*price*(1+ (double) VAT_rate /100);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVAT_rate() {
        return VAT_rate;
    }

    public void setVAT_rate(int VAT_rate) {
        this.VAT_rate = VAT_rate;
    }
}