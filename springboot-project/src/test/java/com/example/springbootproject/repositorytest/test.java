package com.example.springbootproject.repositorytest;

import com.example.springbootproject.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Slf4j
@SpringBootTest
@Transactional
@Rollback(value = false)
public class test {
    @Autowired
    private EntityManager manager;

    @Test
    public void test_init(){
        //初始化老师1
        Teacher t1 = new Teacher();
        t1.setName("BO");
        t1.setPassword("root1");
        t1.setStuNum(3);
        t1.setRangeNum(20);
        manager.persist(t1);

        //初始化老师2
        Teacher t2 = new Teacher();
        t2.setName("Lily");
        t2.setPassword("root2");
        t2.setStuNum(4);
        t2.setRangeNum(20);
        manager.persist(t2);

        //初始化学生1
        Student s1 = new Student();
        s1.setName("Pang");
        manager.persist(s1);

        //初始化学生2
        Student s2 = new Student();
        s2.setName("Shen");
        manager.persist(s2);

        //初始化学生3
        Student s3 = new Student();
        s3.setName("Long");
        manager.persist(s3);

        //初始化课程1
        Course c1 = new Course();
        c1.setName("Web框架");
        manager.persist(c1);

        //初始化课程2
        Course c2 = new Course();
        c2.setName("Java程序设计");
        manager.persist(c2);

    }

    @Test
    public void test_electiveRel(){
        //ID为1的学生选择了ID为1的教师作为导师
        Teacher t = manager.find(Teacher.class,1);
        Student s = manager.find(Student.class,1);
        Elective elective = new Elective();
        elective.setTeacher(t);
        elective.setStudent(s);
        elective.setDetail("detail");
        manager.persist(elective);
    }

    @Test
    public void test_teacherCourseRel(){
        //ID为1的老师拥有ID为1的课程
        Teacher t = manager.find(Teacher.class,1);
        Course c = manager.find(Course.class,1);
        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setTeacher(t);
        teacherCourse.setCourse(c);
        teacherCourse.setDetail("detail");
        manager.persist(teacherCourse);
    }
}
