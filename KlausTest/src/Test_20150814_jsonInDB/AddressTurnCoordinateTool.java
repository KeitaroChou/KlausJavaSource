// ==========================================
// ＤＢ讀取地址、丟出處理、座標寫入ＤＢ
// ==========================================

package Test_20150814_jsonInDB;

import java.sql.*;

public class AddressTurnCoordinateTool {

    public static void main(String[] args) {
        
        String driverName = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://104.155.229.208:3306/jsonInDB?" + "user=klaustest&password=20150709&useUnicode=true&characterEncoding=utf-8";

        try {

            // 載入 JDBC driver class (Library 需載入 MySQL JDBC driver)
            Class.forName(driverName);
            // 得到 Connection
            Connection connection = DriverManager.getConnection(connectionString);

            // 用於執行 SQL 語句的 Statement
            Statement statement = connection.createStatement();

            // 執行 SQL 語句
            String selectSQL = "SELECT REPLACE(location, '附近', '') AS location FROM jsonIn_GarbageTruckLive";     // 直接做 REPLACE 欄位名稱會被變更，resultSet 就抓不到了，所以需再更名為 location
//            String selectSQL = "SELECT * FROM jsonIn_GarbageTruckLive";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            
            // 計數器
            int counter = 0;
            
            while (resultSet.next()) {

                System.out.println(counter);
                // 抓取地址欄位資料
                String address = resultSet.getString("location");
                AddressTurnCoordinate atc = new AddressTurnCoordinate(address);
                System.out.println(address);
                System.out.println(atc);
                counter++;

            }
            System.out.println("[✓] 共處理 " + counter + " 筆地址");

            statement.close();      // 關閉 Statement
            connection.close();     // 關閉 Connection

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }

}
