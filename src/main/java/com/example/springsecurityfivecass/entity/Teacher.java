package com.example.springsecurityfivecass.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "teacher_name")
    private String firstName;
    @Column(name = "teacher_email")
    private String email;
    @Column(name = "teacher_last_name")
    private String lastName;


    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public String toString() {
        return "Teacher{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}