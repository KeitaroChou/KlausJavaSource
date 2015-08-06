
public class Airplane implements CanFly {   // 插入會飛的介面，介面可以多個(implements CanFly, xxx, xxx, xxx, ...)

    @Override   // 使用介面 CanFly 提供的 fly()
    public void fly() {
        System.out.println("飛機飛起來了");
    }

}
