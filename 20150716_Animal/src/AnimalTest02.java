
import java.util.Scanner;

public class AnimalTest02 {

    public static void main(String[] args) {

        int menu;

        System.out.println("0. 結束");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.println("4. Airplane");
        System.out.println("5. Superman");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("> ");
            menu = sc.nextInt();
            Object a = null; // 多型，使用萬能類別 Object
            if (menu == 1) {
                a = new Dog();  // 可控制 Dog
            } else if (menu == 2) {
                a = new Cat();  // 可控制 Cat
            } else if (menu == 3) {
                a = new Bird(); // 可控制 Bird
            } else if (menu == 4) {
                a = new Airplane(); // 可控制 Airplane
            } else if (menu == 5) {
                a = new Superman(); // 可控制 Airplane
            }
//        if(a instanceof Bird) {    // 如果 a 的自訂型別為 Bird，才執行，以免其他不會飛的動物使用到
//            ((CanFly)a).fly();    // 把 a 的遙控器換成 Bird，才能使用 fly()
//        }
            if (a instanceof CanAttack) {
                ((CanAttack) a).attack();
            }
            if (a instanceof CanFly) {
                ((CanFly) a).fly();
            }
        } while (menu != 0);
    }

}
