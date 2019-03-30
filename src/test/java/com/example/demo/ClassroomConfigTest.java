package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassroomConfigTest {


    @Autowired
    @Qualifier("currentCohort")
    Classroom currentClassroom;

    @Autowired
    @Qualifier("previousCohort")
    Classroom prevClassroom;

    @Autowired
    @Qualifier("students")
    Students students;

    @Autowired
    @Qualifier("previousStudents")
    Students prevStudents;

    @Autowired
    @Qualifier("instructors")
    Instructors allInstructors;

    @Test
    public void currentClassroomTest() {
        Students expected = students;
        Students actual = currentClassroom.getStudents();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void currentClassroomTest2() {
        Instructors expected = allInstructors;
        Instructors actual = currentClassroom.getInstructors();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void previousClassroomTest() {
        Students expected = prevStudents;
        Students actual = prevClassroom.getStudents();

        Assert.assertEquals(expected, actual);
    }

}
