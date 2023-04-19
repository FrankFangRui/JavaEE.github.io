import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/3/19 17:06
 */
@WebServlet("/hello2")
public class Hello2Servlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello2");
        resp.getWriter().write("thisis/hello2");
    }
}
