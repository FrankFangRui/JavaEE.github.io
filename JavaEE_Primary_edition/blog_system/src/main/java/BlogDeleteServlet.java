import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/4/12 21:27
 */
@WebServlet("/blog_delete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 先判定用户的登录状态
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("您当前未登录，不能删除！");
            return;
        }
        User user = (User) session.getAttribute("user");
        if(user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("您当前未登录，不能删除！");
            return;
        }
        // 2. 获取到 blogId
        String blogId = req.getParameter("blogId");
        if(blogId == null) {
            //当blogId在数据库中根本不存在的时候，无法删除
            resp.setStatus(404);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("您当前删除的 blogId 有误");
            return;
        }
        //当 blogId 不为 null 的时候走到这里，即 blogId 存在，可能出现博客不存在的情况
        // 当请求中没有 blogId 参数的时候
        // 3. 查询出这个 blogId 对应的 blog 对象
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(Integer.parseInt(blogId));
        if(blog == null) {
            // 当 blogId 不存在的时候，无法删除
            //当blogId在数据库中根本不存在的时候，无法删除
            resp.setStatus(404);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("您当前删除的 blogId 有误");
            return;
        }
        // 4. 判定登录用户是否是文章作者
        if (blog.getUserId() != user.getUserId()) {
            // blog.getUserId() 文章的作者
            // user.getUserId() 从 session 里拿的登录的用户是谁
            // 当这两个不同的情况下，说明在删除别人的文章，要报错
            // 直接返回 403
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前您不能删除别人的博客");
            return;
        }
        // 5. 真正执行删除操作
        blogDao.delete(Integer.parseInt(blogId));
        // 6. 返回 302 重定向
        resp.sendRedirect("blog_list.html");
    }
}
