package com.fsdproject.springbootconcept.service;

import com.fsdproject.springbootconcept.entity.Student;

import java.util.List;
public interface StudentService {

    public List<Student> findAll();

    public Student findById(int studentId);

    public Student save(Student student);

    public Student update(int studentId, Student student);

    public void deleteById(int studentId);
}
