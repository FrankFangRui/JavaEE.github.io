package PrimaryQueue.practical1;

import PrimaryQueue.Student;

import java.util.Comparator;

/**
 * @author 方锐
 * @since 2023/5/4 9:09
 */
public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        // return o1.age - o2.age;
        // 当要生成大根堆就
        return o2.age - o1.age;
    }
}
