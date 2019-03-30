package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class InstructorsConfig {

    @Bean
    public Instructors tcUsaInstrutors(){
        List<Instructor> list = new ArrayList<>();
        list.add(new Instructor(9L, "Leon"));
        list.add(new Instructor(10L, "Chris"));
        list.add(new Instructor(11L, "Will"));
        list.add(new Instructor(12L, "Nu"));


        return new Instructors(list);
    }

    @Bean
    public Instructors tcaUkInstructors(){
        List<Instructor> list = new ArrayList<>();
        list.add(new Instructor(13L, "Dolio"));
        list.add(new Instructor(14L, "Tariq"));
        list.add(new Instructor(15L, "Froilan"));
        list.add(new Instructor(16L, "Tyrell"));

        return new Instructors(list);
    }

    @Primary
    @Bean (name = "instructors")
    public Instructors instructors(){
        List<Instructor> list = Stream.concat(tcaUkInstructors().findAll().stream(),
                tcUsaInstrutors().findAll().stream())
                .collect(Collectors.toCollection(ArrayList::new));

        return new Instructors(list);
    }
}
