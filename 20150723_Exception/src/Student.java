
public class Student {
    
    private String name;
    
    // 建構子，宣告會拋出 StudentException 例外
    public Student(String name) throws StudentException {       // 建構子。throws → 丟出例外，這裡引用 StudentException (抽象類別)。
        
        if(name.length() < 2) {     // 如果輸入字元長度小於2，為ture
            throw new  StudentException("名字需兩字以上");
        }
        this.name = name;
        
    }
    
    // 傳回型別為 String 的判斷結果
    @Override   // 覆蓋
    public String toString() {
        return "Student{" + this.name  + "}";
    }
    
}
