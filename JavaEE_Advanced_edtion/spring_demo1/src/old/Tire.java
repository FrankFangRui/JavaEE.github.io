package old;

/**
 * @author 方锐
 * @since 2023/4/20 19:19
 */
public class Tire {
    private int size = 20;
    public Tire() {

    }
    public Tire(int size){
        this.size = size;
    }

    public void init(){
        System.out.println("创建了一个轮胎");
        System.out.println("执行了轮胎初始化方法, size:" + this.size);
    }
}
