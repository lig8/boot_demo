package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.dao.Student;

public interface StudentService {
    Student findById(Long id);
}
