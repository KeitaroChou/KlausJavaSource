
// ==========================================
// 利用 Google Maps API ，將地址轉換經緯座標
// ==========================================


package Test_20150814_jsonInDB;


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
import org.json.simple.parser.ParseException;


public class AddressTurnCoordinate {

    public static void main(String[] args) {
        
        String xmlResponse = null;
        
        Double lat;
        Double lng;

        try {

            System.out.println("[↓] 開始讀取 ＪＳＯＮ 資料 ...");
            
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=新北市三峽區中山路459巷135號&sensor=false");     // 抓取網頁位址
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();   // 用 HttpURLConnection 開啟(建立連線)

            InputStreamReader isr = new InputStreamReader(huc.getInputStream(), "UTF-8");   // 串流讀取連結內資料

            try (BufferedReader br = new BufferedReader(isr)) {     // 讀檔緩衝 

                String str = "";
                StringBuilder sb = new StringBuilder();

                while (null != ((str = br.readLine()))) {
                    sb.append(str);
                }

                br.close();             // 關閉資源
                xmlResponse = (String)sb.toString();
//                System.out.println(xmlResponse);

            }
            huc.disconnect();       // 關閉連線

        } catch (IOException e) {
            System.out.println(e);
        }
        
        
        try {
            
            JSONObject obj = new JSONObject(xmlResponse);
            JSONArray results = obj.getJSONArray("results");
            JSONObject resultsArray = results.getJSONObject(0);
            JSONObject geometry = resultsArray.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");
            lat = (Double) location.get("lat");
            lng = (Double) location.get("lng");
            System.out.println(lat);
            System.out.println(lng);
            
        } catch (NullPointerException e2) {
            throw e2;
        }
        
    }
    
}
