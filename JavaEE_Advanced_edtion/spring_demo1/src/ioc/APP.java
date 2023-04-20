package ioc;

/**
 * @author 方锐
 * @since 2023/4/20 20:19
 */
public class APP {
    public static void main(String[] args) {
        Tire tire = new Tire(50,"红色");
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.init();
    }
}
