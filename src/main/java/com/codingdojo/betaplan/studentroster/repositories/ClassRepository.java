package com.codingdojo.betaplan.studentroster.repositories;

import com.codingdojo.betaplan.studentroster.models.Class;
import com.codingdojo.betaplan.studentroster.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends CrudRepository<Class,Long> {
    List<Class> findAll();
    List<Class> findAllByStudents(Student student);
    List<Class> findByStudentsNotContains(Student student);
}
