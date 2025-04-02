package com.tutorial.bootdemo.controller;

import com.tutorial.bootdemo.Response;
import com.tutorial.bootdemo.dto.StudentDTO;
import com.tutorial.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDTO> findById(@PathVariable long id) {
        return Response.newSucess(studentService.findById(id));
    }

    @PostMapping("/student")
    public Response<Long> addEntity(@RequestBody StudentDTO studentDTO) {
        return Response.newSucess(studentService.addEntity(studentDTO));
    }

    @DeleteMapping("/student/{id}")
    public Response<Long> deleteEntity(@PathVariable long id) {
        studentService.deleteEntity(id);
        return Response.newSucess(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateEntity(@PathVariable long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        return Response.newSucess(studentService.updateEntity(id,name,email));
    }
}
