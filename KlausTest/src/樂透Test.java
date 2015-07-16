
import java.util.ArrayList;

public class 樂透Test {

    public static void main(String[] args) {
        
        ArrayList 五組樂透 = new ArrayList();   // 放置生產出的 5 組樂透獎號
        
        for(int i = 0 ; i < 5 ; i++) { // 產生 5 組樂透獎號
            ArrayList 一組樂透 = 樂透.產生一組樂透號碼();   // 動態陣列
            五組樂透.add(一組樂透);
        }
        for(Object obj : 五組樂透) { // 走訪陣列，每次讀取一個物件到 obj ，一次一組
            System.out.println(obj);
        }

    }

}
