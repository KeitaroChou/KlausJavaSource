
public class Bird extends Animal implements CanFly {   // 插入會飛的介面，介面可以多個(implements CanFly, xxx, xxx, xxx, ...)
    
    @Override   // 繼承 Animal 向 CanAttack 引用的 attack ，並覆蓋引用的內容
    public void attack() { // 實作
        System.out.println("鳥用頭撞");
    }

    @Override   // 使用介面 CanFly 提供的 fly()
    public void fly() {
        System.out.println("鳥飛起來");
    }

}
