package com.example.springbootproject.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String name;
    private String password;
    private int stuNum;
    private int rangeNum;
    @Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "timestamp default current_timestamp " + "on update current_timestamp", insertable = false, updatable = false)
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "teacher")
    private List<Elective> electives;

    @OneToMany(mappedBy = "teacher")
    private List<TeacherCourse> teacherCourses;

}
