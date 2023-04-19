import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 方锐
 * @since 2023/3/28 14:54
 */
public class JDBCSelect {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105?characterEncoding=utf8&useSSl=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setURL("123123");

        Connection connection = dataSource.getConnection();

        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        // 查询语句要使用 executeQuery 来完成
        // 返回的结果是 ResultSet, 结果集，里面是一个“表”这样的数据结构
        // 一个表有很多行和列
        ResultSet resultSet = statement.executeQuery();

        // 遍历结果集
        while(resultSet.next()){
            // 每次循环，就能获取到 resultSet 中的一行，进一步就可以拿到每一列
            // getXXX 也是有一系列方法的，会根据要取的数据的类型，来灵活决策
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id =" + id + ", name =" + name);
        }

        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
