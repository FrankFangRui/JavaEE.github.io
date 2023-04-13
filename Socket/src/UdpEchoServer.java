import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    // 参数的端口 表示 我们的服务器要绑定的端口；
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    // 数据库服务器启动就会绑定 3306 端口
    // 目的就是能够让客户端明确是主机上的哪个进程

    // IP 确定主机， 端口号 确定 主机中的哪个程序
    // 想要通过一个端口确定一个进程，就需要再这个进程启动的时候绑定一个端口
    // 并且一个端口只能被一个进程绑定（通常情况下）

    //通过这个方法启动服务器
    public void start() throws IOException {
        System.out.println("服务器启动！");
        /*由于服务器不确定，客户端啥时候发请求过来，只能用
        * while（true） 来保持一直接收的状态*/
        while(true){
            // 循环里面处理一次请求
            // 1. 读取请求并解析
            // 创造空的对象
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            // 从网卡读到的数据，给填充到这个对象当中
            socket.receive(requestPacket);
            // 把DatagramPacket对象转换成字符串，方便打印
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            // 2. 根据请求计算响应
            String response = process(request);
            // 3. 把响应写回到客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket); // 发送构造的包裹，包裹要发送的地址包含在了发送过来的包裹
            // 4. 打印一个日志，记录当前的情况
            System.out.printf("[%s:%d] req: %s; resp:%s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }
    // 处理的 请求 request 表示， 返回的响应数据 和 请求是一样的
    public String process(String request){
        return request;
    }
    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
