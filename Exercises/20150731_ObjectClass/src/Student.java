
public class Student implements Comparable<Student> {

    private final String name;
    private final int eng;
    private final int math;
    private final int random;

    public Student(String name, int eng, int math) {

        this.name = name;
        this.eng = eng;
        this.math = math;
        this.random = (int) (Math.random() * 500 + 1);

    }

    @Override
    public String toString() {
        return "\t" + this.name + "\t" + this.eng + "\t" + this.math + "\trandom: " + this.random;
    }

    @Override
    public int compareTo(Student other) {

        if (this.eng > other.eng) {
            return 1;
        } else if (this.eng < other.eng) {
            return -1;
        } else if (this.math > other.math) {
            return 1;
        } else if (this.math < other.math) {
            return -1;
        } else if (this.name.length() > other.name.length()) {
            return 1;
        } else if (this.name.length() < other.name.length()) {
            return -1;
        } else if (this.random > other.random) {
            return 1;
        } else if (this.random < other.random) {
            return -1;
        } else {
            return 0;
        }

    }
}
