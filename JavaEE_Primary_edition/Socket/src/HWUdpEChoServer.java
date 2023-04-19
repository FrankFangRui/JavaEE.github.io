import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class HWUdpEChoServer {
    private DatagramSocket socket = null;
    // 服务端的 socket 要绑定到一个固定的端口
    public HWUdpEChoServer(int port) throws SocketException {
        // 为了让 客户端 能够找到指定的 服务端 端口
        socket = new DatagramSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动！");
        while(true){// 创空包，接收客户端发送过来的东西，process 处理响应，发送回去
            // 服务器一直保持接收的状态 , 创建一个 空 的数据包，准备接收 client 发来的数据包
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            // 把从网卡 读入 的数据，填入 requestPacket 当中
            socket.receive(requestPacket);
            // 把 requestPacket 对象 从 字节数组 转换成 字符串 ，方便打印
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            // 根据请求计算响应
            String response = process(request);
            // 通过发送过来的 requestPacket 包 解析出 要发送的地址
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            // 打印一个日志，记录当前的情况
            System.out.printf("[%s:%d] req: %s; resp:%s\n",requestPacket.getAddress().toString(),requestPacket.getPort(),request,response);
        }
    }
    public String process(String request){return request;}

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9091);
        server.start();
    }

}
