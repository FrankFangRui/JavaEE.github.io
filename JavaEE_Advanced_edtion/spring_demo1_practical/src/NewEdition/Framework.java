package NewEdition;

/**
 * @author 方锐
 * @since 2023/5/13 10:10
 */
public class Framework {
    Bottom bottom;
    public Framework(Bottom bottom){
        this.bottom = bottom;
        bottom.init();
    }
    public void init(){
        System.out.println("框架组装完毕");
    }
}
