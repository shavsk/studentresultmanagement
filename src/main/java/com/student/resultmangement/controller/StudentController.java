package com.student.resultmangement.controller;


import com.student.resultmangement.entity.Student;
import com.student.resultmangement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    
    @GetMapping("/")
    public String home()
    {
        return "home";
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student_list";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";

    }
    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "create_student";
        }

        studentService.saveStudent(student);
        return "redirect:/students/new";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}


