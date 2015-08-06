
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;     // 使用 close()、read() 所需要

public class FileReaderTest {

    public static void main(String[] args) {

        FileReader fr = null;       // 宣告 fr 並指定為 null，預設為 null 是為了做是否開啟過檔案判斷

        try {
            // Java 7 對於關閉檔案(資源)有較簡易的寫法(try-with-resource)：
            // try(FileReader fr = new FileReader("src/source.txt")) {
            fr = new FileReader("src/source.txt");
            int i;
            // 讀檔迴圈
            while ((i = fr.read()) != -1) {      // 讀檔案讀到值回傳 1，沒讀到值回傳 -1
                char c = (char) i;       // 將 i 由 int 轉 char，並指定給 c
                System.out.print(c);    // 列印時不換行
            }
            System.out.print("\n\n");
        } catch (FileNotFoundException e1) {  // 沒找到檔案的例外
            System.out.println(e1.getMessage());
        } catch (IOException e2) {   // read()的例外
            System.out.println(e2.getMessage());
        } finally {     // 不管有無例外都要執行
            try {
                if (fr != null) {   // 如果 fr 不為空值就執行關閉檔案 (fr 為 null 表示沒開過檔案)
                    fr.close();
                }
            } catch (IOException e) {   // close()的例外
                System.out.println(e.getMessage());
            }
        }

    }

}