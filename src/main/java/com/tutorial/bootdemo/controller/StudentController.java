package com.tutorial.bootdemo.controller;

import com.tutorial.bootdemo.Response;
import com.tutorial.bootdemo.dto.StudentDTO;
import com.tutorial.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDTO> findById(@PathVariable Long id) {
        return Response.success(studentService.findById(id));
    }

    @PostMapping("/student")
    public Response<StudentDTO> addEntity(@RequestBody StudentDTO dto) {
        return Response.success(studentService.addEntity(dto));
    }

    @DeleteMapping("/student/{id}")
    public void deleteEntity(@PathVariable Long id) {
        studentService.deleteEntity(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateEntity(@PathVariable Long id, @RequestParam(required = false) String name,  @RequestParam(required = false) String email) {
        return Response.success(studentService.updateEntity(id,name,email));
    }
}
