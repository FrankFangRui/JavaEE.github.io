package old;


/**
 * @author 方锐
 * @since 2023/4/20 19:12
 */
public class Framework {
    private Bottom bottom;

    public Framework(int size) {
        bottom = new Bottom(size);
    }
    public void init(){
        //创建一个车身，需要车的地盘
        System.out.println("创建了一个车架");
        bottom.init();
    }
}
