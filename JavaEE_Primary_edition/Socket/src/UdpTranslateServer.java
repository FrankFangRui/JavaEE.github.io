import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpTranslateServer extends UdpEchoServer{
    //翻译 本质 上就是通过 key 找到 value
    private Map<String,String> dict = new HashMap<>();

    public UdpTranslateServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
        // 字典程序 里面 有一个很大的哈希表 能包含非常多的单词
    }
    // 重写 process 方法，实现查询哈希表的操作
    @Override
    public String process(String request){
        return dict.getOrDefault(request,"词未在词典中找到");
    }
    // start() 方法 和 父类 中的一样，就不用写了
    public static void main(String[] args) throws IOException {
        UdpTranslateServer server = new UdpTranslateServer(9090);
        server.start();
    }
}
