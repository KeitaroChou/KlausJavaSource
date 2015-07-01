
import java.util.InputMismatchException;
import java.util.Scanner;
// import javax.swing.JOptionPane;

public class Vote {

    private final String a[] = {"A-Lin", "Jolin", "A-mei"};
    private int b[];                         // 累計投票數
    private int choice;                             // 輸入選項
    private boolean exit;                       // 結束判斷
    private final Scanner sc = new Scanner(System.in);          // 宣告輸入物件

    void menu() {

        System.out.println("最受歡迎歌手票選");
        System.out.println("1. A-Lin");
        System.out.println("2. Jolin");
        System.out.println("3. A-mei");
        System.out.println("4. Exit");
        System.out.println("----------------");
        entVot();

    }

    
    // 輸入選項
    void entVot() {

        boolean repeat;

        do {
            repeat = false;
            try {

                System.out.print("請輸入代號 > ");
                this.choice = this.sc.nextInt();
                
                do {
                if (this.choice == 1) {
                    this.b[0]++;
                } else if (this.choice == 2) {
                    this.b[1]++;
                } else if (this.choice == 3) {
                    this.b[2]++;
                }
                } while ()
                
                statistics();
                
            } catch (InputMismatchException imexc) {
                System.out.println("請輸入正確選項。");
                //JOptionPane.showMessageDialog(null, "請輸入正確選項。");
                repeat = true;
            }
        } while (repeat || this.choice != 4);

    }

    
    // 唱票
    void callOutBallot() {

        if (this.choice == 1) {

        }
        System.out.println("投" + "票");
        waitSec();

    }

    
    // 等候三秒
    void waitSec() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }

    }

    
    // 票數顯示
    void statistics() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(this.a[i] + "目前有 " + this.b[i] + " 票\n");
        }
        
        this.choice = 0;
        System.out.println("----------------");
        waitSec();
        menu();
        
        // 顯示選單();
        // 輸入選項();
        // 唱票();
        // 等候一秒();
        // 計票();
        // 顯示票數();
        // 等候一秒();
    }

}
