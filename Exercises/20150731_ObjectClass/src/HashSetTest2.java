
import java.util.*;


public class HashSetTest2 {

    public static void main(String[] args) {

        String[] fruit = {"蘋果", "香蕉", "鳳梨", "西瓜", "西瓜", "西瓜", "蘋果"};
        Set set = new HashSet();    // Set.HashSet
        
        for(String s : fruit) {     // 陣列裡的值用迴圈丟進 set
            set.add(s);
        }
        
        System.out.println("一共有 " + set.size() + " 種水果");
        System.out.println(set);
        
    }
    
}
