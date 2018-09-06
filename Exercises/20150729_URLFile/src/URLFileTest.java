// ==========================
// 從網路上指定資源，複製資源至指定位置
// ==========================

import java.io.*;
import java.net.URL;

public class URLFileTest {

    public static void main(String[] args) {

        String urlString = "https://lh3.googleusercontent.com/-sUrWYVd0LnU/T3FZcl5jb8I/AAAAAAAAId8/EMEaDuzfBJk/s200-Ic42/o020002001332828451094.jpg";   // 輸入指定
        String saveFile = "src/downloadFile.jpg";       // 輸出指定
        
        try {
            
            URL url = new URL(urlString);       // 來源檔案丟入類別 URL 中
            
            // 寫在 try() 裡面可以自動關閉資源
            try(InputStream is = url.openStream();      // 此時 url 中已經有指定的資源可供 InputStream
                    FileOutputStream fos = new FileOutputStream(saveFile)) {        // 建立指定位址物件
                byte[] buf = new byte[1024 * 1024];     // 1Mbyte(一維陣列)
                int size;
                while((size = is.read(buf)) != -1) {    // 將 is 中的資料丟進 buf[] 中，並將讀到的長度傳給 size
                    fos.write(buf, 0, size);        // 寫入暫存區資料，fos(saveFile) → src/downloadFile.jpg
                }
                System.out.println("存檔成功 " + saveFile);
                
            }
            
        } catch(IOException e) {
            System.out.println(e);
        }
        
    }
    
}
