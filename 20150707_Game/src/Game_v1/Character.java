package Game_v1;

public class Character {

    // 角色基本素質
    String name;
    int atk;
    int hp;
    Weapon weap;

    // 無來值使用此建構子
    public Character() {
        this("阿米巴原蟲", 1, 1, new Weapon("有彈性的薄膜", 1, 1));              // 引用同名建構子使用 this() (傳回值給下方建構子)
    }

    // 不含武器建構子
    public Character(String name, int atk, int hp) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
    }

    // 含武器建構子
    public Character(String name, int atk, int hp, Weapon weap) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
        this.weap = weap;
    }

    public void display() {
        System.out.println("--------------------");
        System.out.println("名稱 " + this.name);
        System.out.println("力量 " + this.atk);
        System.out.println("生命 " + this.hp);
        // 判斷有傳來武器的值，才執行 Weapon 的內容，否則沒有資料的 Weapon 會造成程式錯誤
        if (weap != null) {
            weap.display();
        }
    }

}