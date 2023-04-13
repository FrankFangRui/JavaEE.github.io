package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/3/29 16:59
 */
// 登录成功后，跳转到的主页
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*首页中也先获取 session, 此处的 session 正是刚才登录页的时候，登录成功的逻辑中创建出来的
        * 此出 参数 写作 false 即可，表示不新建，如果不存在，就返回 null 就是了*/
        //getSession(false)确保了登录index页面的时候，如果没有登录，不会自动生成 session，因为session
        //是要在登录成功的时候才能生成的，接下来就可以单独处理未登录，即req.getSession(false)返回null的情况
        //再特殊处理
        HttpSession session = req.getSession(false);
        if(session == null){
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("您尚未登录，不能访问主页！");
            return;
        }

        String username = (String)session.getAttribute("username");

        resp.getWriter().write("欢迎来到主页!" + username);
    }
}
