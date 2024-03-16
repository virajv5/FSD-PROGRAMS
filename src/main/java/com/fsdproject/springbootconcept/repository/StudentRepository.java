package com.fsdproject.springbootconcept.repository;

import com.fsdproject.springbootconcept.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
