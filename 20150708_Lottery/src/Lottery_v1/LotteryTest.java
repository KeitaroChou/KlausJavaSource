package Lottery_v1;

public class LotteryTest {

    public static void main(String[] args) {

        for (int i = 0; i < 6; i++) {
            System.out.println((int) (Math.random() * 60) + 1);     // 亂數 1 ~ 60
        }

    }

}
