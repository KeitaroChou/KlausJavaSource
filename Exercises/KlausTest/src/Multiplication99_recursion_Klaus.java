// =====================
// 遞迴九九乘法表 (自寫版)
// =====================

public class Multiplication99_recursion_Klaus {

    public static void main(String[] args) {

        print99(1, 1);

    }

    static void print99(int x, int y) {

        // 如果 x == 9 就執行該行最後計算並且換行，前進下一輪計算
        if (x == 9) {
            System.out.println(x + " * " + y + " = " + x * y + "\t");
            if (y < 9) {
                // 將x從原本累加至9的值，指回1，並把y加1
                print99(1, y + 1);
            }
        } else {
            // 字串不換行，一行中前八個計算的執行
            System.out.print(x + " * " + y + " = " + x * y + "\t");
            print99(x + 1, y);
        }

    }

}
