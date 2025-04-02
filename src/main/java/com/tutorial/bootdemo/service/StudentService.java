package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.dto.StudentDTO;

public interface StudentService {
    StudentDTO findById(long id);

    Long addEntity(StudentDTO studentDTO);

    void deleteEntity(long id);

    StudentDTO updateEntity(long id, String name, String email);
}
