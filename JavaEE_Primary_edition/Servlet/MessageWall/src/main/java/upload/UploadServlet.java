package upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author 方锐
 * @since 2023/4/1 10:09
 */
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("myfile");
        System.out.println(part.getSubmittedFileName());
        System.out.println(part.getSize());
        System.out.println(part.getContentType());
        part.write("D:/4Kpictures/5f0fa9032631525c507f0fff6ee8fc2a405561962.png");
    }
}
