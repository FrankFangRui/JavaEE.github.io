package ioc;

/**
 * @author 方锐
 * @since 2023/4/20 19:54
 */
public class Tire {
    private int size = 20;
    private String color = "黑色" ;

    public Tire(int size, String color) {
        this.size = size;
        this.color = color;
    }

    public void init(){
        System.out.println("创建了一个轮胎");
        System.out.println("轮胎的尺寸是：" + size + " 轮胎的颜色是：" + color);
    }
}
