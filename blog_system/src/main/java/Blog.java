import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author 方锐
 * @since 2023/4/3 11:25
 */
public class Blog {
    private int blogId;
    private String title;
    private String content;
    //mysql里面的 datatime 和 timestamp 类型都是在 java 中使用 Timestamp 表示的
    private Timestamp postTime;
    private int userId;

    public int getBlogId() {
        return blogId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPostTime() {
        // 设定格式化的时间日期
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return simpleDateFormat.format(postTime);
        //此时不是直接返回postTime,而是返回一个 设定好格式的 时间戳
    }

    public int getUserId() {
        return userId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
