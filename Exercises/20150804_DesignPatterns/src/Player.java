
// ===========================
// Player 依賴 抽象的 Weapon 介面
// ===========================

public class Player {
    
    Weapon w;
    Restore re;
    
    // 被使用 attack 時，引用 Weapon.attack
    public void attack() {
        w.attack();     // Weapon.attack
    }
    
    public void restoreHP() {
        re.restoreHP();
    }
    
}
