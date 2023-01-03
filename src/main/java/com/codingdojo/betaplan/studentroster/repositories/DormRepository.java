package com.codingdojo.betaplan.studentroster.repositories;

import com.codingdojo.betaplan.studentroster.models.Dorm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormRepository extends CrudRepository<Dorm,Long> {
    public List<Dorm> findAll();
}
