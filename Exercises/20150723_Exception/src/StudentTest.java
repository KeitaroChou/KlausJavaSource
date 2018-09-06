import javax.swing.JOptionPane;

public class StudentTest {

    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("輸入 name");     // 輸入視窗顯示
        Student st = new Student(name);     // 新增屬性 Student 物件 st ，傳給輸入視窗的值
        System.out.println(st);     // → 自動呼叫 st.toString
        
    }
    
}
