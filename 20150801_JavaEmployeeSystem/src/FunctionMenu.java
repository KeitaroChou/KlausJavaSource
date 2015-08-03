//import java.util.ArrayList;
import java.util.Scanner;

public class FunctionMenu {

    static Scanner sc = new Scanner(System.in);
//    static EmployeeArrayDB employDB = new EmployeeArrayDB();

    public static void main(String[] args) {

        String action = null;
        while (true) {
            // 選單
            System.out.println("====== 員工管理系統 ======");
            System.out.println("[C]reate");
            System.out.println("[R]ead");
            System.out.println("[U]pdate");
            System.out.println("[D]elete");
            System.out.println("[L]ist");
            System.out.println("[S]ave");
            System.out.println("[Q]uit");
            System.out.println("=========================");
            System.out.print("請選擇功能 > ");
            action = sc.nextLine().toUpperCase();       // toUpperCase() 輸入字串轉大寫
            switch (action) {
                case "C":
                    add();
                    break;
                case "R":
                    read();
                    break;
                case "U":
                    update();
                    break;
                case "D":
                    delete();
                    break;
                case "L":
                    list();
                    break;
                case "S":
                    save();
                case "Q":
                    System.exit(0); // 結束程式
            }
        }

    }

    // 新增
    private static void add() {
//        Employee emp = inputEmployee();
//        employDB.add(emp);
//        System.out.println("新增成功，員工: " + emp.getId());
//        System.out.println("\n\nCreated " + emp);
    }

    // 刪除
    private static void delete() {

    }

    // 查詢
    private static void read() {

    }

    // 修改
    private static void update() {

    }

    // 列出所有資料
    private static void list() {
//        ArrayList<Employee> allEmps = employDB.getAllEmployees();
//        for (Employee emp : allEmps) {
//            System.out.println(emp + "\n");
//        }
    }

    private static void save() { // 將 employDB 序列化

    }

    // 輸入員工資料 #1
//    public static Employee inputEmployee() {
//        int id = -1;
//        String firstName = null;
//        String lastName = null;
//        String birthDate = null;
//        float salary = 0.0F;
//        
//        // 完成輸入員工資料
//        System.out.println("請輸入 id: ");
//        String input;
//        input = sc.nextLine();
//        id = Integer.parseInt(input); // 字串轉 int
//        
//        //  ...
//        
//        Employee emp = new Employee(id, firstName, lastName, birthDate, salary); // 建立員工物件
//        return emp; // 回傳員工物件
//    }
}
