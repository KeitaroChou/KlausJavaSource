
public class StudentException extends RuntimeException  {   // StudentException 繼承父類別 RuntimeExcetion 例外

    // 建構子(單傳入值)
    public StudentException(String message) {
        
        super(message);     // 呼叫父類別建構子，設定錯誤訊息
        
    }
    
}
