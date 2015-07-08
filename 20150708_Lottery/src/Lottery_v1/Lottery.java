package Lottery_v1;

import java.util.ArrayList;

public class Lottery {

    private static ArrayList numArray;
    private static ArrayList lottArray;
    private static int index;

    public static void randFactory() {
        for (int i = 0; i < 6; i++) {
            System.out.println((int) (Math.random() * 42) + 1);          // 生成亂數 1 ~ 42
        }
    }

    /**
     * 建立數字與樂透陣列物件
     */
    private static void setupArray() {

        Lottery.numArray = new ArrayList();
        Lottery.lottArray = new ArrayList();

    }

    /**
     * 生成42個整數，放進 numArray 可調式陣列
     */
    private static void numPullInArray() {

        for (int i = 0; i < 42; i++) {
            Lottery.numArray.add(i);
        }

    }

    /**
     * 用亂數產生一個陣列索引
     */
    private static void randomSetIndexArray() {
        
        Lottery.index = (int)(Math.random() * Lottery.numArray.size());         // 0 ~ 41
        
    }
    
}
