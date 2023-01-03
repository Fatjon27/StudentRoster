package com.codingdojo.betaplan.studentroster.services;

import com.codingdojo.betaplan.studentroster.models.Dorm;
import com.codingdojo.betaplan.studentroster.repositories.DormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DormService {
    @Autowired
    private DormRepository dormRepository;
    public List<Dorm> findAll(){
       return dormRepository.findAll();
    }
    public Dorm create(Dorm dorm){
        return dormRepository.save(dorm);
    }
    public Dorm update(Dorm dorm){
        return dormRepository.save(dorm);
    }
    public Dorm findById(Long id){
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()){
            return optionalDorm.get();
        }
        else {
            return null;
        }
    }
}
