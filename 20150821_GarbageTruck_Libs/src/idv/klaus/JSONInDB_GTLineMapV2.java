// =======================================================
// 元件名稱：JSONInDB_GarbageTruckLineMap
// 功能：擷取新北市垃圾車路線資料(ＪＳＯＮ)，並寫入ＤＡＴＡＢＡＳＳ
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

public class JSONInDB_GTLineMapV2 {
    
    static DBLinker_klaus dblinker = new DBLinker_klaus();
    int insertDB_counter = 0;       // ＤＢ寫入次數

    // 建構子
    public JSONInDB_GTLineMapV2(int skipNumber) {

        // MySQL JDBC Driver
        String driverName = "com.mysql.jdbc.Driver";
        // 引入連接資料庫資訊
        String connectionString = dblinker.toString();
        // 儲存 JSON 字串
        String xmlResponse = null;
        // 計數器
        int JSON_COUNTER = 0;           // 抓取ＪＳＯＮ次數

        do {

            // 讀入引用連結內的資料
            try {

                JSON_COUNTER++;
                System.out.println("第 " + JSON_COUNTER + " 次ＪＳＯＮ ...");
                System.out.println("從第 " + (skipNumber + 1) + " 筆開始");

                URL url = new URL("http://data.ntpc.gov.tw/od/data/api/EDC3AD26-8AE7-4916-A00B-BC6048D19BF8?$format=json&$top=2000&$skip=" + skipNumber);     // 抓取網頁位址
                HttpURLConnection huc = (HttpURLConnection) url.openConnection();   // 用 HttpURLConnection 開啟(建立連線)

                InputStreamReader isr = new InputStreamReader(huc.getInputStream(), "UTF-8");   // 串流讀取連結內資料

                try (BufferedReader br = new BufferedReader(isr)) {     // 讀檔緩衝 

                    String str = "";
                    StringBuilder sb = new StringBuilder();

                    while (null != ((str = br.readLine()))) {
                        sb.append(str);
                    }

                    xmlResponse = sb.toString();
                    br.close();             // 關閉資源

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

                System.out.println("[↑] 開始寫入 ＤＢ ...");

                for (Object o : jsonarray) {

                    // 資料寫入
                    insertPS = connection.prepareStatement("INSERT INTO jsonIn_GarbageTruckLineMap values (?, ?, trim(?), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
                    String longitude_replace = longitude.replace("?", "").replace(" ", "").replace(",", "");  // 移除座標內的多餘字元
                    insertPS.setString(7, longitude_replace);

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

                    insertPS.executeUpdate();     // 上傳(執行) SQL 指令
                    this.insertDB_counter++;

                }

            } catch (ParseException | ClassNotFoundException | SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                        System.out.println("[✓] ＤＢ 寫入完成，累計寫入 " + this.insertDB_counter + " 筆資料");
                    }
                } catch (Exception e4) {
                    System.out.println(e4);
                }
            }

            skipNumber = skipNumber + 2000;

        } while (!"".equals(xmlResponse));     // 條件：xmlResponse 內容值不為空值，同 xmlResponse.equals() != ""
    }

}
