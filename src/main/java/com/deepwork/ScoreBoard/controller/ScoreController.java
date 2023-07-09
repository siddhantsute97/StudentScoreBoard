package com.deepwork.ScoreBoard.controller;

import com.deepwork.ScoreBoard.model.Student;
import com.deepwork.ScoreBoard.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService service;


    //1.display all the record
    @GetMapping("/")
    public String getStudent(Model model){
        Object students=service.getAllStudent();
        model.addAttribute("records",students);
        return "student";
    }
    @GetMapping("addstudent")
    public String displayStudentForm(Model model){
        model.addAttribute("student", new Student());
        return "addstudent";
    }
    @PostMapping("/insertstudent")
    public String addStudentDetails(Student s){
        service.addStudent(s);
        return "redirect:/";
    }

    @GetMapping("/student/{studentId}/subjects")
    public String getSubjectMarksForStudent(@PathVariable int studentId, Model model) {
        List<Object[]> subjectMarks = service.getSubjectMarksForStudent(studentId);
        model.addAttribute("subjectMarks", subjectMarks);
        return "subjectmarksview";
    }

    @GetMapping("/student/{studentId}/addsubjectmarks")
    public String displayAddSubjectMarksForm(@PathVariable int studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "addsubjectmarks";
    }

    @PostMapping("/student/{studentId}/addsubjectmarks")
    public String addSubjectMarks(@PathVariable int studentId, @RequestParam("subject") String subjectName, @RequestParam("marks") int marks) {
        service.addSubjectMarksForStudent(studentId, subjectName, marks);

        return "redirect:/student/{studentId}/subjects";
    }
    @GetMapping("/report")
    public String getStudentsWithAverageMarksGreaterThan60(Model model) {
        List<Object[]> brave = service.getStudentsWithAverageMarksGreaterThan60();
        model.addAttribute("brave", brave);
        return "report";
    }
}
