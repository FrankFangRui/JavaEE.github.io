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
 * @since 2023/3/29 16:58
 */
//使用这个类来处理登录请求
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 从请求中获取到页面提交的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.验证用户名密码是否正确
        // 正常这个操作要查数据库，此处为了简单，直接写成了硬编码
        // 把正确的用户名和密码写死了，不是从数据库中提取出用户名和密码
        // 假定正确的密码是 zhangsan 123
        if("zhangsan".equals(username) && "123".equals(password)){
            //登录成功
            // a) 创建一个会话,用户刚登录成功，之前是没有会话的，重新分配个新的会话给用户
            // getSession
            //    1.创建一个sessionId 和一个 HttpSession 对象
            //    2.把这两个内容以键值对的形式插入到内存的 哈希表 中
            //    3.把 sessionId 通过 Set-Cookie 写到响应中
            // getSession(true) 表明当前会话如果不存在就创建一个
            // 新的键值对(新的session对象），保存到 哈希表 中，并把生成的 sessionId
            // 返回到浏览器这里，如果存在就直接返回对应的 HttpSession
            HttpSession session = req.getSession(true);
            // 随意地设置“键值对”了，（HttpSession 对象自身也相当于一个 哈希表）
            session.setAttribute("username","zhangsan");
            // b) 让响应重定向到主页
            resp.sendRedirect("index");
        } else {
            //登录失败
            resp.setStatus(403);
            resp.setContentType("text/html; charset=utf8");
            resp.getWriter().write("登陆失败");
        }
    }
}
