
public class Superman implements CanAttack, CanFly {
    
    @Override
    public void attack() {
        System.out.println("超人用雷射光");
    }
    
    @Override
    public void fly() {
        System.out.println("超人飛起來了");
    }
    
}
