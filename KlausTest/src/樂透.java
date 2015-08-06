
import java.util.ArrayList; // 使用動態陣列需引用

// 此 class 一次只會產出一組樂透獎號
public class 樂透 {

    // 靜態成員
    private static ArrayList 數字陣列;
    private static ArrayList 樂透;
    private static int 索引;    // 它亂數產生的值用來參照數字陣列中的位置
    private static int 抽出號碼;    // 產生的值塞進樂透陣列

    public static ArrayList 產生一組樂透號碼() {    // (傳回動態陣列型別的資料)
        建立數字與樂透陣列();                                       // 1. 分別產生數字與樂透兩個陣列
        將42個號碼放進數字陣列();                               // 2. 把42個號碼塞進數字陣列
        for (int i = 0; i < 6; i++) // 循環6次
        {
            用亂數產生一個陣列索引();
            根據索引從陣列取出號碼();
            將抽出的號碼放進樂透陣列();
        }
        return 樂透; // 產出的一組樂透號碼，回傳 樂透Test

    }

    // 如果沒有單獨建立新陣列物件而在一開始宣告就建立新物件，會因為用的都是同一物件，造成該陣列的值被繼續新增進去
    private static void 建立數字與樂透陣列() {
        數字陣列 = new ArrayList(); // 直接生產 1~42 的值，然後會依索引值取它指定位置上的值，取完後就刪除該值
        樂透 = new ArrayList(); // 放置生產出來的一組樂透獎號
    }

    private static void 將42個號碼放進數字陣列() {
        for (int n = 1; n <= 42; n++) {     // 這裡依序產生 1~42 ，數字陣列(動態)依據放進的數量，長度(size)變為 42
            數字陣列.add(n);
        }
    }

    private static void 用亂數產生一個陣列索引() {
        索引 = (int)(Math.random() * 數字陣列.size()); // 數字陣列.size=42，位置為 0~41，所以亂數範圍需要使之在 0~41 之間
    }

    private static void 根據索引從陣列取出號碼() {
        // ArrayList 使用 Object (萬用型別)
        Object obj = 數字陣列.remove(索引); // 取出索引所指定位置的值，並移除(避免產出的獎號重覆)
        抽出號碼 = (int) obj; // 物件 轉 int 
    }

    private static void 將抽出的號碼放進樂透陣列() {
        樂透.add(抽出號碼);
    }

}
