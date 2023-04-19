import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/3/22 16:45
 */
class Student {
    // 1.这个类里面的属性必须是 public 或者带有 public 的 getter/setter
    // 否则 jaskson 无法访问这个对象的属性
    // 2.这个类必须要有无参版本的构造方法，如果不写任何构造方法，编译器能够自动生成无参构造方法
    public int studentId;
    public String studentName;
}

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 此处假设请求的body格式为
        // { studentId: 10,studentName:张三
        // jackson 提供的核心的类
        // 一个方法叫做 readValue,把 json 格式的数据转成 java 的对象
        // 还有一个方法叫做 writeAsString,把 java 对象转成 json 格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        // readValue 第一个参数可以是字符串，也可以是输入流
        // 第二个参数，是一个类对象, 就是要解析出来的结果的对象的类
        Student s = objectMapper.readValue(req.getInputStream(),Student.class);
        System.out.println(s.studentId);
        System.out.println(s.studentName);

        //  resp.setContentType("text/html; charset=utf8");
        //resp.getWriter().write(s.studentId + ", " + s.studentName);
          resp.setContentType("application/json;charset=utf8");
          resp.getWriter().write(objectMapper.writeValueAsString(s));
    }
}
