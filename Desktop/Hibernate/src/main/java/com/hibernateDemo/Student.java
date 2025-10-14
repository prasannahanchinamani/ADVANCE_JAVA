package com.hibernateDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private double percentage;

    // ✅ Default constructor (Hibernate requires this)
    public Student() {}

    // Optional parameterized constructor
    public Student(int studentId, String studentName, double percentage) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.percentage = percentage;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
