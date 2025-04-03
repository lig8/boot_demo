package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.dao.Student;
import com.tutorial.bootdemo.dto.StudentDTO;

public interface StudentService {
    StudentDTO findById(Long id);

    StudentDTO addEntity(StudentDTO dto);

    void deleteEntity(Long id);

    Student updateEntity(Long id, String name, String email, Long age);
}
