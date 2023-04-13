import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 方锐
 * @since 2023/3/21 21:04
 */
@WebServlet("/ShowRequestServlet")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp 是响应对象，setContentType,给响应的ContentType设置了值 : html
        // 声明响应 body 是 html 结构的数据
        resp.setContentType("text/html");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<br>");
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());

        // 把请求的 header 也拼进来
        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            stringBuilder.append("<br>");
            stringBuilder.append(name + ": " + value);
        }
        resp.getWriter().write(stringBuilder.toString());
    }
}
