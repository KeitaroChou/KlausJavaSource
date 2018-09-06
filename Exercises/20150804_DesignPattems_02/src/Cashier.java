
public class Cashier {
    
    private Discounts diss;
    private Commodity[] products;
    
    public Cashier(Discounts diss, Commodity[] products) {
        this.diss = diss;
        this.products = products;
    }
    
    public void print() {
        
        String name;
        int total = 0;
        int price  = 0;
        for(int i = 0; i < this.products.length; i++) {
            name = this.products[i].getName();
            price = this.products[i].getPrice();
            total = total + price;
            System.out.println("品名：" + name + "\t價格：" + price);
        }
        
        System.out.println("總金額：" + total + "\t折扣後金額：" + this.diss.saleoff(products));
        
    }
    
}
