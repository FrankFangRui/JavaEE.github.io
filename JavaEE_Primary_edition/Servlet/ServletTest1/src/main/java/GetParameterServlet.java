import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/3/22 9:32
 */
@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取query string中的键值对
        // 假设浏览器的请求形如 ?studentId=10&studentName=张三
        // 以字符串形式，返回query string 中 key 对应的 value
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(studentId + ", " + studentName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过 body 获取，发送个 post 请求
        // 预期请求的 body 里是 studentId=10&studentName=张三
        req.setCharacterEncoding("utf8");
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        System.out.println(studentId);
        System.out.println(studentName);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(studentId + ", " + studentName);
    }
}
