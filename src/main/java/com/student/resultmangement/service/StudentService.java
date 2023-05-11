package com.student.resultmangement.service;

import com.student.resultmangement.entity.Student;
import com.student.resultmangement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
   // @Autowired
    private  final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).get();
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

}
