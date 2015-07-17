import java.util.Scanner;

public class AnimalTest02 {

    public static void main(String[] args) {
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Bird");
        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();
        Animal a = null; // 多型
        if (menu == 1) {
            a = new Dog();  // 可控制 Dog
        } else if (menu == 2) {
            a = new Cat();  // 可控制 Cat
        } else if (menu == 3) {
            a = new Bird(); // 可控制 Bird
        }
        a.attack();
    }
}
