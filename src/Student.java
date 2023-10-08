package com.example.first.Student;
import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;


@Entity
@Table
public class Student {    
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    
    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    
    public Student() {
    }
    
    public Student(int id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public LocalDate getDob() {
        return dob;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(int age) {
        this.age = age;
    }

}