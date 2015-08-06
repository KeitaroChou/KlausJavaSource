package Game_v1;

public class Character {

    // 角色基本素質
    private String name;
    private int atk;
    private int hp;
    private Weapon weap;    // 把類別 Weapon 當型別宣告

    /**
     * 單獨設定名稱
     *
     * @param name
     */
    public void setName(String name) {
        if (name != null && !name.equals("Fuck")) {
            this.name = name;
            System.out.println("名稱 " + this.name);
        } else {
            System.out.println("錯誤的輸入名稱 " + name);
        }
    }

    /**
     * 單獨設定生命值
     *
     * @param hp
     */
    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
            System.out.println("生命 " + this.hp);
        } else {
            System.out.println("錯誤的輸入數值 " + hp);
        }
    }

    /**
     * 無來值使用此建構子
     */
    public Character() {
        this("阿米巴原蟲", 1, 1, new Weapon("有彈性的薄膜", 1, 1));              // 引用同名建構子使用 this() (傳回值給下方建構子)
    }

    /**
     * 不含武器建構子
     *
     * @param name @param atk @param hp
     */
    public Character(String name, int atk, int hp) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
    }

    /**
     * 角色含武器建構子
     *
     * @param name @param atk @param hp @param weap
     */
    public Character(String name, int atk, int hp, Weapon weap) {
        this.name = name;
        this.atk = atk;
        this.hp = hp;
        this.weap = weap;
    }

    /**
     * 單獨傳回名稱
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * 單獨傳回生命值
     *
     * @return hp
     */
    public int getHp() {
        System.out.print("取回的名稱 ");
        return this.hp;
    }

    /**
     * 單獨設定武器
     *
     * @param weap
     */
    public void setWeap(Weapon weap) {
        this.weap = weap;
    }

    /**
     * 單獨傳回武器
     *
     * @return weapon
     */
    public Weapon getWeap() {
        return this.weap;
    }

    /**
     * 顯示角色資訊
     */
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
