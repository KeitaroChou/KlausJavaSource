import java.util.*;

public class TreeSetTest {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();     // 不重複，會排序
        set.add(10);
        set.add(15);
        set.add(10);
        set.add(8);
        Set<String> set2 = new TreeSet<>();     // 不重複，會排序
        set2.add("C");
        set2.add("A");
        set2.add("C");
        set2.add("B");
        System.out.println(set);
        System.out.println(set2);
        
        Animal a = new Dog();
        a.setAnimalName("ペロペロ");
        Animal b = new Cat();
        b.setAnimalName("小花");
        Animal c = new Bird();
        c.setAnimalName("小文文");
//        int result = a.compareTo(c);
//        System.out.println("a.compareTo(c) = " + result);
        
        Set<Animal> set3 = new TreeSet<>();          // 不重複，會排序。物件的比較排序，需要使用介面 Comparable 來實作，不然會發生 ClassCastException 錯誤
        set3.add(a);
        set3.add(b);
        set3.add(c);
        System.out.println(set3);
        
    }
    
}
