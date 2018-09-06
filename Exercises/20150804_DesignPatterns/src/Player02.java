
// ===========================
// 方法委派
// ===========================

public class Player02 {
    
    // 封裝欄位
    private Weapon w;       // 有一個 HAS-A
    
    // 建構子
    public Player02(Weapon w) {     // 把傳來的武器要求，向有實裝 Weapon 的類別連結
        this.w = w;
    }
    
    public Weapon getW() {
        return this.w;
    }
    
    public void setW(Weapon w) {
        this.w = w;
    }
    
    public void attack() {
        
        if(w != null) {
            this.w.attack();        // 方法委派(Weapon.attack)
        }
        
    }
    
}
