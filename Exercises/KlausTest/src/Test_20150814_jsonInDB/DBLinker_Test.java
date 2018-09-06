package Test_20150814_jsonInDB;

import idv.klaus.DBLinker_klaus;

public class DBLinker_Test {

    public static void main(String[] args) {

        // MySQL JDBC Driver
        String driverName = "com.mysql.jdbc.Driver";

        // 引入連接資料庫資訊
        DBLinker_klaus dblinker = new DBLinker_klaus();
        System.out.println(dblinker);

    }

}
