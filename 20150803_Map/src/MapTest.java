import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put(10, 3322654);       // 用 key 當索引，指定 value 給 map
        map.put(11, "abc");
        
        Object obj = map.get(11);       // 用 key 來連值
        System.out.println(obj);
        
        // -------------------------------------------------------------------------
        
        Map<Integer, String> map2 = new HashMap();      // 泛型，限定 key 為 Integer，value 為 String
        map2.put(110, "王大同");
        map2.put(111, "林道德");
        
        String val1 = map2.get(110);        // 前面因為使用泛型，指定 value 為 String，所以不須再用 Object 宣告變數，直接使用 String
        String val2 = map2.get(111);
        System.out.println(val1 + "\t" + val2);
        
        // -------------------------------------------------------------------------
        
        
        
    }
    
}
