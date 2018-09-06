
public class Commodity_0001 implements Commodity{
    
    private String name = "掃把";
    private int price = 100;
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getPrice() {
        return this.price;
    }
    
}
