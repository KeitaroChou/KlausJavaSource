package Game_v1;

public class Monster extends Character {
    
    // 怪物專有素質，其餘另外引用父類別
    String treasure;

    // 不含武器建構子
    public Monster(String treasure, String name, int atk, int hp) {
        super(name, atk, hp);
        this.treasure = treasure;
    }

    // 含武器建構子
    public Monster(String treasure, String name, int atk, int hp, Weapon weap) {
        super(name, atk, hp, weap);
        this.treasure = treasure;
    }
    
    // 引用父類別 Character 的函數另加上自己的指令
    @Override
    public void display() {
        super.display();
        System.out.println("寶物 " + this.treasure);
    }

}