
import java.util.ArrayList;

public class 樂透 {

    // 靜態成員
    private static ArrayList 數字陣列;
    private static ArrayList 樂透;
    private static int 索引;
    private static int 抽出號碼;

    // 靜態工廠方法(生產物件用)
    public static ArrayList 產生一組樂透號碼() {
        建立數字與樂透陣列();
        將42個號碼放進數字陣列();
        for (int i = 0; i < 6; i++) // 循環6次
        {
            用亂數產生一個陣列索引();
            根據索引從陣列取出號碼();
            將抽出的號碼放進樂透陣列();
        }
        return 樂透; // 回傳 ArrayList 

    }

    private static void 建立數字與樂透陣列() {
        數字陣列 = new ArrayList();
        樂透 = new ArrayList();
    }

    private static void 將42個號碼放進數字陣列() {
        for (int n = 1; n <= 42; n++) {
            數字陣列.add(n);
        }
    }

    private static void 用亂數產生一個陣列索引() {
        索引 = (int)(Math.random() * 數字陣列.size()); // 0 ~ size()-1
    }

    private static void 根據索引從陣列取出號碼() {
        // ArrayList 使用 Object (萬用型別)
        Object obj = 數字陣列.remove(索引);
        抽出號碼 = (int) obj; // 物件 轉 int 
    }

    private static void 將抽出的號碼放進樂透陣列() {
        樂透.add(抽出號碼);
    }

}
