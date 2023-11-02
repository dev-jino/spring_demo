package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//  List<Student> findAll();
//  Student findById(int studentId);
//  Student removeById(int studentId);
//  Student add(Student student);
//  Student update(int studentId, Student student);
}