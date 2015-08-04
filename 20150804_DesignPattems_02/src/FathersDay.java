
public class FathersDay implements Discounts {
    
    @Override
    public int saleoff(Commodity[] products) {
        
        int sum = 0;
        for (int i = 0; i < products.length; i++) {    // 迴圈巡迴
            sum = sum + products[i].getPrice();
        }
        float saled = (float)sum * 0.6f;        // 六折
        return (int)saled;
        
    }
    
}
