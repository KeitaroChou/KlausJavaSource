// =======================================================
// 元件名稱：JSONInDB_GarbageTruckLive
// 功能：擷取新北市垃圾車即時資料(ＪＳＯＮ)，並寫入ＤＡＴＡＢＡＳＳ
// =======================================================

package idv.klaus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONInDB_GTLive {
    
    static DBLinker_klaus dblinker = new DBLinker_klaus();

    // 建構子
    public JSONInDB_GTLive() {

        // 連結資料庫
        String driverName = "com.mysql.jdbc.Driver";
        // 引入連接資料庫資訊
        String connectionString = dblinker.toString();
        // 儲存 JSON 字串
        String xmlResponse = null;  // 需要先初始化

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
                System.out.println("[✓] ＪＳＯＮ 資料讀取完成");

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
        int insertDB_Counter = 0;                    // ＤＢ寫入次數計數器

        
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

            for (Object o : jsonarray) {

                insertPS = connection.prepareStatement("INSERT INTO jsonIn_GarbageTruckLive values (?, ?, ?, ?)");

                person = (JSONObject) o;

                String lineid = (String) person.get("lineid");
                insertPS.setString(1, lineid);

                String car = (String) person.get("car");
                insertPS.setString(2, car);

                String time = (String) person.get("time");
                insertPS.setString(3, time);

                String location = (String) person.get("location");
                String location_replace = location.replace("附近", "");
                insertPS.setString(4, location_replace);

                insertPS.executeUpdate();     // 寫(更新)進資料庫
                
                insertDB_Counter++;

            }

        } catch (ParseException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("[✓] ＤＢ 寫入完成，累計寫入 " + insertDB_Counter + " 筆資料");
                }
            } catch (Exception e4) {
                System.out.println(e4);
            }
        }
        
    }

}
