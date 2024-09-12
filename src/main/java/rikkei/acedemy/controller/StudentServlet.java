package rikkei.acedemy.controller;

import rikkei.acedemy.model.Student;
import rikkei.acedemy.service.student.IStudentService;
import rikkei.acedemy.service.student.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    public IStudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("studentsSer", studentService.getAll());
                    request.getRequestDispatcher("/bt/list.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    studentService.delete(idDel);
                    response.sendRedirect("/StudentServlet?action=GETALL");
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("student", studentService.findById(idEdit));
                    request.getRequestDispatcher("/bt/edit.jsp").forward(request, response);
                    break;
                case "SEARCH":
                    String studentName = request.getParameter("name");
                    List<Student> searchResult = studentService.searchByName(studentName);
                    request.setAttribute("studentsSer", searchResult);
                    request.getRequestDispatcher("/bt/list.jsp").forward(request, response);
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
                    Student newStudent = new Student(
                            0,
                            request.getParameter("fullName"),
                            request.getParameter("email"),
                            request.getParameter("address"),
                            request.getParameter("phone"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    studentService.create(newStudent);
                    response.sendRedirect("/StudentServlet?action=GETALL");
                    break;
                case "UPDATE":
                    Student updateStudent = new Student(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("fullName"),
                            request.getParameter("email"),
                            request.getParameter("address"),
                            request.getParameter("phone"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    studentService.update(updateStudent);
                    response.sendRedirect("/StudentServlet?action=GETALL");
                    break;
            }
        }
    }
}
