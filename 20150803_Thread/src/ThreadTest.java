class Hello extends Thread {
    
    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println(getName() + "Hello" + i);
        }
    }
    
}

public class ThreadTest {

    public static void main(String[] args) {

        for(int i = 0; i < 100; i++) {
            System.out.println("Hello World" + i);
        }
        
        Hello h1 = new Hello();
        h1.setName("h1");
        h1.start();
        
        Hello h2 = new Hello();
        h2.setName("h2");
        h2.start();
        
    }
    
}
