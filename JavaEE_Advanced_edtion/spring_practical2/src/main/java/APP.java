import com.demo.controller.AStudentController;
import com.demo.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方锐
 * @since 2023/4/28 9:29
 */
public class APP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        AStudentController aStudentController = context.getBean("AStudentController",AStudentController.class);
        System.out.println(aStudentController.getStudent());

        StudentController studentController = context.getBean("studentController",StudentController.class);
        System.out.println(studentController.getStudent());

    }
}
