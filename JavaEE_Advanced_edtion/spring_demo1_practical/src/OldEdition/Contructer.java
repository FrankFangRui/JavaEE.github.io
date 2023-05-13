package OldEdition;

/**
 * @author 方锐
 * @since 2023/5/13 10:11
 */
public class Contructer {
    public static void main(String[] args) {
        Tires tires = new Tires();
        Bottom bottom = new Bottom(tires);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.init();
    }
}
