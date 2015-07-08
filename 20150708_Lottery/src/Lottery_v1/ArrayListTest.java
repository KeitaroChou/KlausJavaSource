package Lottery_v1;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {

        // 可調式陣列
        ArrayList arrlist = new ArrayList();
        arrlist.add(15);
        arrlist.add("Tom");
        arrlist.add(1235.265);
        arrlist.add("Apple");
        System.out.println("arrlist = " + arrlist);
        System.out.println("arrlist 大小：" + arrlist.size());
        Object arrlistobj = arrlist.get(3);
        System.out.println("arrlist.get(3) = " + arrlistobj);
        arrlistobj = arrlist.remove(3);
        System.out.println("arrlist.remove(3) > " + arrlistobj);
        System.out.println("arrlist = " + arrlist);
        System.out.println("arrlist 大小：" + arrlist.size());

        // 亂數生成
        System.out.println("-------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println(Math.random() * 10);                 // 產生的亂數進1位，範圍為 0.0000... ~ 9.9999...
        }
        System.out.println("-------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println(Math.random() * 100);                // 產生的亂數進2位，範圍為 0.0000... ~ 99.9999...
        }
        System.out.println("-------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println((Math.random() * 100) + 1);      // 產生的亂數進2位，範圍為 1.0000... ~ 99.9999...
        }
        System.out.println("-------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println((int) (Math.random() * 100) + 1);     // 產生的亂數進2位並轉換為整數，範圍為 1 ~ 99
        }
    }
}
