import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 方锐
 * @since 2023/4/3 11:37
 */
// 封装了针对用户表的相关操作
public class UserDao {
    // 根据用户名来查询用户的详情 -- 登录（根据用户名查询密码是否匹配）
    // 隐含约束：用户名需要唯一
    public User selectByName(String username){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.和数据库建立连接
            connection = DBUtil.getConnection();
            // 2.构造SQL
            String sql = "select * from User where username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            // 3.执行SQL
            // 返回的 Result 对象，包含了查询结果集中的所有行和列
            resultSet = statement.executeQuery();
            // 4.遍历结果集合
            if(resultSet.next()){
                User user = new User();
                //如果这个列中只有一个数,就可以用
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user .setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放对应的资源
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }

    public User selectById(int userId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.和数据库建立连接
            connection = DBUtil.getConnection();
            // 2.构造SQL
            String sql = "select * from User where userId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            // 3.执行SQL
            // 返回的 Result 对象，包含了查询结果集中的所有行和列
            resultSet = statement.executeQuery();
            // 4.遍历结果集合
            if(resultSet.next()){
                User user = new User();
                //如果这个列中只有一个数,就可以用
                user.setUserId(resultSet.getInt("userId"));
                user.setUsername(resultSet.getString("username"));
                user .setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放对应的资源
            DBUtil.close(connection, statement, resultSet);
        }

        return null;
    }
}
