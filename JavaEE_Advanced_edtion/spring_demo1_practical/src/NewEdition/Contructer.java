package NewEdition;

/**
 * @author 方锐
 * @since 2023/5/13 10:11
 */
public class Contructer {
    public static void main(String[] args) {
        int size = 100;
        Tires tires = new Tires();
        Bottom bottom = new Bottom(tires);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.init();
    }
}
