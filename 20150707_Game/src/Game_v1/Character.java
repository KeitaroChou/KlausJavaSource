package Game_v1;

public class Character {

    String name;
    int ATK;
    int HP;
    
    public void display() {
        System.out.println("名稱 " + this.name);
        System.out.println("力量 " + this.ATK);
        System.out.println("生命 " + this.HP);
    }
    
}
