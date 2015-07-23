import javax.swing.JOptionPane;

public class StudentTest2 {

    public static void main(String[] args) {

            boolean repeat;
            
            do {
                repeat = false;     // 重設
                
                try {
                    
                    String name = JOptionPane.showInputDialog("輸入 name");
                    Student st = new Student(name);
                    System.out.println(st);
                    
                } catch(StudentException se) {
                    
                    String msg = se.getMessage();       // 取得錯誤訊息
                    JOptionPane.showMessageDialog(null, msg);   // 跳出訊息視窗，並使用 msg 的值
                    repeat = true;  // 再執行迴圈
                    
                }
                
            } while(repeat);
        
    }
    
}
