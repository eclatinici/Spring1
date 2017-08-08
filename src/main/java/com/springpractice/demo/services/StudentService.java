package com.springpractice.demo.services;

import com.springpractice.demo.entities.Student;
import com.springpractice.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class StudentService implements CrudService<Student> {
    @Autowired
    private StudentRepository repository;

    @Override
    public void save(Student entity){
        this.repository.save(entity);
    }

    @Override
    public List<Student> getAll(){
        return this.repository.findAll();
    }


    @Override
    public Student getById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public void delete(Long id){
        this.repository.delete(id);
    }
}
