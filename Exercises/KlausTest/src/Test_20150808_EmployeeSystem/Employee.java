package Test_20150808_EmployeeSystem;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Serializable {     // Serializable 為實作序列化與反序列化所需
    private static final long serialVersionUID = 1L; // 自行指定版號以免輸出入錯誤

    // 員工資料
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private float salary;

    // 日期格式化物件 (格式範例: 2015-7-31)
    // 類別 SimpleDateFormat 為 Object 下子類別
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    
    // 建構子
    public Employee(int id, String firstName, String lastName, String birthDate, float salary) throws EmployeeException { // 宣告拋出員工例外
        
        // 如果id小於0、id為空、前名為空、後名為空、薪水小於0，印出訊息與丟出例外事件
        if (id < 0 || firstName == null || lastName == null || salary < 0.0F) {
            String errorMessage = "id / salaray 不能 < 0 , firstName / lastName 不能是 null";
            throw new EmployeeException(errorMessage); // 拋出員工例外
        }
        // try 日期格式
        try {
            this.birthDate = sdf.parse(birthDate); // 字串轉日期
        } catch (ParseException e) { // 轉換失敗
            String errorMessage = "日期格式錯誤: " + birthDate + "\n日期格式範例：2015-7-31";
            throw new EmployeeException(errorMessage); // 拋出員工例外
        }

        // 設定員工資料
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.salary = salary;
    
    }
    //建構子 end

    
    // getter
    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public float getSalary() {
        return this.salary;
    }
    
    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    

    @Override   // for class Object
    public String toString() {
        return "Employee ID:   " + getId() + "\n"
                + "Employee Name: " + getFirstName() + " " + getLastName() + "\n"
                + "Birth Date:    " + new SimpleDateFormat("yyyy-MM-dd").format(getBirthDate()) + "\n"
                + "Salary:        " + NumberFormat.getCurrencyInstance().format((double) getSalary());
    }


}
// class Employee end