
import java.io.*;
import java.sql.*;

public class Empolyee {

//    private java.sql.Connection con = null;
//    private String url = "jdbc:sqlsever://";
//    private String serverName = "localhost";
//    private String portName = "3306";
//    private String databassName = "javatest";
//    private String userName = "klaus";
//    private String password = "klaus580925";
    
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private float salary;
    
    FileReader fr = null;
    BufferedReader br = null;

    public void preload() {

//        try {
//            try {
//                fr = new FileReader("src/empolyee.obj");
//                int i;
//                while ((i = fr.read()) != -1) {
//                    
//                }
//            } finally {
//                if (fr != null) {
//                    fr.close();
//                }
//            }
//        } catch (FileNotFoundException e1) {
//            System.out.println(e1);
//        } catch (IOException e2) {
//            System.out.println(e2);
//        }
        
        try {
            try {
                fr = new FileReader("src/empolyee.obj");
                br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {
                    
                }
                
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } catch (FileNotFoundException e1) {
            System.out.println(e1);
        } catch (IOException e2) {
            System.out.println(e2);
        }

    }
    
    
    

}
