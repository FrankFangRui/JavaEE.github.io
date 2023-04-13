import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class HWUdpTranslateServer extends HWUdpEChoServer {
    // 创建字典 最重要的 map 结构
    private Map<String,String> dict = new HashMap<>();
    public HWUdpTranslateServer(int port) throws SocketException {
        super(port);
        dict.put("cat","小猫");
        dict.put("dog","小狗");
    }
    @Override
    public String process(String request){
        return dict.getOrDefault(request,"词未在词典中找到");
    }

    public static void main(String[] args) throws IOException {
        HWUdpTranslateServer server = new HWUdpTranslateServer(9092);
        server.start();
    }
}
