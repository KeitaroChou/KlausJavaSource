
public class Test {

    public static void main(String[] args) {

        java.util.Random r = new java.util.Random();    // 亂數物件宣告

        boolean[] status = new boolean[42 + 1];           // 宣告布林陣列 status 長度42個字=42個狀態
        int[] data = new int[6];                                            // 6筆資料

        for (int i = 0; i < 6;) {                                                   // 產生 6 次
            int tmp = r.nextInt(42) + 1;                                  // 產生範圍 1~42 的整數亂數
            if (status[tmp] == false) {                                   // 未抓過
                data[i] = tmp;
                status[tmp] = true;                                         //設定為抓取過
                i++;
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(data[i] + "\t");
        }

    }

}
