package com.sjprogramming.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.restapi.repository.StudentRepository;
import com.sjprogramming.restapi.entity.Student;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepository repo;

   
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        // Assigning the result of repo.findAll() to a local variable
        List<Student> students = repo.findAll();
        return students; // Returning the local variable
    }

   
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
     
        Optional<Student> optionalStudent = repo.findById(id);

        // Handle cases where the student is not found
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get(); // Assign to a local variable
            return student; // Return the local variable
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

   
    @PostMapping("/student/add")
    public void createStudent(@RequestBody Student student) {
        repo.save(student); // Save the student object to the database
    }
}
