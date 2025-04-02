package com.tutorial.bootdemo.service;

import com.tutorial.bootdemo.converter.StudentConverter;
import com.tutorial.bootdemo.dao.Student;
import com.tutorial.bootdemo.dao.StudentRepository;
import com.tutorial.bootdemo.dto.StudentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServeceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO findById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.toDTO(student);
    }

    @Override
    public Long addEntity(StudentDTO studentDTO) {
        String email = studentDTO.getEmail();
        List<Student> students = studentRepository.findByEmail(email);
        if (!students.isEmpty())
        {
            throw new IllegalStateException("email"+email+" already in use");

        }
        Student student = StudentConverter.toEntity(studentDTO);
        student = studentRepository.save(student);
        return student.getId();
    }

    @Override
    public void deleteEntity(long id){
        studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id"+id+" not found"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateEntity(long id, String name, String email){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id"+id+" not found"));
        if(StringUtils.hasLength(name)) {
            student.setName(name);
        }
        if(StringUtils.hasLength(email)) {
            student.setEmail(email);
        }
        student = studentRepository.save(student);
        return StudentConverter.toDTO(student);
    }
}
