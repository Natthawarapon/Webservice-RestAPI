package com.webservice.restapitest.model;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class EmployeewithDepartment implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;

    private String name;
    private String department;

    public EmployeewithDepartment() {
        this.name = name;
        this.department = department;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
