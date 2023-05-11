package com.student.resultmangement.controller;

import com.student.resultmangement.entity.Result;
import com.student.resultmangement.service.CourseService;
import com.student.resultmangement.service.ResultService;
import com.student.resultmangement.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Transactional
public class ResultController {

    private final ResultService resultService;
    private final StudentService studentService;
    private final CourseService courseService;

    public ResultController(ResultService resultService, StudentService studentService, CourseService courseService)
    {
        super();
        this.resultService=resultService;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping("/results")
    public String listResults(Model model) {
        model.addAttribute("results", resultService.getAllResults());
        return "result_list";
    }

    @GetMapping("/results/new")
    public String createResultForm(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        model.addAttribute("students", studentService.getAllStudents());
        // create course object to hold student form data
        Result result=new Result();
        model.addAttribute("result", result);
        return "create_result";
    }

    @PostMapping("/results/save")
    public String saveResult(@ModelAttribute("result") Result result) {
        resultService.saveResult(result);
        return "redirect:/results/new";
    }

}
