import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
// =====================================

class Boy extends Thread {
    
    private String id;
    private String saveFileName;
    
    // 建構子
    public Boy(String id, String saveFileName) {
        this.id = id;
        this.saveFileName = saveFileName;
    }
    
    @Override   // for Thread
    public void run() {         // 工作內容
        copyFileFromGoogleDrive();
    }
    
    // 執行 run 會直接轉來 copyFileFromGoogleDrive
    private void copyFileFromGoogleDrive() {
        
        try {
            
            System.out.println("下載檔案：" + this.id + " ...");
            URL url = new URL("https://drive.google.com/uc?id=" + this.id);
            InputStream is = url.openStream();      // 開啟 URL.openStream 做 InputStream url 所指定位址資源
            Path savePath = Paths.get(this.saveFileName);       // 存檔路徑
            Files.copy(is, savePath, StandardCopyOption.REPLACE_EXISTING);     // 如果檔案存在就覆蓋(Java7以上支援)
            System.out.println("存檔成功：" + this.saveFileName);
            
        } catch(IOException e) {
            System.out.println(e);
        }
        
    }
    
}