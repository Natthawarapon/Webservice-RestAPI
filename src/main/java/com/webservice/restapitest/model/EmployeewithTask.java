package com.webservice.restapitest.model;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class EmployeewithTask implements Serializable {


    private static final long serialVersionUID = 422078653576733017L;

    private String name_emp;
    private String department;
    private String name_task;
    private String date_des;
    private Long age;
    private Long id_dep;



    public EmployeewithTask(String name_emp, String department, String name_task, String date_des ,Long age, Long id_dep) {
        this.name_emp = name_emp;
        this.department = department;
        this.name_task = name_task;
        this.date_des = date_des;
        this.age = age;
        this.id_dep = id_dep;
    }

    public EmployeewithTask() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName_emp() {
        return name_emp;
    }

    public void setName_emp(String name_emp) {
        this.name_emp = name_emp;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public String getDate_des() {
        return date_des;
    }

    public void setDate_des(String date_des) {
        this.date_des = date_des;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getId_dep() {
        return id_dep;
    }

    public void setId_dep(Long id_dep) {
        this.id_dep = id_dep;
    }
}
