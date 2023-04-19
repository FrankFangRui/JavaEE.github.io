import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/3/23 16:34
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 约定，浏览器 query string 传个参数过来
        // 形如 type=1
        // 如果 type 为 1， 返回 200; type 为 2，返回404；type 为 3，返回500
        String type = req.getParameter("type");
        if(type.equals("1")){
            resp.setStatus(200);
        } else if (type.equals("2")){
            resp.setStatus(404);
            //sendError 效果就是返回一个 tomcat 自带的错误页面
            resp.sendError(404);
        } else if (type.equals("3")){
            resp.setStatus(500);
        } else {
            resp.setStatus(504);
        }
    }
}
