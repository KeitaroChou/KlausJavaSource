package Game_v1;

public class Player extends Character {         // 子類別 Player 繼承父類別 Character
    
    // 玩家專有素質，其餘另外引用父類別
    int level;

    /**
     * 無來值使用此建構子
     */
    public Player() {
        super("路人甲", 5, 5, new Weapon("木棒", 2, 2));          // 傳回資料給父類別建構子
        this.level = 1;
    }

    /**
     * 不含武器建構子
     * @param level @param name @param atk @param hp
     */
    public Player(int level, String name, int atk, int hp) {
        super(name, atk, hp);
        this.level = level;
    }

    /**
     * 含武器建構子
     * @param level @param name @param atk @param hp @param weap
     */
    public Player(int level, String name, int atk, int hp, Weapon weap) {
        super(name, atk, hp, weap);
        this.level = level;
    }

    // 引用父類別 Character 的函數另加上自己的指令
    @Override
    public void display() {
        super.display();
        System.out.println("等級 " + this.level);
    }

}