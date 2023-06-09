import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * @author 方锐
 * @since 2023/3/29 15:27
 */
// 使用这个类来封装 DataSource 的单例
public class DBUtil {
    private static volatile DataSource dataSource = null;

    public static DataSource getDataSource(){
        if(dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java105?characterEncoding=utf8&useSSL=false");
                    ((MysqlDataSource) dataSource).setUser("root");
                    ((MysqlDataSource) dataSource).setPassword("123123");
                }
            }
        }
        return dataSource;
    }
    private DBUtil(){

    }
}
