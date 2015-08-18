
package Test_20150814_jsonInDB;

// 讀入引用連結內的資料
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// ＳＱＬ
import java.sql.*;

// ＪＳＯＮ
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// Exception
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class jsonInDB_GarbageTruckLive {

    public static void main(String[] args) {

        // 連結資料庫
        String driverName = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://104.155.229.208:3306/jsonInDB?" + "user=klaustest&password=20150709&useUnicode=true&characterEncoding=utf-8";

        String xmlResponse = null;  // 需要先初始化

//        int status = 0;

        // 讀入引用連結內的資料
        try {

            System.out.println("[↓] 開始讀取 ＪＳＯＮ 資料 ...");
            
            URL url = new URL("http://data.ntpc.gov.tw/od/data/api/28AB4122-60E1-4065-98E5-ABCCB69AACA6?$format=json");     // 抓取網頁位址
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();   // 用 HttpURLConnection 開啟(建立連線)

            // BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "UTF-8"));
            InputStreamReader isr = new InputStreamReader(huc.getInputStream(), "UTF-8");   // 串流讀取連結內資料

            try (BufferedReader br = new BufferedReader(isr)) {     // 讀檔緩衝 

                String str = "";
                StringBuilder sb = new StringBuilder();

                while (null != ((str = br.readLine()))) {
                    sb.append(str);
                }

                xmlResponse = sb.toString();
                br.close();             // 關閉資源
                System.out.println("[√] ＪＳＯＮ 資料讀取完成");

            }
            huc.disconnect();       // 關閉連線

        } catch (IOException e) {
            System.out.println(e);
        }

        Connection connection = null;
        JSONParser parser = new JSONParser();
        JSONArray jsonarray;
        JSONObject person;
        PreparedStatement ps = null;

        
        // DB 寫入
        try {

            System.out.println("[↑] 開始寫入 ＤＢ ...");
            
            // 載入 JDBC driver class (Library 需載入 MySQL JDBC driver)
            Class.forName(driverName);
            // 得到 Connection
            connection = DriverManager.getConnection(connectionString);  // connectionString 爲資料庫連線資料
            // 用於執行 SQL 語句的 Statement
            Statement statement = connection.createStatement();
            // 抓到的網頁內容轉型、丟入 JSONArray
            jsonarray = (JSONArray) parser.parse(xmlResponse);

            for (Object o : jsonarray) {

                ps = connection.prepareStatement("INSERT INTO jsonIn_GarbageTruckLive values (?, ?, ?, ?)");

                person = (JSONObject) o;

                String lineid = (String) person.get("lineid");
                ps.setString(1, lineid);

                String car = (String) person.get("car");
                ps.setString(2, car);

                String time = (String) person.get("time");
                ps.setString(3, time);

                String location = (String) person.get("location");
                ps.setString(4, location);

//                status ps.executeUpdate();
                ps.executeUpdate();     // ？？？

            }

        } catch (ParseException e1) {
            System.out.println(e1);
        } catch (ClassNotFoundException e2) {
            System.out.println(e2);
        } catch (SQLException e3) {
            System.out.println(e3);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("[√] ＤＢ 寫入完成");
                }
            } catch (Exception e4) {
                System.out.println(e4);
            }
        }
        
    }
    
}
