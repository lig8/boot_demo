package com.tutorial.bootdemo.controller;

import com.tutorial.bootdemo.dao.Student;
import com.tutorial.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/student")
    public Student addEntity(@RequestBody Student student) {
        return studentService.addEntity(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteEntity(@PathVariable Long id) {
        studentService.deleteEntity(id);
    }

    @PutMapping("/student/{id}")
    public Student updateEntity(@PathVariable Long id, @RequestParam(required = false) String name, @RequestParam(required = false) Long age, @RequestParam(required = false) String email) {
        return studentService.updateEntity(id,name,email,age);
    }
}
