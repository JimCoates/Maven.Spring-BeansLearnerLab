package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentConfigTest {

    @Autowired
    @Qualifier("students")
    Students students;

    @Autowired
    @Qualifier("previousStudents")
    Students prevStudents;

    @Test
    public void studentsBeanTest(){
        //Given
        Integer expected = 4;
        //When
        Integer actual = students.size();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void studentsBeanTest2(){
        //Given
        String expected = "Jim";
        //When
        String acutal = students.findById(1L).getName();
        //Then
        Assert.assertEquals(expected,acutal);
    }

    @Test
    public void previousStudentBeanTest(){
        //Given
        Integer expected = 5;
        //When
        Integer actual = prevStudents.size();
        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void previousStudentBeanTest2(){
        //Given
        String expected = "SeanMC";
        //When
        String actual = prevStudents.findById(8L).getName();
        //Then
        Assert.assertEquals(expected,actual);
    }
}
