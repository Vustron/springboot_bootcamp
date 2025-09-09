package com.vustron.springauth.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vustron.springauth.models.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {

  private List<Student> students = new ArrayList<>(List.of(
      new Student(1, "John Doe", 60),
      new Student(2, "Juan Dela Cruz", 85)));

  @GetMapping("/students")
  public List<Student> getStudensts() {
    return students;
  }

  @PostMapping("/students")
  public Student addStudent(@RequestBody Student student) {
    students.add(student);
    return student;
  }

}
