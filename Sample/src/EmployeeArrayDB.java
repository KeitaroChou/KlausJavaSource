
import java.util.ArrayList;

public class EmployeeArrayDB {
    // 員工陣列
    private ArrayList<Employee> employees = new ArrayList<>();
    
    // 新增員工
    public void add(Employee emp) throws EmployeeException { // 此方法會拋出員工例外
        if(employees.contains(emp)) { // 員工是否存在
            String errorMessage = emp.getId() + " 員工已存在";
            throw new EmployeeException(errorMessage); // 拋出員工例外
        } else {
            employees.add(emp); // 加入員工
        }
    }
    // 修改員工
    public void update(Employee emp) {
        
    }
    // 刪除員工
    public void delete(int id) {
        
    }
    // 搜尋員工
    public Employee findById(int id) {
        Employee found = null;
        for(Employee e : employees) { // 加強版for 走訪員工陣列
            if(e.getId() == id) {
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
