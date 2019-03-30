package com.example.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlumniTest {

    @Qualifier("previousStudents")
    @Autowired
    private Students prevCohort;

    @Autowired
    private Instructors instructors;

    Double numberOfHoursPerInstructor;
    @Before
    public void setup(){
        int numberOfInstructors = instructors.size();
        int numberOfStudents = prevCohort.size();
        double numberOfHoursToTeachEachStudent = 1200;
        double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        this.numberOfHoursPerInstructor = numberOfHoursPerInstructor;
    }

    @Test
    public void executeBootCampTest(){
        prevCohort.forEach(student -> Assert.assertEquals(1200.0, student.getTotalStudyTime(), 0.0));
    }

    @Test
    public void executeBootCampTest2(){
        instructors.forEach(instructor -> Assert.assertEquals(numberOfHoursPerInstructor, instructor.numberOfTaughtHours));
    }


}
