package com.webservice.restapitest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "users_database" ,name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 422078653576733017L;
    private Long id;
    private String name;
    private Long age;
    private  Long id_dep;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 45)
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "age", length = 2 , nullable = false)
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Column(name = "id_dep", length = 2 ,nullable = false)
    public Long getId_dep() { return id_dep; }

    public void setId_dep(Long id_dep) { this.id_dep = id_dep; }











}
