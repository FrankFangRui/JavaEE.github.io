

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/4/10 19:02
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户信息
        String blogId = req.getParameter("blogId");
        if(blogId == null) {
            //列表页，获取当前登录用户的信息
            // 直接从 session 中获取就可以
            getUserInfoFromSession(req, resp);
        } else {
            //详情页，获取文章作者的信息
            // 查询数据库
            getUserInfoFromDB(req, resp, Integer.parseInt(blogId));
        }
    }

    private void getUserInfoFromDB(HttpServletRequest req, HttpServletResponse resp, int blogId) throws IOException {
        // 在这里用了两个 sql 语句完成从数据库获取用户信息这个逻辑
        // 也可以用一个 sql 完成
        // 1）联合查询，2) 子查询

        // 1. 现根据 blogId 查询 Blog 对象，获取到 userId(作者是谁）
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectOne(blogId);
        if(blog == null) {
            // 如果参数传来的这个 blogId 是随便瞎写的，数据库里面没有，就报错
            resp.setStatus(404);
            resp.setContentType("text/html;charset=urf8");
            resp.getWriter().write("blogId 不存在");
            return;
        }
        // 2.根据 userId 查询对应的 User 对象即可
        UserDao userDao = new UserDao();
        User user = userDao.selectById(blog.getUserId());
        if(user == null){
            resp.setStatus(404);
            resp.setContentType("text/html;charset=urf8");
            resp.getWriter().write("blogId 不存在");
            return;
        }
        // 3. 把 user 对象返回给浏览器
        user.setPassword("");
        resp.setContentType("application/json;charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }

    private void getUserInfoFromSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        // 当前没有登录记录
        if(session == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前未登录");
            return;
        }
        //当前有登录记录，但是没有user
        User user = (User) session.getAttribute("user");
        if(user == null) {
            resp.setStatus(403);
            resp.setContentType("text/html;charset=utf8");
            resp.getWriter().write("当前未登录");
            return;
        }
        // user 获取到了，把 user 中的 password 给干掉，然后返回
        user.setPassword("");

        //将数据返回
        resp.setContentType("application/json; charset=utf8");
        resp.getWriter().write(objectMapper.writeValueAsString(user));
    }
}
