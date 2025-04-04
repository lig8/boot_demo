package com.tutorial.bootdemo.controller;

import com.tutorial.bootdemo.dto.StudentDTO;
import com.tutorial.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    public StudentDTO findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/student")
    public StudentDTO addEntity(@RequestBody StudentDTO dto) {
        return studentService.addEntity(dto);
    }

    @DeleteMapping("/student/{id}")
    public void deleteEntity(@PathVariable Long id) {
        studentService.deleteEntity(id);
    }

    @PutMapping("/student/{id}")
    public StudentDTO updateEntity(@PathVariable Long id, @RequestParam(required = false) String name,  @RequestParam(required = false) String email) {
        return studentService.updateEntity(id,name,email);
    }
}
