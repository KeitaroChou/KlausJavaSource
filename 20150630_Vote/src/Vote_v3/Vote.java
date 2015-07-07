/// =============
// 投票機
// ver3.0 beta
// =============

package Vote_v3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vote {

    private final String[] names;
    private int num;
    private final int b[] = {0, 0, 0};                                                                          // 累計投票數
    private int choice = 0;                                                                                         // 輸入選項
    
    public Vote(String... names) {         // 為了要讓 VoteTest 的參數可以傳過來，屬性要設 public
        this.names = names;
    }

    
    // 選單
    public void menu() {                                                    // 為了要讓 VoteTest 讀的到，屬性要設 public

        System.out.println("最受歡迎歌手票選");
//        System.out.println("1. " + this.names);
//        System.out.println("2. " + this.names);
//        System.out.println("3. " + this.names);
//        System.out.println("4. 結票");
        for (int i = 0; i < this.names.length; i++) {
            this.num = i + 1;
            System.out.println(this.num + ". " + this.names[i]);
        }
        System.out.println((this.names.length + 1) + ". 結束");
        System.out.println("----------------");
        entVot();

    }

    
    // 輸入選項
    void entVot() {

        do {
            try {                                                                                                               // 例外處理
                System.out.print("請輸入代號 > ");
                Scanner sc = new Scanner(System.in);
                this.choice = sc.nextInt();
                if (this.choice == 1) {
                    this.b[0]++;
                } else if (this.choice == 2) {
                    this.b[1]++;
                } else if (this.choice == 3) {
                    this.b[2]++;
                } else if (this.choice == 4) {
                    System.out.println("\n==== 投票結果 ====");
                    statistics();
                    System.out.println("Bye.");
                    break;
                }
                callOutBallot();                                                                                        // 唱票
                statistics();                                                                                               // 票數顯示
            } catch (InputMismatchException e1) {                                               // 例外一：錯誤字元
                System.out.println("請輸入正確選項。");
            }catch (ArrayIndexOutOfBoundsException e2){                             // 例外二：超出範圍數值(超出預設陣列大小)
                System.out.println("數值過大。");
            }
        } while (this.choice != 4);                                                                             // 如果 repeat 為 true，或輸入值不為 4，繼續執行迴圈

    }

    
    // 唱票
    void callOutBallot() {
        
        if (this.choice >= 1) {                                                                                 // 防止沒人投票就結票產生錯誤(矩陣位置指定為負數)
            System.out.println(this.a[this.choice - 1] + "  1票");
        }
        waitSec();
        
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
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(this.a[i] + " 有 " + this.b[i] + " 票\n");
        }
        System.out.println("------------------");
        waitSec();
        
    }

    
}