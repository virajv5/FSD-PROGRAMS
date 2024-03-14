package com.fsdproject.springjpa.restcontroller;
import java.util.*;
import com.fsdproject.springjpa.entity.Student;
import com.fsdproject.springjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
            this.studentService = studentService;
    }

    @GetMapping("/students")
    List<Student> getAllStudents(){
        return studentService.findAll();
    }
}
