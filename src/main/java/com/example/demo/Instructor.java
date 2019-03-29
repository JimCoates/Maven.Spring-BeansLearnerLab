package com.example.demo;

import org.apache.commons.collections4.IterableUtils;

import java.util.stream.StreamSupport;

public class Instructor extends Person implements Teacher {


    public Instructor(Long id, String name) {
        super(id, name);
    }

    public void teach(Learner learner, Double numberOfHours) {
        learner.learn(numberOfHours);
    }

    public void lecture(Iterable<? extends Learner> learners, Double numberOfHours) {
        Double numberOfHoursPerLearner = numberOfHours/ IterableUtils.size(learners);
        learners.forEach(l -> teach(l, numberOfHoursPerLearner));
    }
}
