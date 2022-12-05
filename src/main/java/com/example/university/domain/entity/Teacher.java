package com.example.university.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_student",
            joinColumns = { @JoinColumn(name = "student_id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "teacher_id", referencedColumnName = "id") })
    private Set<Student> students;
}
