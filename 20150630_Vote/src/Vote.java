// =============
// 投票機
// ver1 final
// =============

import java.util.InputMismatchException;
import java.util.Scanner;

public class Vote {

    private final String a[] = {"A-Lin", "Jolin", "A-mei"};
    private final int b[] = {0, 0, 0};                                                                          // 累計投票數
    private int choice = 0;                                                                                         // 輸入選項
    private boolean repeat;
    private final Scanner sc = new Scanner(System.in);          // 宣告輸入物件？？？？

    public void runGroup() {

        do {
            menu();                                         // 選單
            entVot();                                       // 輸入選項
            callOutBallot();                            // 叫票
            waitSec();                                      // 等候一秒
            statistics();                                   // 顯示得票
            waitSec();                                      // 等候一秒
            this.repeat = true;
        } while (this.repeat);

    }

    // 選單
    void menu() {

        System.out.println("最受歡迎歌手票選");
        System.out.println("1. A-Lin");
        System.out.println("2. Jolin");
        System.out.println("3. A-mei");
        System.out.println("4. 結票");
        System.out.println("----------------");

    }

    // 輸入選項
    void entVot() {

        System.out.print("請投票 > ");
        this.choice = sc.nextInt();
        try {
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
            }
        } catch (InputMismatchException e1) {
            System.out.println("請輸入正確字元。");
            this.repeat = true;
        }

    }

    // 唱票
    void callOutBallot() {

        if (this.choice <= this.a.length) {
            System.out.println(this.a[this.choice] + " 得 1 票");
        }

    }

    // 等候一秒
    void waitSec() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }

    }

    // 顯示得票
    void statistics() {

        for (int i = 0; i < this.a.length; i++) {
            System.out.println(this.a[i] + " 目前有 " + this.b[i] + " 票");
        }
        System.out.println("----------------");

    }

}
