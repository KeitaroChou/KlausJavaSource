import java.util.*;

public class TreeSetTestStudent {

    public static void main(String[] args) {

        Student s1 = new Student("Tom", 87, 90);
        Student s2 = new Student("Jhon", 70, 61);
        Student s3 = new Student("Mark", 87, 61);
        Student s4 = new Student("Mark", 87, 90);
        Student s5 = new Student("Tom", 87, 90);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println("\n");
        
        Set<Student> set = new TreeSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        
//        // 精簡寫法
//        set.add(s1 = new Student("Tom", 87, 90));
//        set.add(s2 = new Student("Jhon", 70, 61));
//        set.add(s3 = new Student("Mark", 87, 61));
        
        int rank = 0;
        for(Student stu : set) {
            rank++;
            System.out.println(rank + ". " + stu.toString());
        }
        
    }
    
}
