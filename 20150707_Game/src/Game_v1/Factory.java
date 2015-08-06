package Game_v1;

public class Factory {
    
    private static int total;

    /**
     * 創建基本角色
     * @return
     */
    public static Player playerDefault() {
        Factory.total++;
        Player playerdef = new Player(1, "初心者", 5, 10, new Weapon("樹枝", 2, 5));
        //Weapon weapdef =  new Weapon("樹枝", ２, ５);
        return playerdef;
    }
    
    /**
     * 創建基本怪物
     * @return static monsterDefault 至 類別 Monster
     */
    public static Monster monsterDefault() {
        Factory.total++;
        Monster monsterdef = new Monster("銅幣", "白兔", 2, 5 );        
        return monsterdef;
    }
    
    public static int getTotal() {
        return Factory.total;
    }
    
}
