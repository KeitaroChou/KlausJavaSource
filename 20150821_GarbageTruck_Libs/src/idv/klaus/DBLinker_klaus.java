// ==========================================
// MySQL 資料庫連結器
// for Klaus' Macbook Air localhost
// ==========================================

package idv.klaus;

public class DBLinker_klaus {

    // 常數大寫，底線分開
    
    private final String IP = "klaus-macbook-air.local";
    private final String PORT = "3306";
    private final String DATABASS_NAME = "test";
    private final String USER = "klaus";
    private final String PW = "klaus580925";
    
//    private final String IP = "104.155.229.208";
//    private final String PORT = "3306";
//    private final String DATABASS_NAME = "jsonInDB";
//    private final String USER = "klaustest";
//    private final String PW = "20150709";
    
    private final String CONNECTION_STRING = "jdbc:mysql://" + this.IP + ":" + this.PORT + "/" + this.DATABASS_NAME + "?" + "user=" + this.USER + "&password=" + this.PW + "&useUnicode=true&characterEncoding=utf-8";
    
    
    @Override
    public String toString() {
        return this.CONNECTION_STRING;
    }

}
