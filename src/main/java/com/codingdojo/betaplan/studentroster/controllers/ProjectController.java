package com.codingdojo.betaplan.studentroster.controllers;

import com.codingdojo.betaplan.studentroster.models.Dorm;
import com.codingdojo.betaplan.studentroster.models.Student;
import com.codingdojo.betaplan.studentroster.services.DormService;
import com.codingdojo.betaplan.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private DormService dormService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String main(){
        return "redirect:/dorms";
    }
    @GetMapping("/dorms")
    public String index(Model model){
        List<Dorm> allDorms = dormService.findAll();
        model.addAttribute("allDorms",allDorms);
        return "index";
    }
    //Create a new dorm
    @GetMapping("/dorms/new")
    public String createDorm(@ModelAttribute("dorm")Dorm dorm){
        return "createDorm";
    }
    @PostMapping("/dorms/new")
    public String createD(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if(result.hasErrors()){
            return "createDorm";
        }
        else {
            dormService.create(dorm);
            return "redirect:/dorms" ;
        }
    }

    //create new students in a selected Dorm
    @GetMapping("/students/new")
    public String createStudent(Model model,@ModelAttribute("student")Student student){
        List<Dorm> allDorms = dormService.findAll();
        model.addAttribute("allDorms",allDorms);
        return "createStudent";
    }
    @PostMapping("/students/new")
    public String createS(Model model,@Valid @ModelAttribute("student") Student student,BindingResult result){
        if(result.hasErrors()){
            List<Dorm> allDorms = dormService.findAll();
            model.addAttribute("allDorms",allDorms);
            return "createStudent";
        }
        else {
            studentService.create(student);
            return "redirect:/dorms";
        }
    }

    //view students of the given dorm
    @GetMapping("/dorms/{dorm_id}")
    public String see(@PathVariable("dorm_id") Long id,Model model){
        Dorm dorm = dormService.findById(id);
        model.addAttribute("dorm",dorm);
        return "students";
    }

    //delete a student in a dorm
    @DeleteMapping("/delete/{dorm_id}/{student_id}")
    public String delete(@PathVariable("student_id")Long id){
        studentService.deleteById(id);
        return "redirect:/dorms" ;
    }
}
