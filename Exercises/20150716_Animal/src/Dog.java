
public class Dog extends Animal {

    @Override
    public void attack() {      // 繼承 Animal 向 CanAttack 引用的 attack ，並覆蓋引用的內容
        System.out.println("狗用牙齒咬");
    }
}