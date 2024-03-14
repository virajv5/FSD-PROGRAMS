package com.fsdproject.springjpa.repository;

import com.fsdproject.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
