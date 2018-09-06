import java.io.*;

public class BufferRWerTest {

    public static void main(String[] args) {

        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {       // 為了精簡例外判斷
            try {

                fr = new FileReader("src/source.txt");      // 目標檔案需事先存在
                fw = new FileWriter("src/output.txt");      // 如果沒有目標檔案會自動生成
                br = new BufferedReader(fr);        // 讀檔緩衝
                bw = new BufferedWriter(fw);        // 寫檔緩衝
                String s;

                while ((s = br.readLine()) != null) {       // readLine() 讀取整列的值
                    bw.write(s);
                    bw.newLine();       // 分行
                }

            } finally {

                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.flush();     // 預防 Buffer 裡面還有未寫入的值 (寫入剩餘的值，清空 Buffer)
                    bw.close();
                }
                
            }
            
        } catch (IOException e) {
                System.out.println(e);
        }
        
    }
}
