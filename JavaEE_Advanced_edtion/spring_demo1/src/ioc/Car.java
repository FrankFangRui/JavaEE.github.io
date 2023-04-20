package ioc;



/**
 * @author 方锐
 * @since 2023/4/20 19:53
 */
public class Car {
    private Framework framework;

    public Car(Framework framework) {
        this.framework = framework;
    }
    public void init() {
        //依赖车身
        System.out.println("创建一辆车");
        framework.init();
    }
}
