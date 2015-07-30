import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.Serializable;

public class Student implements Serializable {
    
    public static final long serialVersionUID = 1L;    // 自訂版本號碼為1，serialVersionUID 必須為 final、long
    
    public String name;
    public int math;
    public int eng;
//    private float avg;
    transient private float avg;        // 宣告為 transient，表示此欄位不要序列化
    
    // 輸入時給系統自動呼叫使用
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        
        stream.defaultReadObject();     // 執行反序列化
        this.avg = (this.math + this.eng) / 2.0f;
        
    }
    
    public Student(String name) throws StudentException {
        
        if(name == null || name.length() < 2) {
            throw new StudentException("名字不能少於兩個字。");
        }
        
        this.name = name;
        
    }
    
    public Student(String name, int math, int eng) throws StudentException {
        
        this(name);     // 呼叫另一建構子
        this.math = math;
        this.eng = eng;
//        this.avg = (math + eng) / 2.0f;
        
    }
    
    @Override
    public String toString() {
//        return "name: " + this.name + "\nmath: " + this.math + "\neng: " + this.eng;
        return "name: " + this.name + "\nmath: " + this.math + "\neng: " + this.eng + "\navg: " + this.avg;
    }
    
}
