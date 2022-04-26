package com.example.springsecurityfivecass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "groups")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_date_start")
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfStart;
    @Column(name = "group_date_finish")
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfFinish;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups_course",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    @JsonIgnore
    private List<Course> courses;


    @OneToMany(mappedBy = "group",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Student> studentList;

    @Override
    public String toString() {
        return getGroupName();
    }
}