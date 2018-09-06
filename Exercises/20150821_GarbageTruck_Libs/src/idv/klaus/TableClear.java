package idv.klaus;

import java.sql.*;

public class TableClear {

    private final String driverName = "com.mysql.jdbc.Driver";
    // 引入連接資料庫資訊
    private final DBLinker_klaus dblinker = new DBLinker_klaus();
    private final String connectionString = dblinker.toString();
    private Connection connection = null;
    private PreparedStatement insertPS = null;

    public void LineMap() {

        // Table 刪除
        try {

            // 載入 JDBC driver class (Library 需載入 MySQL JDBC driver)
            Class.forName(driverName);
            // 得到 Connection
            connection = DriverManager.getConnection(connectionString);  // connectionString 爲資料庫連線資料
            insertPS = connection.prepareStatement("TRUNCATE TABLE jsonIn_GarbageTruckLineMap");
            insertPS.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("[✓] 資料表 jsonIn_GarbageTruckLineMap 刪除完成");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

    }

    public void Live() {
        
        // Table 刪除
        try {

            // 載入 JDBC driver class (Library 需載入 MySQL JDBC driver)
            Class.forName(driverName);
            // 得到 Connection
            connection = DriverManager.getConnection(connectionString);  // connectionString 爲資料庫連線資料
            insertPS = connection.prepareStatement("TRUNCATE TABLE jsonIn_GarbageTruckLive");
            insertPS.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {

            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("[✓] 資料表 jsonIn_GarbageTruckLive 刪除完成");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }
}
