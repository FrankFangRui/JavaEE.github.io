


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 方锐
 * @since 2023/4/1 20:32
 */
//通过这个类来封装 DataSource
public class DBUtil {
    private static volatile DataSource dataSource = null;

    private static DataSource getDataSource() {
        if (dataSource == null) {//判定是否要加锁
            //针对类对象进行加锁
            synchronized (DBUtil.class){
                if(dataSource == null) {//判定是否要创建对象
                    dataSource = new MysqlDataSource();
                    //上传服务器时候，要改 mysql 的密码
//                    ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105_blog_system?characterEncoding=utf8&useSSL=false");
//                    ((MysqlDataSource) dataSource).setUser("root");
//                    ((MysqlDataSource) dataSource).setPassword("123123");
                    ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105_blog_system?characterEncoding=utf8&useSSL=false");
                    ((MysqlDataSource) dataSource).setUser("root");
                    ((MysqlDataSource) dataSource).setPassword("");
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    //从前到后进行创建，从后到前进行释放
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
