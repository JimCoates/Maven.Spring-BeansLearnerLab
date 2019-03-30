package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Alumni {

    @Qualifier("previousStudents")
    @Autowired
    private Students prevCohort;

    @Autowired
    private Instructors instructors;

    @PostConstruct
    public void executeBootCamp() {
        Double numberOfHoursToTeach = 750.0;
        for (Instructor instructor:instructors) {
            instructor.lecture(prevCohort,numberOfHoursToTeach);
        }
    }

    public Students getPrevCohort() {
        return prevCohort;
    }

    public Instructors getInstructors() {
        return instructors;
    }
}



