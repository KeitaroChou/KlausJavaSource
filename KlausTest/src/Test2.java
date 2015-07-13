
import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {
        
        ArrayList 五組樂透 = new ArrayList();   // 放置所需的 5 組陣列
        
        for(int i = 0 ; i < 5 ; i++) { // 產生 5 組
            ArrayList 一組樂透 = 樂透.產生一組樂透號碼();   // 動態陣列
            五組樂透.add(一組樂透);
        }
        for(Object obj : 五組樂透) { // 走訪陣列，每次讀取一個物件到 obj ，迴圈一次一組
            System.out.println(obj);
        }

    }

}
