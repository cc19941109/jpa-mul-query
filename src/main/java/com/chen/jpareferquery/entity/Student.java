package com.chen.jpareferquery.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "school_origin",joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "ID")},
            inverseJoinColumns = {
            @JoinColumn(name = "school_id", referencedColumnName = "ID")
    })
    private List<School> schools;


    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }
}
