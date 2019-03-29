package com.example.demo;

public class Student extends Person implements Learner{
    private double totalStudyTime;

    public Student(Long id, String name) {
        super(id, name);
    }

    public void learn(Double numberOfHours) {
        this.totalStudyTime += numberOfHours;
    }

    public double getTotalStudyTime() {
        return totalStudyTime;
    }
}
