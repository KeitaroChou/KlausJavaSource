/// =============
// 投票機
// ver3.0 Pre-alpha
// =============
package Vote_v3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vote {

    private final String[] names;                                               // 用來儲存傳來的參選名單
    private int num;                                                                    // 候選人編號(依傳入次序)
    private int[] b;                                                                          // 累計各候選人得票數
    private int choice;                                                                 // 輸入選項
    private boolean end;                                                            // 是否要結束
    private final Scanner sc = new Scanner(System.in);
    private int endnum;                                                             // 結束選項
    private boolean repeat;

    // 建構子，這裡用來讀入傳來值
    public Vote(String... names) {             // 為了要讓 VoteTest 的參數可以傳過來，屬性要設 public
        this.names = names;
    }

    // 統整功能包
    public void runGroup() {                // 為了要讓 VoteTest 讀的到，屬性要設 public

        menu();                                         // 選單
        entVot();                                       // 輸入選項
        callOutBallot();                            // 唱票
        waitSec();                                      // 等候一秒
        count();                                         // 計票
        statistics();                                   // 顯示得票
        waitSec();                                      // 等候一秒

    }

    // 選單
    private void menu() {

        System.out.println("--- 最受歡迎藝人票選 ---");

        // 用迴圈印出候選人名單
        for (int i = 0; i < this.names.length; i++) {
            this.num = i + 1;
            System.out.println(this.num + ". " + this.names[i]);
        }
        this.endnum = this.names.length + 1;
        System.out.println(this.endnum + ". 結票");
        System.out.println("------------------------");

    }

    // 輸入判斷
    void entVot() {

        do {
            System.out.print("請輸入 > ");
            this.repeat = false;
            try {
                this.choice = this.sc.nextInt();
/*                if (this.choice >1 || this.choice < this.endnum) {
                    repeat = false;
                } else {
                    System.out.println("請輸入正確範圍數值。");
                    repeat = true;
                }*/
            } catch (InputMismatchException e1) {
                System.out.println("錯誤的輸入字元。");
                this.repeat = true;
            } catch (ArrayIndexOutOfBoundsException e2) {
                System.out.println("錯誤的選項。");
                this.repeat = true;
            }
        } while (this.repeat);

    }

    // 唱票
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

    // 等候一秒
    void waitSec() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }

    }

    // 票數顯示 
    void statistics() {

    }

}
