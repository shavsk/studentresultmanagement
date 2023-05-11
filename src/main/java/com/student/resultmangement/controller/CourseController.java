package com.student.resultmangement.controller;

import com.student.resultmangement.entity.Course;
import com.student.resultmangement.entity.Student;
import com.student.resultmangement.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Transactional
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService)
    {
        super();
        this.courseService=courseService;
    }

    // handler method to handle list courses and return mode and view
    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "course_list";
    }

    @GetMapping("/courses/new")
    public String createStudentForm(Model model) {
        // create course object to hold student form data
        Course course=new Course();
        model.addAttribute("course", course);
        return "create_course";
    }
    @PostMapping("/courses/save")
    public String saveCourse(@ModelAttribute("course") Course course, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "create_course";
        }
        courseService.saveCourse(course);
        return "redirect:/courses/new";
    }

    @GetMapping("/courses/{cid}")
    public String deleteCourse(@PathVariable Integer cid) {
        courseService.deleteCourseById(cid);
        return "redirect:/courses";
    }

}
