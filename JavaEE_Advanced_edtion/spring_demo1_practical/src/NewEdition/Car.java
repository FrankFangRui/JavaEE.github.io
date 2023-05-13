package NewEdition;

/**
 * @author 方锐
 * @since 2023/5/13 10:11
 */
public class Car {
    Framework framework;
    public Car(Framework framework){
        this.framework = framework;
        framework.init();
    }
    public void init(){

        System.out.println("车辆组装完毕");
    }
}
