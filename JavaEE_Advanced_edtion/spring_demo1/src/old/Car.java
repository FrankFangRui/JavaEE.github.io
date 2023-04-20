package old;

/**
 * @author 方锐
 * @since 2023/4/20 19:11
 */
public class Car {
    private Framework framework;

    public Car(int size) {
        framework = new Framework(size);
    }
    public void init(){
        // 创建一个车，要有车身
        System.out.println("创建了一辆车");
        framework.init();
    }
}
