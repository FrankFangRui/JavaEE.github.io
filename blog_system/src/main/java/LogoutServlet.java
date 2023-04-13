import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/4/12 15:05
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session == null) {
            resp.setStatus(403);
            return;
        }
        // 直接把 session 中之前的 user 对象给删掉即可(没有user就是注销了）
        session.removeAttribute("user");
        // 然后重定向到登录页面
        resp.sendRedirect("login.html");
    }
}
