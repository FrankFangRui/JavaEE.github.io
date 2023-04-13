import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    //服务器socket要绑定固定的端口
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        //1.创建一个服务端ServerSocket,用于收发TCP报文
        ServerSocket server = new ServerSocket(PORT);
        //一直地等待客户端连接
        while(true){
            System.out.println("--------------");
            System.out.println("等待客户端建立TCP连接");
            //2.等待客户端连接，注意该方法为阻塞方法
            /*
            * 开始监听指定端口（创建时绑定的端口），有客户端连接后，
            * 返回一个服务端Socket
            对象，并基于该Socket建立与客户端的连接，否则阻塞等待*/
            Socket client = server.accept();
            System.out.printf("客户端IP: %s%n",client.getInetAddress().getHostAddress());
            System.out.printf("客户端端口号：%s%n",client.getPort());
            //5.接收客户端的数据，需要从客户端socket中的输入流获取
            System.out.println("接收到客户端请求");
            InputStream is = client.getInputStream();
            // 为了方便获取字符串内容，可以将以上字节流包装为字符流
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String line;
            // 一直读取到流结束:TCP 是基于流的数据传输，一定要客户端关闭Socket输出流才表示服务端接收IO输入流结束
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            //6.双方关闭连接：服务端是关闭客户端socket连接
            client.close();

        }
    }
}
