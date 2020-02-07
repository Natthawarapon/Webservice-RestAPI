package com.webservice.restapitest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "users_database" ,name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = 422078653576733017L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idTask;

    @Column(name = "name_task", length = 45)
    private String nameTask;

    public Task(Long idTask, String nameTask) {
        this.idTask = idTask;
        this.nameTask = nameTask;
    }

    public Task() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }
}
