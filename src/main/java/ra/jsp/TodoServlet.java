package ra.jsp;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    private static List<Todo> todoList = new ArrayList<>();

    static {
        todoList.add(new Todo(1, "ĐI học", true));
        todoList.add(new Todo(2, "ĐI cho", true));
        todoList.add(new Todo(3, "ĐI ngu", false));
    }
    protected int getNewId(){
        int idMax = todoList.stream()
                .mapToInt(Todo::getId)
                .max()
                .orElse(0);
        return idMax+1;
    }
    protected Todo getTodobyId(int idEdit) {
        return todoList.stream()
                .filter(todo->todo.getId()==idEdit)
                .findFirst()
                .orElse(null);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("todos", todoList);
                    request.getRequestDispatcher("/pages/list.jsp").forward(request, response);
                    break;
                case "DELETE":
                    int id = Integer.parseInt(request.getParameter("id"));
                    Todo todoDel = todoList.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
                    if (todoDel != null) {
                        todoList.remove(todoDel);
                    }
//                    response.sendRedirect("/TodoServlet?action=GETALL");
                    response.sendRedirect("/");
                    break;
                case "ADD":
                    request.setAttribute("todos", todoList);
                    request.getRequestDispatcher("/pages/add.jsp").forward(request, response);
                    break;
                case "EDIT":
                    int editId = Integer.parseInt(request.getParameter("id"));
                    Todo editTodo = getTodobyId(editId);
                    request.setAttribute("todoEdit", editTodo);
                    request.getRequestDispatcher("/pages/edit.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    String content = request.getParameter("content");
                    int newId= getNewId();
                    todoList.add(new Todo(newId, content, false));
                    // Chuyển hướng đến trang danh sách công việc sau khi thêm
                    response.sendRedirect(request.getContextPath() + "/TodoServlet?action=GETALL");
                    break;
                case "UPDATE":
                    String idParam = request.getParameter("id").trim();
                    int id = Integer.parseInt(idParam);
                    String updatedContent = request.getParameter("content");
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    Todo todoUpdate = getTodobyId(id);
                    if(todoUpdate!=null) {
                        todoUpdate.setContent(updatedContent);
                        todoUpdate.setStatus(status);
                    }
                    response.sendRedirect(request.getContextPath() + "/TodoServlet?action=GETALL");
                    break;
            }
        }
    }
}