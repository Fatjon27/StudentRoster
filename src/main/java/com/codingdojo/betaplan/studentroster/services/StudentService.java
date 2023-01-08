package com.codingdojo.betaplan.studentroster.services;

import com.codingdojo.betaplan.studentroster.models.Class;
import com.codingdojo.betaplan.studentroster.models.Student;
import com.codingdojo.betaplan.studentroster.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Student create(Student student){
        return studentRepository.save(student);
    }
    public Student update(Student student){
        return studentRepository.save(student);
    }
    public Student findById(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        else {
            return null;
        }
    }
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
    public List<Student> findStudentsInAClass(Class newClass){
        return studentRepository.findAllByClasses(newClass);
    }
    public List<Student> findStudentsNotInAClass(Class newClass){
        return studentRepository.findByClassesNotContains(newClass);
    }

}
