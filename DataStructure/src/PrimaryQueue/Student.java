package PrimaryQueue;

/**
 * @author 方锐
 * @since 2023/5/1 15:17
 */
public class Student implements Comparable<Student> {
    public int age;

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
