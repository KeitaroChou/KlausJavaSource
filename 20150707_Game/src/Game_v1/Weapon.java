package Game_v1;

public class Weapon {

    // 武器基本素質
    String name;
    int atk;
    int durability;

    // 來值建構子
    public Weapon(String name, int atk, int durability) {
        this.name = name;
        this.atk = atk;
        this.durability = durability;
    }

    // 供呼叫傳回值用
    public void display() {
        System.out.println(this.name + " 殺傷力:" + this.atk + " 耐久度:" + this.durability);
    }

}
