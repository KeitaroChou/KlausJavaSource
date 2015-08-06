
public class AnimalTest {

    public static void main(String[] args) {

        Animal a = new Dog();
        a.setAnimalName("小黑");
        a.print();
        a.attack();
        System.out.println(a.getAnimalName() + " 字串長度：" + a.getAnimalName().length());
        System.out.println("toString：" + a.toString());        // 列印：類別名稱@物件雜湊碼，toString() 可省略
        
        // 物件相等性
        System.out.println();
        Animal b = new Dog();
        b.setAnimalName("小黑");
        a.print();
        b.print();
        System.out.println("a==b：" + (a==b));      // 比對遙控器所指的實際物件是否相同
        System.out.println("a.equals(b)：" + a.equals(b));      // 這裡是做動物名稱值的比對
        
    }
    
}
