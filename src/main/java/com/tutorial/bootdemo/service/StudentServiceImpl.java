package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.converter.StudentConverter;
import com.tutorial.bootdemo.dao.Student;
import com.tutorial.bootdemo.dao.StudentRepository;
import com.tutorial.bootdemo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDTO findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        StudentDTO dto = StudentConverter.toDTO(student);
        return dto;
    }

    @Override
    public StudentDTO addEntity(StudentDTO dto){
        Student student = new Student();
        student.setId(null);
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge((long)0);
        return StudentConverter.toDTO(studentRepository.save(student));
    }

    @Override
    public void deleteEntity(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateEntity(Long id, String name, String email, Long age) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
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
