import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author 方锐
 * @since 2023/3/28 8:36
 */
public class JDBCUpdate {
    // 通过 JDBC 来操作数据库，往数据库里面插入一些数据
    // 往 java105 这个数据库中的 student 表里，插入一条数据
    public static void main(String[] args) throws SQLException {
        //1. 创建数据源对象，数据源对象就描述了要访问的数据库是啥，在哪
        // 这里使用了向下转型，调用了子类MysqlDataSource的方法
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123123");

        // 2. 让代码和数据库服务器建立连接
        Connection connection = dataSource.getConnection();
        //System.out.println(connection);

        // [用户输入] 通过用户输入的数据，来确定插入的值
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要插入的学号：");
        int id = scanner.nextInt();
        System.out.println("请输入要插入的姓名");
        String name = scanner.next();

        // 3.构造要执行的 SQL 语句
        /* String sql = "insert into student values(2,'123')";
        PreparedStatement statement = connection.prepareStatement(sql);*/

        /* String sql = "insert into student values(" + id + ", '" + name +"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("statement:" + statement);*/

        String sql = "insert into student values(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);

        // 4.执行 SQL 【发送请求 & 读取响应】
        // 执行方法，有两个
        // executeUpdate 对应插入删除修改语句，返回值表示这次 SQL 操作影响到的行数
        // executeQuery 对应查询语句，返回值则是返回的临时表数据3
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        // 5. 完成之后，就需要关闭释放相关资源
        statement.close();
        connection.close();
    }
}
