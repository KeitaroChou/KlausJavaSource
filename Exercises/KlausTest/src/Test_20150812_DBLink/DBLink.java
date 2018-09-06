
package Test_20150812_DBLink;

import java.sql.*;
import java.util.GregorianCalendar;
import java.util.Date;

public class DBLink {

    public static void main(String[] args) {

        String driverName = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://klaus-macbook-air.local:3306/test?" + "user=klaus&password=klaus580925&useUnicode=true&characterEncoding=utf-8";
        
        try {
            
            // 載入 JDBC driver class (Library 需載入 MySQL JDBC driver)
            Class.forName(driverName);
            // 得到 Connection
            Connection connection = DriverManager.getConnection(connectionString);
            
            // 用於執行 SQL 語句的 Statement
            Statement statement = connection.createStatement();
            
            // 執行 SQL 語句
            String selectSQL = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            
            while (resultSet.next()) {
                
                // 抓取資料庫各欄位資料
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                Date birthDate = resultSet.getDate("birthDate");
                Float salary = resultSet.getFloat("salary");
                
                // 轉換 Date 型別爲 GregorianCalendar，以便分別取出年日月
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTime(birthDate);
                int year = gc.get(GregorianCalendar.YEAR);
                int month = gc.get(GregorianCalendar.MONTH);
                int day = gc.get(GregorianCalendar.DATE);
                
                System.out.println("員工編號：" + id);
                System.out.println("員工姓名：" + firstName + " " + lastName);
                System.out.println("生日：" + year + "-" + month + "-" + day);
                System.out.println("薪水：" + "USD $" + salary);
                System.out.println();
                    
            }
            
            statement.close();      // 關閉 Statement
            connection.close();     // 關閉 Connection
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        
    }
    
}
