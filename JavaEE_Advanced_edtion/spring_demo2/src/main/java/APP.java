import com.demo.componet.ArticleController;
import com.demo.componet.aController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author 方锐
 * @since 2023/4/21 16:33
 */
public class APP {
    public static void main(String[] args) {
        // 1. 先得到 Spring 对象
        System.out.println("beanFactory对象还未创建");
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring_config.xml"));
        System.out.println("beanFactory对象创建成功");

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

    }
}
