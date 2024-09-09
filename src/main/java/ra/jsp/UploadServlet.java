package ra.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
// chứ thích kich thuoc cho phep upload
@MultipartConfig(
        fileSizeThreshold = 1024*1024*25,
        maxFileSize = 1024*1024*25,
        maxRequestSize = 1024*1024*10*5
)
@WebServlet(name = "UploadServlet", value = "/UploadServlet")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy ra contextpath trên server:
        ServletContext context = getServletContext();
        // tạo 1 thư mục uploads trên server
        String uploadPath = context.getRealPath("/uploads");
        File uploadFolder = new File(uploadPath);
        if (!uploadFolder.exists()) {
            boolean check= uploadFolder.mkdirs();
        }
        String oneUrl = "";
        List<String> listUrl = new ArrayList<>();
        // vào đay xử li upload
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            if (part.getName().equals("file")){
            String fileName= new Date().getTime() + "_" + part.getSubmittedFileName(); // 9193877534_abc.jpeg
            part.write(uploadPath + File.separator + fileName);
            oneUrl = ("/uploads/" + fileName);
            }else if (part.getName().equals("files")){
                String fileName= new Date().getTime() + "_" + part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
                listUrl.add("/uploads/" + fileName);
            }
        }
        request.setAttribute("oneUrl", oneUrl);
        request.setAttribute("listUrl", listUrl);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }


}