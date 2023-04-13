package ArrayList;

import jdk.nashorn.internal.ir.CatchNode;

import java.util.List;

public class TestCard {
    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        List<Card> ret = cardDemo.buyDeskCard();
        System.out.println(ret);
        cardDemo.shuffle(ret);
        System.out.println(ret);
        System.out.println("揭牌");
        List<List<Card>> ret2 = cardDemo.test(ret);
        for(List<Card> cards : ret2){
            System.out.println(cards);
        }
        for(int i = 0 ; i < ret2.size(); i++){
            System.out.println("第" + i + "个人的牌" + ret2.get(i));
        }
        System.out.println("剩余的牌");
        System.out.println(ret);
    }
}
