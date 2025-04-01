package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.dao.Student;
import com.tutorial.bootdemo.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Student addEntity(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteEntity(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateEntity(Long id, String name, String email, Long age) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        if(name!=null){
            student.setName(name);
        }
        if(email != null){
            student.setEmail(email);
        }
        if(age!=null){
            student.setAge(age);
        }
        return (studentRepository.save(student));
    }
}
