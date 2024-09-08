package ra.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    protected static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(1, "Hoc", true));
        todos.add(new Todo(2, "Choi", true));
        todos.add(new Todo(3, "Don dep", true));
    }

    protected void deletebyId(int idDel) {
        todos = todos.stream()
                .filter(todo -> todo.getId() != idDel)
                .collect(Collectors.toList());
    }
    protected Todo getTodobyId(int idEdit) {
     return todos.stream()
             .filter(todo->todo.getId()==idEdit)
             .findFirst()
             .orElse(null);
    }
    protected int getNewId(){
        int idMax = todos.stream()
                .mapToInt(Todo::getId)
                .max()
                .orElse(0);
        return idMax+1;
    }

    protected void doAddTodo(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>"+
                "<head><title>Thêm Công Việc</title></head>"+
        "<body>"+
        "<h1>Thêm Công Việc Mới</h1>"+

        "<form action='/TodoServlet' method='post'>"+
        "<input type='hidden' name='action' value='ADD'>"+
        "<label for='content'>Nội dung công việc:</label>"+
        "<input type='text' name='content' id='content' required>"+
        "<input type='submit' value='Thêm'>"+
        "</form>"+

        "</body>"+
        "</html>");
    }
    protected void formEdit(HttpServletResponse response, int id) throws IOException {
        Todo todoEdit = getTodobyId(id);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Sửa Công Việc</title></head>");
        out.println("<body>");
        out.println("<h1>Sửa Công Việc Mới</h1>");

        out.println("<form action='/TodoServlet' method='post'>");
//        out.println("<input type='hidden' name='action' value='UPDATE'>");
        out.println("<label for='content'>Nội dung công việc:</label>");
        out.println("<input type='text' name='id' value=" +todoEdit.getId()+ " readOnly>");
        out.println("<input type='text' name='content' value='"+ todoEdit.getContent()+"'id='content'>");
        out.println("<input type='radio'"+(todoEdit.isStatus()?"checked":"")+" value='true' name='status'> Xong");
        out.println("<input type='radio'"+(!todoEdit.isStatus()?"checked":"")+" value='false' name='status'> Chua Xong");
        out.println("<input type='submit' name='action' value='UPDATE'>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }
    protected void doUpdateTodo(HttpServletRequest request) throws  IOException {
        int idEdit = Integer.parseInt(request.getParameter("id"));
        String updatedContent = request.getParameter("content");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        Todo todoUpdate= getTodobyId(idEdit);
        if (todoUpdate!=null){
            todoUpdate.setContent(updatedContent);
            todoUpdate.setStatus(status);
        }
    }
    protected void displayTodos(HttpServletResponse response, String searchQuery) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // Đảm bảo searchQuery không bị null và khởi tạo biến cục bộ
        String searchQueryLocal = (searchQuery != null) ? searchQuery : "";

        // Kiểm tra danh sách todos
        if (todos == null) {
            todos = new ArrayList<>();
        }
//        List<Todo> filteredTodos = todos.stream()
//                .filter(t -> t.getContent()!=null && t.getContent().toLowerCase().contains(searchQuery.toLowerCase()))
//                .collect(Collectors.toList());
        // Lọc danh sách todos theo searchQueryLocal
        List<Todo> filteredTodos = todos.stream()
                .filter(t -> {
                    // getContent() không phải là null
                    String content = t.getContent();
                    return content != null && content.toLowerCase().contains(searchQueryLocal.toLowerCase());
                })
                .collect(Collectors.toList());

        String htmlBody = "";
//        for (Todo todo : todos) {
        for (Todo todo : filteredTodos) {
            htmlBody += "  <tr>\n" +
                    "    <th>" + todo.getId() + "</th>\n" +
                    "    <th>" + todo.getContent() + "</th>\n" +
                    "    <th>" + (todo.isStatus() ? "Xong" : "Chua xong") + "</th>\n" +
                    "<th><a href=\"/TodoServlet?action=DELETE&id=" + todo.getId() + "\">Xoa</a></th>\n" +
                    "    <th><a href=\"/TodoServlet?action=EDIT&id=" + todo.getId() +"\">Sua</a></th>\n" +
                    "  </tr>\n";
        }
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<head>\n" +
                "  <title>Danh sach cong viec</title>\n" +
                "</head>" +
                "<body>");
        out.println("<a href=\"/TodoServlet?action=ADD\">Them moi</a>"+

                "<form action='/TodoServlet' method='get'>\n" +
                "  <input type='text' name='search' placeholder='Tìm kiếm công việc' value='"+(searchQuery!=null?searchQuery:"")+"'>\n" +
                "  <button type='submit'>SEARCH</button>\n" +
                "</form>");

        out.println("<table border=\"10\" cellspacing=\"0\" cellpadding=\"15\">\n" +
                "  <thead>\n" +
                "  <tr>\n" +
                "    <th>STT</th>\n" +
                "    <th>Content</th>\n" +
                "    <th>Status</th>\n" +
                "    <th colspan=\"2\">Action</th>\n" +
                "  </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                htmlBody
                + "  </tbody>\n" +
                "</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String searchQuery = request.getParameter("search");

        if (action != null) {
            switch (action) {
                case "GETALL":
                    displayTodos(response, searchQuery);
                    break;
                case "DELETE":
                    deletebyId(Integer.parseInt(request.getParameter("id")));
                    displayTodos(response, searchQuery);
                    break;
                case "ADD":
                    doAddTodo(response);
                    break;
                case "EDIT":
                    int idEdit = Integer.parseInt(request.getParameter("id"));
                    getTodobyId(idEdit);
                    formEdit(response, idEdit);
                    break;
            }
        } else {
            displayTodos(response, searchQuery);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String searchQuery = request.getParameter("search");

        if (action != null) {
            switch (action) {
                case "ADD":
                    String content = request.getParameter("content");
                        int newId= getNewId();
                        todos.add(new Todo(newId, content, false));
                        displayTodos(response, searchQuery);
                        break;
                case "UPDATE":
                    doUpdateTodo(request);
                    displayTodos(response, searchQuery);
                    break;
            }
        }
    }
}