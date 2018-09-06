// =========================
// 讀入外部檔案資料，並可讓程式使用
// =========================

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamTest {

    public static void main(String[] args) {

        String filename = "src/output.data";
        
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            
            String name = dis.readUTF();
            int eng = dis.readInt();
            int math = dis.readInt();
            float avg = dis.readFloat();
            dis.close();
            System.out.println("name: " + name + "\neng: " + eng + "\nmath: " + math + "\navg: " + avg);
            
        } catch(IOException e) {
            System.out.println(e);
        }
        
    }
    
}
