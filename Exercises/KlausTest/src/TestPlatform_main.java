
public class TestPlatform_main {

    public static void main(String[] args) {

        System.out.println(0b1000_0011);    // 二進位表示(只能是正整數)
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(String.format("%8s", Integer.toBinaryString(3)));
        System.out.println(String.format("%8s", Integer.toBinaryString(13)));
        System.out.println(String.format("%8s", Integer.toBinaryString(128)));
        System.out.println(String.format("%8s", Integer.toBinaryString(75)));
        System.out.println(Byte.MIN_VALUE);	// 輸出型別 Byte 的範圍最小值
        System.out.println(Integer.MAX_VALUE);      // 輸出型別 Int 的範圍最大值
        System.out.println(95 / 3.0);   // 3.0 型別為 Double
        System.out.println(95 / 3F);    // 3F 型別為 Float

    }

}
