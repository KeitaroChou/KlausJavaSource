package MOD;

import java.util.Scanner;

public class MOD {
    // showsXXX 表示第幾頻道

    void shows001() {
        System.out.println("台視");
    }

    void shows002() {
        System.out.println("中視");
    }

    void shows003() {
        System.out.println("華視");
    }

    void shows004() {
        System.out.println("ELTA戲劇台");
    }

    void shows005() {
        System.out.println("ELTA體育台");
    }

    void shows006() {
        System.out.println("ELTA綜合台");
    }

    void shows007() {
        System.out.println("Stars Movies HD");
    }

    void shows008() {
        System.out.println("福斯家庭影劇台");
    }

    void shows009() {
        System.out.println("BBC Channel");
    }

    void familySimple() {
        shows001();
        shows002();
        shows003();
    }

    void familyGeneral() {
        shows001();
        shows002();
        shows003();
        shows004();
        shows005();
        shows006();
    }

    void familyFull() {
        shows001();
        shows002();
        shows003();
        shows004();
        shows005();
        shows006();
        shows007();
        shows008();
        shows009();
    }

    void menu() {

//        int enMenu;
        char enMenu;

        System.out.println("----------- 請選擇套餐 ----------");
        System.out.println("A. 家庭好康餐");
        System.out.println("B. 家庭超值餐");
        System.out.println("C. 家庭豪華餐");
        System.out.println("D. 結束");
        System.out.println("--------------------------------");

        Scanner scMenu = new Scanner(System.in);        // 建立物件請盡量於迴圈外，避免建立數個相同用途的物件，節省記憶體空間。

        do {

            System.out.print("請輸入選項 > ");
//            enMenu = scMenu.nextInt();                                // 輸入數值的取用
            enMenu = scMenu.nextLine().charAt(0);               // 輸入字串的取用、指定取用第一個字元

            // 如果 enMenu 指定為 char，判斷的依據就會是該字元的 Unicode 碼
            if (enMenu == 'A') {
                familySimple();
            } else if (enMenu == 'B') {
                familyGeneral();
            } else if (enMenu == 'C') {
                familyFull();
            } else if (enMenu == 'D') {
                System.out.println("Bye.");
            } else {
                System.out.println("請輸入正確選項。");
            }

        } while (enMenu != 'D');

    }

}
