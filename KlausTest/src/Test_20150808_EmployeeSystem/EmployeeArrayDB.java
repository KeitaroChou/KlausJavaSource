package Test_20150808_EmployeeSystem;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeArrayDB implements Serializable {

    private static final long serialVersionUID = 1L; //自行指定版號
    static Scanner sc = new Scanner(System.in);
    static Scanner scUpdate = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<Employee> employees = new ArrayList<>();  // 員工集合陣列

    // 新增員工
    public void add(Employee emp) throws EmployeeException { // 此方法會拋出員工例外
        if (employees.contains(emp)) { // 員工是否存在
            String errorMessage = emp.getId() + " 員工已存在";
            throw new EmployeeException(errorMessage); // 拋出員工例外
        } else {
            employees.add(emp); // 加入員工
        }
    }

    // 修改員工
    public void update(Employee emp) {

        int updateAction = 0;
        System.out.print("請選擇修改：1.fristName 2.lastName 3.birthDate 4.salary 5.end > ");
        updateAction = scUpdate.nextInt();
        switch (updateAction) {
            case 1:
                System.out.print("請輸入新firstName > ");
                String firstName = sc.nextLine();
                emp.setFirstName(firstName);
                System.out.println("員工id: " + emp.getId() + " 的資料已修改\n" + emp + "\n");
                break;
            case 2:
                System.out.print("請輸入新lasttName > ");
                String lastName = sc.nextLine();
                emp.setLastName(lastName);
                System.out.println("員工id: " + emp.getId() + " 的資料已修改\n" + emp + "\n");
                break;
            case 3:
                System.out.print("請輸入新birthDate > ");
                String bir = sc.nextLine();
                try {
                    Date birthDate = sdf.parse(bir);
                    emp.setBirthDate(birthDate);
                } catch (ParseException e) { // 轉換失敗
                    String errorMessage = "日期格式錯誤: " + bir + "\n日期格式範例：2015-7-31";
                    throw new EmployeeException(errorMessage); // 拋出員工例外
                }
                System.out.println("員工id: " + emp.getId() + " 的資料已修改\n" + emp + "\n");
                break;
            case 4:
                System.out.print("請輸入新salary > ");
                float salary = sc.nextFloat();
                emp.setSalary(salary);
                System.out.println("員工id: " + emp.getId() + " 的資料已修改\n" + emp + "\n");
                break;
            case 5 :
                break;

        }
    }

    // 刪除員工
    public void delete(int id) {
        Employee del = findById(id);
        employees.remove(del);
        System.out.println("員工id:" + id + "資料已刪除");
    }

    // 搜尋員工
    public Employee findById(int id) {
        Employee found = null;
        for (Employee e : employees) { // 加強版for 走訪員工陣列
            if (e.getId() == id) {
                found = e;
                break;
            }
        }
        return found; // 回傳找到的員工物件
    }

    // get員工陣列
    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

}
// class EmployeeArrayDB end
