package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean(name = "students")
    public Students currentStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1L, "Jim"));
        list.add(new Student(2L, "Marcy"));
        list.add(new Student(3L, "McTina"));
        list.add(new Student(4L, "Chalie"));

        return new Students(list);
    }

    @Bean
    public Students previousStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(5L, "Sean"));
        list.add(new Student(6L, "Dave"));
        list.add(new Student(7L, "Eric"));
        list.add(new Student(8L, "SeanMC"));

        return new Students(list);
    }
}
