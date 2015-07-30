import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
        
public class ObjectInputStreamTest {

    public static void main(String[] args) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/student.obj"))) {
            
            Student stu = (Student)ois.readObject();        // 反序列化時，需要將 Object 轉型回 Student，回 stu 時會去檢查是否有自訂 readObject()
            System.out.println(stu.toString());
            System.out.println("-- serialVersionUID = " + Student.serialVersionUID);
            
        } catch(IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
        
    }
    
}
