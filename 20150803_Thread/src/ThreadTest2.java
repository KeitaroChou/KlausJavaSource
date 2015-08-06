
class Mission implements Runnable {     // 實裝介面 Runnable

    int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            String name = Thread.currentThread().getName();     // 取得目前執行緒的名字
            System.out.println(name + ": " + i);
        }
    }
}

public class ThreadTest2 {

    public static void main(String[] args) {

        Mission task = new Mission();
        // 兩個執行緒共用一個 task
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        
    }

}
