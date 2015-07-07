/// =============
// 投票機
// ver3.0 Pre-alpha
// =============

package Vote_v3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vote {

    private final String[] names;
    private int num;
    private int[] b;                                                                          // 累計投票數
    private int choice;                                                                                         // 輸入選項
    private boolean end;
    private final Scanner sc = new Scanner(System.in);
    private int endnum;
    
    public Vote(String... names) {         // 為了要讓 VoteTest 的參數可以傳過來，屬性要設 public
        this.names = names;
    }

    public void runGroup() {
        
        while(true) {
            menu();                                         // 選單
            entVot();                                       // 輸入選項
                if (this.end) {
                    System.out.println("=== 投票結算 ===");
                    statistics();
                    System.out.println("Bye.");
                    break;
                }
            callOutBallot();                            // 唱票
            waitSec();                                      // 等候一秒
            count();                                         // 計票
            statistics();                                   // 顯示得票
            waitSec();                                      // 等候一秒
        }
        
    }
    
    
    // 選單 OK
    private void menu() {                                                    // 為了要讓 VoteTest 讀的到，屬性要設 public

        System.out.println("最受歡迎歌手票選");
        for (int i = 0; i < this.names.length; i++) {
            this.num = i + 1;
            System.out.println(this.num + ". " + this.names[i]);
        }
        this.endnum = this.names.length + 1;
        System.out.println(this.endnum + ". 結束");
        System.out.println("----------------");
        System.out.println(this.names.length);
        entVot();

    }

    
    // 輸入判斷
    void entVot() {

        boolean repeat = true;
        
        do {
            try {                                                                                                               // 例外處理
                System.out.print("請輸入代號 > ");
                this.choice = this.sc.nextInt();
                if (this.choice < this.endnum || this.choice > 1) {
                    repeat = false;
                } else {
                    System.out.println("請輸入範圍內選項。");
                }
            } catch (InputMismatchException e1) {                                               // 例外：錯誤字元
                System.out.println("請輸入數值選項。");
            }
        } while (repeat);                                                                             // 如果 repeat 為 true，繼續執行迴圈
        
        this.end = (this.choice == this.endnum);

    }

    
    // 唱票 OK
    void callOutBallot() {
        
        if (this.choice >= 1) {                                                                                 // 防止沒人投票就結票產生錯誤(矩陣位置指定為負數)
            System.out.println(this.names[this.choice - 1] + " 得 1 票");
        }
        
    }

    // 計票
    void count() {
        int index = this.choice - 1;
        this.b[index]++;
    }
    
    
    // 等候一秒 OK
    void waitSec() {
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
        
    }

    
    // 票數顯示 
    void statistics() {
        
        for (int i = 0; i < names.length; i++) {
            System.out.print(this.names[i] + " 有 " + this.b[i] + " 票\n");
        }
        System.out.println("------------------");
        
    }

    
}