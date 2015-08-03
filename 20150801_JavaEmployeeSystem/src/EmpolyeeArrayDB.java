import java.io.*;

public class EmpolyeeArrayDB {
    
    FileReader fr = null;
    FileWriter fw = null;
    
    public void DBAdd() {
        
        try {
            
            fr = new 
            fw = new FileWriter("src/empolyee.obj");
            int i;
            
            while((i = fr.read()) != -1) {
                fw.write(i);
                System.out.println(i);
            }
            
        } finally {
            if(fr != null) {
                fr.close();
            }
            if(fw != null) {
                fw.close();
            }
        }
    }
    
    public void DBUpdate() {
        
    }
    
    public void DBDelete() {
        
    }
    
    public void DBFindEmp() {
        
    }
    
    public void ViewAll() {
        
    }
    
}
