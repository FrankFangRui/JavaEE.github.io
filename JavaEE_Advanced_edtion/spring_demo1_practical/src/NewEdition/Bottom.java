package NewEdition;

/**
 * @author 方锐
 * @since 2023/5/13 10:10
 */
public class Bottom {
    Tires tires;
    public Bottom(Tires tires){
        this.tires = tires;
        tires.init();
    }
    public void init(){

        System.out.println("底盘组装完毕");
    }
}
