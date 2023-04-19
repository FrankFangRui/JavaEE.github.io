import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/3/23 17:27
 */
@WebServlet("/autoRefresh")
public class AutoRefreshServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 直接返回响应就可以了
        resp.setHeader("refresh","1");
        // 记录启动时间
        resp.getWriter().write(System.currentTimeMillis() + "");
    }
}
