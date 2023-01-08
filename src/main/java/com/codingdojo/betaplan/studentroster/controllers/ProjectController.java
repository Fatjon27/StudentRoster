package com.codingdojo.betaplan.studentroster.controllers;

import com.codingdojo.betaplan.studentroster.models.Class;
import com.codingdojo.betaplan.studentroster.models.Dorm;
import com.codingdojo.betaplan.studentroster.models.Student;
import com.codingdojo.betaplan.studentroster.services.ClassService;
import com.codingdojo.betaplan.studentroster.services.DormService;
import com.codingdojo.betaplan.studentroster.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
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
    @Autowired
    private ClassService classService;

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

    @GetMapping("/classes/new")
    public String newClass(@ModelAttribute("newClass") Class newClass){
        return "createClass";
    }
    @PostMapping("/classes/new")
    public String createClass(@Valid @ModelAttribute("newClass") Class newClass,BindingResult result){
        if(result.hasErrors()){
            return "createClass";
        }
        else {
            classService.create(newClass) ;
            return "redirect:/";
        }
    }

    @GetMapping("/classes")
    public String classes(Model model){
        model.addAttribute("allClasses",classService.findAll());
        return "classes";
    }

    @GetMapping("/classes/{id}")
    public String classStudents(@PathVariable("id") Long id,Model model){
        Class currentClass = classService.findById(id);
        model.addAttribute("currentClass",currentClass);
        model.addAttribute("students",currentClass.getStudents());
        return "currentClass";
    }

    @GetMapping("students/{id}")
    public String studentClasses(@PathVariable("id")Long id,Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student",student);
        model.addAttribute("classes",classService.findClassesContainingStudent(student));
        model.addAttribute("leftClasses",classService.findClassesNotContainingStudent(student));
        return "studentClasses";
    }
    @PostMapping("/students/{id}")
    public String studentClass(@PathVariable("id") Long studentId, @RequestParam(value = "classId")Long classId){
        Student student =studentService.findById(studentId);
        Class currentClass = classService.findById(classId);
        student.getClasses().add(currentClass);
        studentService.update(student);
        return "redirect:/students/"+studentId;
    }

    @GetMapping("/drop/{id}/{classId}")
    public String drop(@PathVariable("id") Long id,@PathVariable("classId") Long classId,Model model){
        Class currentClass = classService.findById(classId);
        Student student = studentService.findById(id);
        student.getClasses().remove(currentClass);
        studentService.update(student);
        return "redirect:/students/"+id;
    }
}
