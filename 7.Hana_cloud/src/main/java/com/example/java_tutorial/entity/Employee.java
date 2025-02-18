package com.example.java_tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Entity
@Table(name = "EMPLOYEES")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String project;
    private Double salary;

}

