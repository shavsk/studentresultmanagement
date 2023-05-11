package com.student.resultmangement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column
    private String courseName;

    @OneToMany(targetEntity = Result.class,cascade = CascadeType.ALL)
    @JoinColumn(name= "courseName",referencedColumnName = "courseName")
    private List<Result> resultList;

}
