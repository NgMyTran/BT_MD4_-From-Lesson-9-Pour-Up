package rikkei.acedemy.service.student;

import rikkei.acedemy.IGenericService;
import rikkei.acedemy.model.Student;

import java.util.List;

public interface IStudentService extends IGenericService <Student, Integer> {

    List<Student> searchByName(String studentName);
}

