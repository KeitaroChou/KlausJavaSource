import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {

    public static void main(String[] args) {

        Student stu = new Student("Tom", 80, 95);
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/student.obj"))) {
            
            oos.writeObject(stu);
            System.out.println("序列化儲存以下資料：");
            System.out.println(stu.name + "\t" + stu.math + "\t" + stu.eng);
            System.out.println("student 物件儲存成功。");
            System.out.println("-- serialVersionUID = " + Student.serialVersionUID);
            
        } catch(IOException e) {
            System.out.println(e);
        }
        
    }
    
}
