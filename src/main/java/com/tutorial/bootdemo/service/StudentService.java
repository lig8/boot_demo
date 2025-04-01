package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.dao.Student;

public interface StudentService {
    Student findById(Long id);

    Student addEntity(Student student);

    void deleteEntity(Long id);

    Student updateEntity(Long id, String name, String email, Long age);
}
