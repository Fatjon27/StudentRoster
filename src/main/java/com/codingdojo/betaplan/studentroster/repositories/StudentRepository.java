package com.codingdojo.betaplan.studentroster.repositories;

import com.codingdojo.betaplan.studentroster.models.Class;
import com.codingdojo.betaplan.studentroster.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
     List<Student> findAll();
     List<Student> findAllByClasses(Class newClass);
     List<Student> findByClassesNotContains(Class newClass);

}
