package com.fsdproject.springbootconcept.service;

import com.fsdproject.springbootconcept.entity.Student;
import com.fsdproject.springbootconcept.exception.StudentNotFoundException;
import com.fsdproject.springbootconcept.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return null;
    }

    @Transactional
    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student update(int studentId, Student updatestudent) {
        Student matchingStudent = findById(studentId);
        if(matchingStudent.getName()!=null){
            matchingStudent.setProgram(updatestudent.getName());
        }
        if(matchingStudent.getCity()!=null){
            matchingStudent.setCity(updatestudent.getCity());
        }
        if(matchingStudent.getGender()!=null){
            matchingStudent.setGender(updatestudent.getGender());
        }
        if(matchingStudent.getEmail()!=null){
            matchingStudent.setEmail(updatestudent.getEmail());
        }
        if(matchingStudent.getSemester()!=0){
            matchingStudent.setSemester(updatestudent.getSemester());
        }
        if(matchingStudent.getProgram()!=null){
            matchingStudent.setProgram(updatestudent.getProgram());
        }

        if(matchingStudent==null){
            throw new StudentNotFoundException("Student with id "+ updatestudent.getId()+" not found");
        }
        return studentRepository.save(matchingStudent);
    }

    @Override
    public void deleteById(int studentId) {
    Student matchingStudent = findById(studentId);
    studentRepository.deleteById(studentId);
    }
}
