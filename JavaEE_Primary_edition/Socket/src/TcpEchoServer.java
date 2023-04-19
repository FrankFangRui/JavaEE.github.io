import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    //代码中会涉及到多个 socket 对象，使用不同的名字来区分
    private ServerSocket listenSocket = null;

    public TcpEchoServer(int port) throws IOException {
        listenSocket = new ServerSocket(port);
        // 店铺外面街道上拉客的人
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService service = Executors.newCachedThreadPool();
        while(true){
            //1.先调用 accept 来接受客户端的连接
            // 店铺里面的服务员，负责和具体的客户对接
            Socket clientSocket = listenSocket.accept();
            //2.再处理这个连接,
            /*Thread t = new Thread(()->{
                try{
                    processConnection(clientSocket);
                } catch (IOException e){
                    e.printStackTrace();
                }
            });
            t.start();*/
            service.submit(new Runnable(){
                public void run(){
                    try {
                        processConnection(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });/*每个线程操作的是自己的 clientSocket 不涉及线程安全问题
            clientSocket 主要是通过 IO 流对象操作的，IO流对象本身是线程安全的
            */

        }
    }
    private void processConnection(Socket clientSocket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线",clientSocket.getInetAddress().toString(),clientSocket.getPort());
        try(InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream()){
            while(true){
                //1. 读取请求并解析
                Scanner scanner = new Scanner(inputStream);
                if(!scanner.hasNext()){
                    // 读完了之后，连接就可以断开了
                    System.out.printf("[%s:%d] 客户端下线!\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    break;
                }
                String request = scanner.next();
                //2. 根据请求计算响应
                String response = process(request);
                //3. 把响应写回给客户端
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                //刷新缓冲区确保数据确实是通过网卡发送出去了
                printWriter.flush();

                System.out.printf("【%s:%d] req: %s; resp: %s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            clientSocket.close();
        }
    }
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9099);
        server.start();
    }

}
