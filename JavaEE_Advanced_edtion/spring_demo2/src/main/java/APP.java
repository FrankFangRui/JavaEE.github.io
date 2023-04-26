import com.demo.componet.ArticleController;
import com.demo.componet.UserComponent;
import com.demo.componet.aController;
import com.demo.controller.StudentController;
import com.demo.model.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 方锐
 * @since 2023/4/21 16:33
 */
public class APP {
    public static void main(String[] args) {
        // 1. 先得到 Spring 对象
        System.out.println("ApplicationContext对象还未创建");

        System.out.println("ApplicationContext对象创建成功");

        // 2. 在 Spring 当中获取 Bean 对象
        // getBean方法
        // 根据 bean 名称（标识） 来得到 bean 对象
        /*User user = context.getBean("user",User.class);
        User2 user2 = context.getBean("user2",User2.class);*/
        //User user = beanFactory.getBean("user", User.class);
        //User2 user2 = beanFactory.getBean("user2", User2.class);
        //ArticleController articleController = beanFactory.getBean("articleController",ArticleController.class);
        //aController controller = beanFactory.getBean("aController",aController.class);


        // 3. 使用Bean（可选项）
//        System.out.println(user.sayHi());
//        System.out.println(user2.sayHi());
        //System.out.println(articleController.sayHello());
        //System.out.println(controller.sayHello());
        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        //BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring_config.xml"));
        // BeanFactory 出现的早，读取.xml文件中内容没问题，但是读取类中的 bean 注解读不到
        //Student student2 = context.getBean("Student2",Student.class);
        //System.out.println(student2);
        //Student student = context.getBean("student",Student.class);
        //System.out.println(student);

        // 获取 Bean 对象，Spring对其进行赋值，然后就可以调用了
        StudentController sc = context.getBean("studentController",StudentController.class);
        sc.sayHi();
    }
}
