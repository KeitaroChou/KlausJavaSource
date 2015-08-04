
public class PlayTest {

    public static void main(String[] args) {

        // 武器實作 Weapon 介面、角色使用 Weapon 介面，角色 attack 直接引用 Weapon.attack 使用
        Player p1 = new Player();        // 新創角色 play1
        p1.w = new Weapon_01();      // 彈性化，可以隨時換武器
        p1.attack();
        p1.w = new Weapon_02();      // 因為 Weapon_02 實裝了 Weapon，所以 w 可以直接引用
        p1.attack();
        p1.w = new Pet_01();
        p1.attack();
        p1.re = new Pet_01();
        p1.restoreHP();
        
        System.out.println("=================");
        
        // 方法委派
        Player02 p2 = new Player02(new Weapon_01());        // 開新角色(物件)，裝上武器
        p2.attack();        // 委派後，使用攻擊
        
        System.out.println("=================");
        
        p2.setW(new Weapon_02());
        p2.attack();
        
    }
    
}
