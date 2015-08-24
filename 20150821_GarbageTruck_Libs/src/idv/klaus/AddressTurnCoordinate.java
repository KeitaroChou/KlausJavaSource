// ==========================================
// 利用 Google Maps API ，將地址轉換爲經緯座標
// ==========================================

package idv.klaus;

// 讀入引用連結內的資料
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// ＪＳＯＮ
import org.json.JSONObject;
import org.json.JSONArray;

// Exception
import java.io.IOException;

public class AddressTurnCoordinate {

    private String xmlResponse = null;
    public Double lng;                  // 經度
    public Double lat;                  // 緯度

    // 建構子
    public AddressTurnCoordinate(String address) {

        // 丟地址給 Google，然後將產生出的 ＪＳＯＮ 字串讀進程式
        try {

            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&sensor=false&language=zh-TW");     // 抓取網頁位址
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();   // 用 HttpURLConnection 開啟(建立連線)

            InputStreamReader isr = new InputStreamReader(huc.getInputStream(), "UTF-8");   // 串流讀取連結內資料

            try (BufferedReader br = new BufferedReader(isr)) {     // 讀檔緩衝 

                String str = "";
                StringBuilder sb = new StringBuilder();

                while (null != ((str = br.readLine()))) {
                    sb.append(str);
                }

                br.close();                                     // 關閉資源
                this.xmlResponse = (String) sb.toString();      // JSON 字串丟進 xmlResponse

            }
            huc.disconnect();       // 關閉連線

        } catch (IOException e) {
            System.out.println(e);
        }

        // 擷取 ＪＳＯＮ 字串中所需的經緯座標
        try {

            // 拆分結構
            JSONObject obj = new JSONObject(xmlResponse);
            JSONArray results = obj.getJSONArray("results");
            JSONObject resultsArray = results.getJSONObject(0);
            JSONObject geometry = resultsArray.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");
            
            this.lat = (Double) location.get("lat");
            this.lng = (Double) location.get("lng");

        } catch (NullPointerException e2) {
            throw e2;
        }
        
//            // 用 ResultSetMetaData 判斷 SELECT 進來的欄位數
//            ResultSetMetaData rsmd = resultSet.getMetaData();
//            int columnCount = rsmd.getColumnCount();
//            while (resultSet.next()) {
//                for (int i = 1; i <= columnCount; i++) {
//                    String address = resultSet.getString(i);
//                    System.out.print(address + "\t");
//                }
//                System.out.println();
//                counter++;
//            }

    }
    
    @Override
    public String toString() {
        return "\t經度：" + this.lng + "\n" + "\t緯度：" + this.lat;
    }

}
