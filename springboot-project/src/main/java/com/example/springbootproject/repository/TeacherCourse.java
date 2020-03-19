package com.example.springbootproject.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class TeacherCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String detail;
    @Column(columnDefinition = "timestamp default current_timestamp", insertable = false, updatable = false)
    private LocalDateTime insertTime;
    @Column(columnDefinition = "timestamp default current_timestamp " + "on update current_timestamp", insertable = false, updatable = false)
    private LocalDateTime updateTime;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Course course;


}
