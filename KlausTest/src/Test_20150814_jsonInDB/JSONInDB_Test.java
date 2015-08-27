
package Test_20150814_jsonInDB;

// Klaus Librays
import idv.klaus.*;

public class JSONInDB_Test {


    public static void main(String[] args) {
 
//        System.out.println("開始寫入即時位置 ...");
//        JSONInDB_GTLive jidb_gtl = new JSONInDB_GTLive();
        
//        System.out.println("開始刪除 Table ...");
//        TableClear tc1 = new TableClear();
//        tc1.Live();
        
        System.out.println("開始寫入路線圖 ...");
        JSONInDB_GTLineMapV2 jibgtlm = new JSONInDB_GTLineMapV2(0);     // 0 表示不 skip
        
//        System.out.println("開始刪除 Table ...");
//        TableClear tc2 = new TableClear();
//        tc2.LineMap();

    }

}
