
public class Commodity_0002 implements Commodity{

    private String name = "椅子";
    private int price = 2500;
    
    @Override
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getPrice() {
        return this.price;
    }
    
}
