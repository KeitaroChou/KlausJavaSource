
public class Pet_01 implements Weapon, Restore {
    
    @Override
    public void attack() {
        System.out.println("皮卡丘使用了十萬伏特");
    }
    
    @Override
    public void restoreHP() {
        System.out.println("皮卡丘幫忙恢復了HP");
    }
    
}
