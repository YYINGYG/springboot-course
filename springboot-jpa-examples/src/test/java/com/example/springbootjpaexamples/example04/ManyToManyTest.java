package com.example.springbootjpaexamples.example04;

import com.example.springbootjpaexamples.example04.manytomany.Course04;
import com.example.springbootjpaexamples.example04.manytomany.Elective;
import com.example.springbootjpaexamples.example04.manytomany.Student04;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class ManyToManyTest {
    @Autowired
    private EntityManager manager;

    @Test
    public void test_init(){
        //初始化学生1
        Student04 s1 = new Student04();
        s1.setName("BO");
        manager.persist(s1);
        //初始化学生2
        Student04 s2 = new Student04();
        s2.setName("MING");
        manager.persist(s2);
        //初始化课程1
        Course04 c = new Course04();
        c.setName("WEB FRAME");
        manager.persist(c);
    }

    @Test
    public void test_rel(){
        //ID为1的学生，选择了ID为1的课程
        Student04 s = manager.find(Student04.class,1);
        Course04 c= manager.find(Course04.class,1);
        Elective elective = new Elective();
        elective.setDetail("aaa");
        elective.setStudent(s);
        elective.setCourse(c);
        manager.persist(elective);
    }
}
