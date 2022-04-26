package com.example.springsecurityfivecass.entity;

import com.example.springsecurityfivecass.enumpackage.StudyFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "student_name")
    private String firstName;
    @Column(name = "student_email")
    private String email;
    @Column(name = "student_last_name")
    private String LastName;
    @Column(name = "student_study_format")
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;



    @ManyToOne()
    @JoinColumn(name="group_id")
    @JsonIgnore
    private Group group;

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
