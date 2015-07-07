package Game_v1;

public class Player extends Character {
    
    int level;
    
    @Override
    public void display() {
        super.display();
        System.out.println("等級 " + this.level);
    }
    
}
