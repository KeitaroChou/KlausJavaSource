
import java.sql.*;

public class JDBCSample {

    private static Connection dbCon = null;

    public static void main(String[] arg) {
        try {
            Class.forName(JDBC Driver Class Name).newInstance();
            System.out.println("載入驅動程式成功");
            dbCon = DriverManager.getConnection(JDBC URL);
            System.out.println("與database連線成功");
        } catch(SQLException e) {
            System.out.println("SQLException :" + e.getMessage());
        } catch (ClassNotFoundException cfe) {
            System.out.println("找不到驅動程式");
        } catch (IllegalAccessException iae) {
            System.out.println("無法讀取驅動程式");
        } catch (InstantiationException ie) {
            System.out.println("無法載入驅動程式");
        } finally { //要養成回收資源的好習慣
            try {
                if (dbCon != null) {
                    dbCon.close();//中斷與database連線
                }
            } catch (Exception vv) {
            }
            dbCon = null; //把物件資源釋放
        }
    }
}
