package com.codingdojo.betaplan.studentroster.services;

import com.codingdojo.betaplan.studentroster.models.Class;
import com.codingdojo.betaplan.studentroster.models.Student;
import com.codingdojo.betaplan.studentroster.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    public Class create(Class newClass){
        return classRepository.save(newClass);
    }
    public Class update(Class newClass){
        return classRepository.save(newClass);
    }
    public Class findById(Long id){
        Optional<Class> optionalClass = classRepository.findById(id);
        if(optionalClass.isPresent()){
            return optionalClass.get();
        }
        else {
            return null;
        }
    }
    public void deleteById(Long id){
        classRepository.deleteById(id);
    }
    public List<Class> findClassesContainingStudent(Student student){
        return classRepository.findAllByStudents(student);
    }
    public List<Class> findClassesNotContainingStudent(Student student){
        return classRepository.findByStudentsNotContains(student);
    }
    public List<Class> findAll(){
        return classRepository.findAll();
    }
}
