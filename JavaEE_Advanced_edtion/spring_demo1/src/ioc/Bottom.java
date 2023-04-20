package ioc;

/**
 * @author 方锐
 * @since 2023/4/20 19:54
 */
public class Bottom {
    private Tire tire;

    /*public Bottom(int size){
         //传统方法，此处 new 对象，然后传递参数
         tire = new Tire(size);
    }
    */
    //新方法，直接传递类
    public Bottom(Tire tire) {
        this.tire = tire;
    }
    public void init() {
        // 依赖轮胎
        System.out.println("创建了一个底盘");
        tire.init();
    }
}
