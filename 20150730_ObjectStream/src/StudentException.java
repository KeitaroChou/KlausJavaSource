
// 自訂例外

class StudentException extends RuntimeException {   // 需繼承 RuntimeException

    public StudentException(String message) {
        
        super(message);
        
    }
    
}
