package com.example.demo.apicontroller;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudent(){
    return studentService.getAllStudent();
  }

  @GetMapping("/{studentId}")
  public Student getStudentInfo(@PathVariable int studentId) {
    return studentService.getStudent(studentId).get();
  }

  @PostMapping
  public Student addStudent(@RequestBody Student student){
    return studentService.addStudent(student);
  }

  @PutMapping("/{studentId}")
  public String updateStudent(@PathVariable int studentId,
                              @RequestBody StudentDto studentDto){
    return studentService.updateStudent(studentDto);
  }

  @DeleteMapping("/{studentId}")
  public String deleteStudent(@PathVariable int studentId) {
    return studentService.deleteStudent(studentId);
  }
}