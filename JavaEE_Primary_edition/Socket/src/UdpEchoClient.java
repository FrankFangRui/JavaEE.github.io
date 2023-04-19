import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    // 上面这两个参数一会会在发送数据的时候用到
    // 暂时先把这两个参数存起来，以备后用
    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        // 这里由操作系统自动指定一个空闲的端口
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            //1. 从控制台读取用户输入的内容
            System.out.println("->");
            String request = scanner.next();
            //2. 构造一个 UDP 请求，发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(this.serverIP),this.serverPort);
            socket.send(requestPacket);
            //3. 从服务器读取 UDP 响应数据，并解析
            //创造 responsePacket , 然后把必要的数据 用 receive进行填充
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //4. 把服务器的响应显示到控制台上
            System.out.println(response);
        }
    }
    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();

    }
}
