package com.student.resultmangement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.grammars.hql.HqlParser;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column
    private String firstName;
    @Column
    private String familyName;
    @Column
    private Date DOB;
    @Column
    private String emailAddress;

    @OneToMany(targetEntity = Result.class,cascade = CascadeType.ALL)
    @JoinColumn(name= "firstName",referencedColumnName = "firstName")
    private List<Result> resultList;

}













