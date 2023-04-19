import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 方锐
 * @since 2023/4/3 11:37
 * +----------+--------------+------+-----+---------+----------------+
 * | Field    | Type         | Null | Key | Default | Extra          |
 * +----------+--------------+------+-----+---------+----------------+
 * | blogId   | int(11)      | NO   | PRI | NULL    | auto_increment |
 * | title    | varchar(256) | YES  |     | NULL    |                |
 * | content  | text         | YES  |     | NULL    |                |
 * | postTime | datetime     | YES  |     | NULL    |                |
 * | userId   | int(11)      | YES  |     | NULL    |                |
 * +----------+--------------+------+-----+---------+----------------+
 */
// 封装针对博客表的相关操作
public class BlogDao {
    // 1. 插入一个博客到数据库中
    public void insert(Blog blog){

        Connection connection = null;
        PreparedStatement statement = null;
        try {
        // 1.和数据库建立连接
        connection = DBUtil.getConnection();
        // 2.构造 SQL
        String sql = "insert into blog value(null, ?, ?, now(), ?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1,blog.getTitle());
        statement.setString(2,blog.getContent());
        statement.setInt(3,blog.getUserId());
        // 3.执行 SQL
        int ret = statement.executeUpdate();
        if(ret != 1){
            System.out.println("博客插入失败");
        }else {
            System.out.println("博客插入成功");
        }
        // close 其实不应该在 try 当中调用，一旦上面抛出异常，此处的 close 可能无法被执行
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放对应的资源
            DBUtil.close(connection, statement, null);
        }

    }

    // 2.根据博客 id 来查询指定博客 -- 博客详情页
    public Blog selectOne(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.和数据库建立连接
            connection = DBUtil.getConnection();
            // 2.构造SQL
            String sql = "select * from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            // 3.执行SQL
            // 返回的 Result 对象，包含了查询结果集中的所有行和列
            resultSet = statement.executeQuery();
            // 4.遍历结果集合
            // 获取的结果不为空
            if(resultSet.next()){
                Blog blog = new Blog();
                //如果这个列中只有一个数,就可以用
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放对应的资源
            DBUtil.close(connection, statement, resultSet);
        }
        // 查询结果为空，直接跳过if 并 return null
        return null;
    }

    // 3.直接查询博客列表 -- 博客列表页
    public List<Blog> selectAll(){
        List<Blog> blogs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 1.和数据库建立连接
            connection = DBUtil.getConnection();
            // 2.构造SQL
            String sql = "select * from blog order by postTime desc ";
            statement = connection.prepareStatement(sql);
            // 3.执行SQL
            // 返回的 Result 对象，包含了查询结果集中的所有行和列
            resultSet = statement.executeQuery();
            // 4.遍历结果集合
            while (resultSet.next()){//查询多条
                Blog blog = new Blog();
                //如果这个列中只有一个数,就可以用getXX精确获得这个数
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                String content = resultSet.getString("content");
                //避免博客列表页显示的内容太长，希望用户点到博客详情页里面再看到这个详细正文
                if (content.length() > 100) {
                    // 如果正文中字符操作100个，只去到前100个字符(0~99)
                    content = content.substring(0,100) + "...";
                }
                blog.setContent(content);
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blog.setUserId(resultSet.getInt("userId"));
                blogs.add(blog);//直接把blog转换成动态数组，blogs 此时 存储blog中的数据
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放对应的资源
            DBUtil.close(connection, statement, resultSet);
        }

        return blogs;//返回查询结果
    }

    // 4.删除指定博客 -- 删除博客
    public void delete(int blogId){
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 1.和数据库建立连接
            connection = DBUtil.getConnection();
            // 2.构造SQL
            String sql = "delete from blog where blogId = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            // 3.执行SQL
            int ret = statement.executeUpdate();
            if(ret != 1){
                System.out.println("博客删除失败");
            } else {
                System.out.println("博客删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //4.释放对应的资源
            DBUtil.close(connection, statement, null);
        }


    }
}
