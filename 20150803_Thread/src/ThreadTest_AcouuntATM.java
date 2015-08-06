
public class ThreadTest_AcouuntATM {

    public static void main(String[] args) {

        Account acc = new Account(5000);        // 存入5000元
        System.out.println("帳戶餘額：" + acc.getBalance());
        
        // 建立三個執行緒，並使用同一帳戶
        ATM atm1 = new ATM(acc);
        ATM atm2 = new ATM(acc);
        ATM atm3 = new ATM(acc);
        
        // 設定執行緒(ATM)名稱
        atm1.setName("ATM01");
        atm2.setName("ATM02");
        atm3.setName("ATM03");
        
        // 啟動執行緒(同時)
        atm1.start();
        atm2.start();
        atm3.start();
        
    }
    
}
