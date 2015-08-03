
public class Account {
    
    private float balance;
    
    public Account(float balance) {
        this.balance = balance;
    }
    
    public float getBalance() {
        return this.balance;
    }
    
    public void setBalance(float balance) {
        this.balance = balance;
    }
    
    synchronized public void withdraw(float amount) {       // 同步化方法 synchronized，使執行本方法時，一次只能接受一個執行緒使用
        float balance = this.getBalance();      // 先取得目前帳戶餘額
        交易中();
        balance -= amount;          // 帳戶扣除提款金額
        this.setBalance(balance);       // 更新帳戶餘額
    }
    
    // 模擬交易所需時間
    private void 交易中() {
        int delay = (int)(Math.random() * 3000);    // 亂數產生暫停時間
        try {
            Thread.sleep(delay);    // 執行緒暫停，模擬交易所需時間
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    
}
