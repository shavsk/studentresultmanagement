package com.student.resultmangement.service;

import com.student.resultmangement.entity.Course;
import com.student.resultmangement.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {

    private  final CourseRepository courseRepository;
     public CourseService(CourseRepository courseRepository)
     {
         super();
         this.courseRepository=courseRepository;
     }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).get();
    }

    public void deleteCourseById(Integer id) {
        courseRepository.deleteById(id);
    }
}
