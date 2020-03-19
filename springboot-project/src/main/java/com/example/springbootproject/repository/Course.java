package com.example.springbootproject.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String name;
    @Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "timestamp default current_timestamp " + "on update current_timestamp", insertable = false, updatable = false)
    private LocalDateTime updateTime;

    @OneToMany(mappedBy = "course")
    private List<TeacherCourse> teacherCourses;

}
