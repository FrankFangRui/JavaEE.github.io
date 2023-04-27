import com.demo.component.BeanLifeComponent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 方锐
 * @since 2023/4/27 14:53
 */
public class App2 {
    public static void main(String[] args) {
        //为什么不用ApplicationContext，因为这个类中没有销毁方法，它的子类ClassPathXmlApplicationContext有
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
        // 获取 .xml 中的 Bean 对象，通过id和类型
        BeanLifeComponent beanLifeComponent = applicationContext.getBean("myComponent",
                BeanLifeComponent.class);
        System.out.println("使用Bean");
        // 销毁Bean
        applicationContext.destroy();
    }
}
