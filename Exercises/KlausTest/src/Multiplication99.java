// =====================
// 迴圈九九乘法表 (極致版)
// =====================

public class Multiplication99 {

    public static void main(String[] args) {
       
        for (int i = 1, j = 1; i <= 9;) {
            System.out.printf("%s * %s = %s%s%s", i, j, (i * j) < 10 ? " " : "", i * j, j == 9 ? "\n" : ", ");
            i = (j = j + 1 == 10 ? 1 : j + 1) == 1 ? i + 1 : i;
        }
        
    }
    
}
