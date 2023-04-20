package old;

/**
 * @author 方锐
 * @since 2023/4/20 19:19
 */
public class Bottom {
    private Tire tire;

    public Bottom(int size) {
        tire = new Tire(size);
    }

    public void init(){
        //依赖轮胎
        System.out.println("创建了一个底盘");
        tire.init();
    }
}
