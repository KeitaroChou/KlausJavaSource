package Game_v1;

public class Monster extends Character {
    
    String treasure;
    
    @Override
    public void display() {
        super.display();
        System.out.println("寶物 " + this.treasure);
    }
    
}
