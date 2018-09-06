
import java.io.*;   // 使用 FileReader、FileWriter 所需

public class FileWriterTest {

    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;

        try {

            try {

                fr = new FileReader("src/source.txt");      // 目標檔案需事先存在
                fw = new FileWriter("src/output.txt");      // 如果沒有目標檔案會自動生成
                int i;
                
                // 寫檔迴圈
                while ((i = fr.read()) != -1) {     // read() 讀的是字碼
                    fw.write(i);    // 所以寫入的也是字碼
                    System.out.println(i);
                }

            } finally {
                if (fr != null) {       // 如果檔案無開啟(null)，卻執行 close ，會造成程式錯誤，所以需要判斷是否為 null
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            }

        } catch (IOException e) {   // 母子(巢狀) try 迴圈的例外，全由此 catch 涵蓋
            System.out.println(e);
        }

    }

}
