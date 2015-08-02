import java.util.*;

public class HashSetTest {

    public static void main(String[] args) {

        Animal a = new Dog();
        a.setAnimalName("小白狗");
        
        Animal b = new Cat();
        b.setAnimalName("小花貓");
        
        Animal c = new Bird();
        c.setAnimalName("小文鳥");
        
        Animal d = new Cat();
        d.setAnimalName("小花貓");
        
        List<Animal> list = new ArrayList<>();  // 有依放入順序排序，可重複
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        
        Set<Animal> set = new HashSet<>();  // 沒有依放入順序排序，且不可重複(equal()的影響)
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        
        System.out.println(list.toString());
        System.out.println(set.toString());
        
    }
    
}
