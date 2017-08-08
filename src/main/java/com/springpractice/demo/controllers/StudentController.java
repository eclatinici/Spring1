package com.springpractice.demo.controllers;

import com.springpractice.demo.dtos.StudentDTO;
import com.springpractice.demo.entities.Student;
import com.springpractice.demo.services.StudentService;
import com.springpractice.demo.transformers.StudentTransformer;
import com.springpractice.demo.transformers.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/Student")

public class StudentController {
    @Autowired
    private StudentService service;
    private Transformer<Student,StudentDTO> transformer=new StudentTransformer();

    @RequestMapping(value="/create/{bursier}", method = RequestMethod.POST)
    public ResponseEntity<List<Student>> createStudent(@PathVariable("bursier") boolean bursier,@RequestBody StudentDTO studentDTO)
    {
        if(bursier)
            studentDTO.addBursa();
        this.service.save(transformer.toModel(studentDTO));
        return new ResponseEntity<List<Student>>(this.service.getAll(),HttpStatus.CREATED);
    }

    @RequestMapping(value="/read",method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students=this.service.getAll();
        if(students.isEmpty())
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        for(Student student:students)
            System.out.println(student);
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }

    @RequestMapping(value="/update/{updateId}",method = RequestMethod.PUT)
    public ResponseEntity<List<Student>>updateId(@PathVariable("updateId") Long updateId,@RequestBody StudentDTO update){
        Student student=this.service.getById(updateId);
        if(student==null)
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);

        Student studentUpdated=transformer.toModel(update);

        student.setBursier(studentUpdated.isBursier());
        student.setDataNastere(studentUpdated.getDataNastere());
        student.setNrMatricol(studentUpdated.getNrMatricol());
        student.setNume(studentUpdated.getNume());
        student.setPrenume(studentUpdated.getPrenume());

        this.service.save(student);

        return new ResponseEntity<List<Student>>(this.service.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{deleteId}",method = RequestMethod.DELETE)
    public ResponseEntity<List<Student>>deleteId(@PathVariable("deleteId") Long deleteId){
        if(this.service.getById(deleteId)==null)
            return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
        this.service.delete(deleteId);
        return new ResponseEntity<List<Student>>(this.service.getAll(),HttpStatus.OK);
    }

}
