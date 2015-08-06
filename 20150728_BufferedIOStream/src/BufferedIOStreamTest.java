
import java.io.*;

public class BufferedIOStreamTest {

    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            
            try {
                fis = new FileInputStream("src/testvideo.mp4");
                fos = new FileOutputStream("src/copy.mp4");
                bis = new BufferedInputStream(fis);
                bos = new BufferedOutputStream(fos);
                byte[] buf = new byte[1024];        // 裝讀來的資料，所以指定大小會影響檔案是否讀取完整(這裡1024byte的空間)
                int size;

                while ((size = bis.read(buf)) != -1) {
                    bos.write(buf, 0, size);        // write(陣列, 偏移量(陣列開始位置), 陣列長度)
                }
                
            } finally {
                
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
