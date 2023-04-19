import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 方锐
 * @since 2023/3/23 19:52
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    //这个对象在doGet,doPost方法中都需要使用,直接设置为成员变量
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<Message> messageList = new ArrayList<>();

    //负责让页面获取到数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显示声明当前的响应数据类型，不要让客户端去猜，也为了能在前端代码中让 jquery 自动识别数据内容并解析
        resp.setContentType("application/json; charset=utf8");
        //只需要一行代码， 把 messageList 转成 json 字符串，并返回给页面即可
        //通过 writeValueAsString 把服务器上保存的 json 数据转换成 String，通过write输出到屏幕上
//        resp.getWriter().write(objectMapper.writeValueAsString(messageList));
        try {

            List<Message> messageList = load();
            resp.getWriter().write(objectMapper.writeValueAsString(messageList));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取到 body 中的数据并解析
        // req.getInputStream() 获取发送过来的 req 中的请求体中的内容，将其转换成 Message.class 中的Java形式
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        // 把 message 保存一下，最简单的办法就是保存在内存当中（用 List 来保存一下）
        try {
            save(message);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.setStatus(200);
        System.out.println("提交数据成功：from=" + message.getFrom()
                + ", to=" + message.getTo() + ", message=" + message.getMessage());
    }
    private List<Message> load() throws SQLException {
        // 从数据库查询数据

        // 把数据保存到数据库中

        // 1. 先有一个数据源
        DataSource dataSource = DBUtil.getDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123123");

        // 2.建立连接
        Connection connection = dataSource.getConnection();

        // 3.构造 SQL
        String sql = "select * from message";
        PreparedStatement statement = connection.prepareStatement(sql);


        // 4.执行 SQL
        ResultSet resultSet = statement.executeQuery();


        // 5.遍历结果集合
        List<Message> messageList = new ArrayList<>();
        while(resultSet.next()){
            Message message = new Message();
            message.setFrom(resultSet.getString("from"));
            message.setTo(resultSet.getString("to"));
            message.setMessage(resultSet.getString("message"));
            messageList.add(message);
        }

        // 6.关闭连接
        statement.close();
        connection.close();
        return messageList;
    }
    private void save(Message message) throws SQLException {
        // 把数据保存到数据库中

        // 1. 先有一个数据源
        DataSource dataSource = DBUtil.getDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123123");

        // 2.建立连接
        Connection connection = dataSource.getConnection();

        // 3.构造 SQL
        String sql = "insert into message values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,message.getFrom());
        statement.setString(2,message.getTo());
        statement.setString(3,message.getMessage());

        // 4.执行 SQL
        int ret = statement.executeUpdate();
        System.out.println("ret = " + ret);

        // 5.关闭连接
        statement.close();
        connection.close();
    }
}
