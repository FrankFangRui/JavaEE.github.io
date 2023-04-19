import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    // 客户端需要使用这个 socket 来建立连接（和服务器打电话）
    private Socket socket = null;

    public TcpEchoClient(String serverIP,int serverPort) throws IOException {
    // 因为客户端和服务端在同一台主机上，所以 IP 写 127.0.0.1 就可以了
    //和服务器建立连接，就需要知道服务器在哪了
        // 这里和 Udp 客户端差别较大 ， TCP 要在此处先建立连接，UDP在绑定 requestPacket
        // 的之后，指定Pakcet要发送的地方来建立连接
        socket = new Socket(serverIP,serverPort);
}
    public void start(){
        Scanner scanner = new Scanner(System.in);
        try(InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                // 1.从控制台读取数据，构成一个请求
                System.out.println("-->");
                String request = scanner.next();
                // 2.发送请求给服务器
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                // flush 不要忘记，否则可能会导致请求没有真发出去，而是保存在缓冲区当中
                printWriter.flush();
                // 3.从服务器读取响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                // 4.把响应显示到界面上
                System.out.println(response);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9099);
        client.start();
    }
}
