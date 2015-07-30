import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

    public static void main(String[] args) {

        String filename = "src/output.data";     // 指定輸出位址與檔案
        String name = "Jhon";
        int eng = 98;
        int math = 90;
        float avg = (eng + math) / 2.0f;
        
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {      // 巢狀
            
            // 輸出順序需要和輸入順序一樣
            dos.writeUTF(name);
            dos.writeInt(eng);
            dos.writeInt(math);
            dos.writeFloat(avg);
            dos.close();        // 寫完後要關閉
            System.out.println("檔案輸出成功");
            
        } catch(IOException e) {
            System.out.println(e);
        }
        
    }
    
}
