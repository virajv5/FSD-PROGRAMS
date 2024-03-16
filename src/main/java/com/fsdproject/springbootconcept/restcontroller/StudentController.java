package com.fsdproject.springbootconcept.restcontroller;

import jakarta.annotation.PostConstruct;
import com.fsdproject.springbootconcept.dto.StudentErrorResponse;
import com.fsdproject.springbootconcept.entity.Student;
import com.fsdproject.springbootconcept.exception.StudentNotFoundException;
import com.fsdproject.springbootconcept.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentController {

    private StudentService studentService;
    private List<Student> allStudents;
    @PostConstruct
    public void loadStudents(){

        allStudents = new ArrayList<>();
        allStudents.add(new Student(1,"Viraj","viraj@gmail.com",6,"Valsad","Male","B.TECH IT"));
        allStudents.add(new Student(2,"Jinal","jinal@gmail.com",8,"Valsad","Female","B.PHARM"));
        allStudents.add(new Student(3,"Gyan","gyan@gmail.com",8,"Valsad","Male","B.TECH ELC"));
        allStudents.add(new Student(4,"Hetvi","hetvi@gmail.com",6,"Lecester","Female","DIPLOMA CE"));
    }
    @GetMapping("/students")
    List<Student> getAllStudents(){return allStudents;}

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        Student matchingStudent = allStudents.stream()
                .filter(student ->student.getId()==studentId)
                .findFirst()
                .orElse(null);

        if(matchingStudent==null)
            throw new StudentNotFoundException("Student not found with id "+studentId);

        return matchingStudent;

    }



    @PostMapping("/students")
    Student addstudent(@RequestBody Student student){

        return studentService.save(student);
    }

    @PatchMapping("/students/{studentId}")
    Student updateStudent(@RequestBody Student student,@PathVariable int studentId){

        return studentService.update(studentId,student);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudentById(@PathVariable int studentId){
        studentService.deleteById(studentId);
        return "Student with id"+studentId+" removed Sucessfully.";
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(String.valueOf(studentNotFoundException.getMessage()));
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }



}
