package com.webservice.restapitest.model;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(schema = "users_database" ,name = "department")
public class Department   implements Serializable {

    private static final long serialVersionUID = 422078653576733017L;
    private Long id;
    private String department;

    public Department(Long id, String department) {
        this.id = id;
        this.department = department;
    }

    public Department() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_dep", unique = true, nullable = false, precision = 22, scale = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name_dep", length = 45)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
