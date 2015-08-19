
// ==========================================
// 擷取新北市垃圾車路線資料(ＪＳＯＮ)
// 並寫入ＤＡＴＡＢＡＳＳ
// ==========================================

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

public class jsonInDB_GarbageTruckLineMap {

    public static void main(String[] args) {

        // 連結資料庫
        String driverName = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://104.155.229.208:3306/jsonInDB?" + "user=klaustest&password=20150709&useUnicode=true&characterEncoding=utf-8";

        String xmlResponse = null;  // 需要先初始化

//        int status = 0;

        // 讀入引用連結內的資料
        try {

            System.out.println("[↓] 開始讀取 ＪＳＯＮ 資料 ...");
            
            URL url = new URL("http://data.ntpc.gov.tw/od/data/api/EDC3AD26-8AE7-4916-A00B-BC6048D19BF8?$format=json");     // 抓取網頁位址
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
        PreparedStatement insertPS = null;
        PreparedStatement truncateTablePS = null;
        int counter = 0;                    // ＤＢ寫入次數計數器
        
        // DB 寫入
        try {
            
            // 載入 JDBC driver class (Library 需載入 MySQL JDBC driver)
            Class.forName(driverName);
            // 得到 Connection
            connection = DriverManager.getConnection(connectionString);  // connectionString 爲資料庫連線資料
            // 用於執行 SQL 語句的 Statement
            Statement statement = connection.createStatement();
            // 抓到的網頁內容轉型、丟入 JSONArray
            jsonarray = (JSONArray) parser.parse(xmlResponse);
            // 資料表清空
            truncateTablePS = connection.prepareStatement("TRUNCATE TABLE jsonIn_GarbageTruckLineMap");
            System.out.println("[!] 已清空資料表");
            
            System.out.println("[↑] 開始寫入 ＤＢ ...");

            for (Object o : jsonarray) {
                
                // 資料寫入
                insertPS = connection.prepareStatement("INSERT INTO jsonIn_GarbageTruckLineMap values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                person = (JSONObject) o;

                String city = (String) person.get("linename");      // 新北市府編錯
                insertPS.setString(1, city);

                String lineid = (String) person.get("city");        // 新北市府編錯
                insertPS.setString(2, lineid);

                String linename = (String) person.get("lineid");    // 新北市府編錯
                insertPS.setString(3, linename);

                String rank = (String) person.get("rank");
                insertPS.setString(4, rank);

                String name = (String) person.get("name");
                insertPS.setString(5, name);

                String village = (String) person.get("village");
                insertPS.setString(6, village);

                String longitude = (String) person.get("longitude");
                insertPS.setString(7, longitude);

                String latitude = (String) person.get("latitude");
                insertPS.setString(8, latitude);

                String time = (String) person.get("time");
                insertPS.setString(9, time);

                String memo = (String) person.get("memo");
                insertPS.setString(10, memo);

                String garbage_sun = (String) person.get("garbage_sun");
                insertPS.setString(11, garbage_sun);

                String garbage_mon = (String) person.get("garbage_mon");
                insertPS.setString(12, garbage_mon);

                String garbage_tue = (String) person.get("garbage_tue");
                insertPS.setString(13, garbage_tue);

                String garbage_wed = (String) person.get("garbage_wed");
                insertPS.setString(14, garbage_wed);

                String garbage_thu = (String) person.get("garbage_thu");
                insertPS.setString(15, garbage_thu);

                String garbage_fri = (String) person.get("garbage_fri");
                insertPS.setString(16, garbage_fri);

                String garbage_sat = (String) person.get("garbage_sat");
                insertPS.setString(17, garbage_sat);

                String recycling_sun = (String) person.get("recycling_sun");
                insertPS.setString(18, recycling_sun);

                String recycling_mon = (String) person.get("recycling_mon");
                insertPS.setString(19, recycling_mon);

                String recycling_tue = (String) person.get("recycling_tue");
                insertPS.setString(20, recycling_tue);

                String recycling_wed = (String) person.get("recycling_wed");
                insertPS.setString(21, recycling_wed);

                String recycling_thu = (String) person.get("recycling_thu");
                insertPS.setString(22, recycling_thu);

                String recycling_fri = (String) person.get("recycling_fri");
                insertPS.setString(23, recycling_fri);

                String recycling_sat = (String) person.get("recycling_sat");
                insertPS.setString(24, recycling_sat);

                String foodscraps_sun = (String) person.get("foodscraps_sun");
                insertPS.setString(25, foodscraps_sun);

                String foodscraps_mon = (String) person.get("foodscraps_mon");
                insertPS.setString(26, foodscraps_mon);

                String foodscraps_tue = (String) person.get("foodscraps_tue");
                insertPS.setString(27, foodscraps_tue);

                String foodscraps_wed = (String) person.get("foodscraps_wed");
                insertPS.setString(28, foodscraps_wed);

                String foodscraps_thu = (String) person.get("foodscraps_thu");
                insertPS.setString(29, foodscraps_thu);

                String foodscraps_fri = (String) person.get("foodscraps_fri");
                insertPS.setString(30, foodscraps_fri);

                String foodscraps_sat = (String) person.get("foodscraps_sat");
                insertPS.setString(31, foodscraps_sat);

//                status ps.executeUpdate();
                insertPS.executeUpdate();     // ？？？
                
                counter++;

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
                    System.out.println("[√] ＤＢ 寫入完成，共寫入 " + counter + " 筆資料");
                }
            } catch (Exception e4) {
                System.out.println(e4);
            }
        }
//        return status;

    }

}