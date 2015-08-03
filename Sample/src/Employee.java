
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

    // 員工資料
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private float salary;

    // 日期格式化物件 (格式範例: 2015-7-31)
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // 建構子
    public Employee(int id, String firstName, String lastName, String birthDate, float salary) throws EmployeeException { // 宣告拋出員工例外
        if (id < 0 || firstName == null || lastName == null || salary < 0.0F) {
            String errorMessage = "id / salaray 不能 < 0 , firstName / lastName 不能是 null";
            throw new EmployeeException(errorMessage); // 拋出員工例外
        }
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

    // getter
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID:   " + getId() + "\n"
                + "Employee Name: " + getFirstName() + " " + getLastName() + "\n"
                + "Birth Date:    " + new SimpleDateFormat("yyyy-MM-dd").format(getBirthDate()) + "\n"
                + "Salary:        " + NumberFormat.getCurrencyInstance().format((double) getSalary());
    }

}
