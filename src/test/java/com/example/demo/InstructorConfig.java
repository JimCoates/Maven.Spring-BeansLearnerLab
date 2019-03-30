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
public class InstructorConfig {

    @Autowired
    @Qualifier("tcUsaInstrutors")
    Instructors usainstructors;

    @Autowired
    @Qualifier("tcaUkInstructors")
    Instructors ukinstructors;

    @Autowired
    @Qualifier("instructors")
    Instructors allInstructors;

    @Test
    public void tcUsaInstructorsTest(){
        Integer expected = 4;
        Integer actual = usainstructors.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void tcUKInstructorsTest(){
        Integer expected = 4;
        Integer actual = ukinstructors.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void tcInstructorsTest(){
        Integer expected = 8;
        Integer actual = allInstructors.size();
        Assert.assertEquals(expected, actual);
    }
}

