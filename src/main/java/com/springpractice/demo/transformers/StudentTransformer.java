package com.springpractice.demo.transformers;

import com.springpractice.demo.dtos.StudentDTO;
import com.springpractice.demo.entities.Student;

public class StudentTransformer implements Transformer<Student,StudentDTO> {
    @Override
    public Student toModel(StudentDTO object){
        return new Student(object.isBursier(),object.getDataNastere(),object.getNrMatricol(),object.getNume(),object.getPrenume());
    }

    @Override
    public StudentDTO toDTO(Student object){
        StudentDTO studentDTO=new StudentDTO(object.getDataNastere(),object.getNrMatricol(),object.getNume(),object.getPrenume());
        if(object.isBursier())
            studentDTO.addBursa();
        return studentDTO;
    }

}
