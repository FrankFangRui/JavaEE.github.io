package ioc;

/**
 * @author 方锐
 * @since 2023/4/20 19:54
 */
public class Framework {
    Bottom bottom;

    public Framework(Bottom bottom) {
        this.bottom = bottom;
    }
    public void init() {
        // 依赖地盘
        System.out.println("创建了一个车架");
        bottom.init();
    }
}
