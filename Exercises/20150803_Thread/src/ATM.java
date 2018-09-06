
public class ATM extends Thread {

    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    @Override   // for Thread
    public void run() {
        synchronized (this.account) {       // 同步化區塊，鎖定 account 物件
            String atmName = Thread.currentThread().getName();      // 取得執行緒名稱
            System.out.println(atmName + " 提款中...");
            this.account.withdraw(10);           // 對帳戶提款10元
            System.out.println(atmName + " 完成提款，餘額 " + this.account.getBalance());
        }
    }

}
