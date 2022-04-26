package com.example.springsecurityfivecass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_duration")
    private int duration;


    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Transient
    @OneToOne(mappedBy = "course",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Teacher teacher;

    @Override
    public String toString() {
        return getCourseName();
    }
}