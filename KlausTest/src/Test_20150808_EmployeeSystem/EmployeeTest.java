package Test_20150808_EmployeeSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeTest {

    static Scanner sc = new Scanner(System.in);
    static EmployeeArrayDB employDB = new EmployeeArrayDB();

    public static void main(String[] args) {

        String action = null;
        while (true) {
//            EmployeeTest.sc.reset();
            System.out.println("------------------------------");
            System.out.println("請選擇功能：");
            System.out.println("[C]reate");
            System.out.println("[R]ead");
            System.out.println("[U]pdate");
            System.out.println("[D]elete");
            System.out.println("[L]ist");
            System.out.println("[S]ave");
            System.out.println("[I]mport");
            System.out.println("[Q]uit");
            System.out.print("> ");
            action = sc.nextLine().toUpperCase(); // 輸入所有字串轉大寫
            System.out.println("------------------------------");
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
                    break;
                case "I":
                    load();
                    break;
                case "Q":
                    System.exit(0); // 結束程式
            }
        }
        
    }

    // 新增
    private static void add() {
        Employee emp = inputEmployee();
        employDB.add(emp);
        System.out.println("新增成功，員工 id: " + emp.getId());
        System.out.println("\nCreated " + emp);
    }

    // 刪除
    private static void delete() {

        System.out.print("請輸入要刪除的員工id:");
        int id = sc.nextInt();

        if (employDB.findById(id) != null) {
            System.out.println("資料刪除中...");
            employDB.delete(id);
        } else {
            System.out.println("[！]該名員工不存在");
        }

    }

    // 查詢
    private static void read() {
        System.out.print("請輸入要查詢的員工id:");
        int id = sc.nextInt();
        if (employDB.findById(id) != null) {
            System.out.println(employDB.findById(id));
        } else {
            System.out.println("[！]該名員工不存在");
        }

    }

    // 修改
    private static void update() {

        System.out.print("請輸入要修改的員工id:");
        try {
            int id = sc.nextInt();
            if (employDB.findById(id) != null) {
                employDB.update(employDB.findById(id));
            } else {
                System.out.println("[！]該名員工不存在");
            }
        } catch (InputMismatchException ime) {
            System.out.println("[！]發生例外錯誤：" + ime + "字元輸入錯誤");
            System.out.println();
        }

    }

    // 列出所有資料
    private static void list() {
        ArrayList<Employee> allEmps = employDB.getAllEmployees();
        for (Employee emp : allEmps) {
            System.out.println(emp + "\n");
        }
    }

    // 序列化 employDB
    private static void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Test_20150808_EmployeeSystem/EmployeeDB.obj"))) {
            oos.writeObject(employDB);
            for (int i = 0; i < 3; i++) {   // 等候延遲
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.print("檔案匯出成功");
            Thread.sleep(1000);
            System.out.println();
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }

    }

    // 反序列化 employDB
    private static void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Test_20150808_EmployeeSystem/EmployeeDB.obj"))) {
            employDB = (EmployeeArrayDB) ois.readObject(); // Object 轉型 EmployeeArrayDB
            for (int i = 0; i < 3; i++) {   // 等候延遲
                System.out.print(".");
                Thread.sleep(1000);
            }
            System.out.print("檔案匯入成功");
            Thread.sleep(1000);
            System.out.println();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            System.out.println(e);
        }
    }

    // 輸入員工資料 #1
    public static Employee inputEmployee() {
        int id = -1;
        String firstName = null;
        String lastName = null;
        String birthDate = null;
        float salary = 0.0F;

        // 完成輸入員工資料 id
        String input;
        boolean b;
        do {
            b = true;
            System.out.print("請輸入 id: ");
            input = sc.nextLine();
            id = Integer.parseInt(input); // 字串轉 int

            if (employDB.findById(id) != null) {
                System.out.println("已有此id，請重新輸入id");
            } else {
                b = false;
            }
        } while (b);

        // 完成輸入員工資料 firstName
        System.out.print("請輸入 firstName: ");
        firstName = sc.nextLine();

        // 完成輸入員工資料 lastName
        System.out.print("請輸入 lastName: ");
        lastName = sc.nextLine();

        // 完成輸入員工資料 birthDate
        System.out.print("請輸入 birthDate: ");
        birthDate = sc.nextLine();

        // 完成輸入員工資料 salary
        System.out.print("請輸入 salary: ");
        String sa;
        sa = sc.nextLine();
        salary = Float.parseFloat(sa); // 字串轉 float

        Employee emp = new Employee(id, firstName, lastName, birthDate, salary); // 建立員工物件
        return emp; // 回傳員工物件

    }

}
