
public class ThreadTest_Boy {

    public static void main(String[] args) {

        Boy a = new Boy("0BwIdzAjvQ8FwYVMxQUhXQUV2b0k", "src/android-0.png");       // 指定下載位址與儲存位址
        Boy b = new Boy("0BwIdzAjvQ8FwX1FzZDI4UHUwUXM", "src/android-1.png");
        Boy c = new Boy("0BwIdzAjvQ8FwN2kzVklxTmF3QmM", "src/myjava/asciiart.txt");
        
        a.start();
        b.start();
        c.start();

    }

}
