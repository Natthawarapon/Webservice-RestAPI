package com.webservice.restapitest.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "users_database" , name = "describe_task")
public class TaskDescribe  implements Serializable {
    private static final long serialVersionUID = 422078653576733017L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long desId;

    @Column(name = "id_emp",length = 2 )
    private Long empId;

    @Column(name = "id_task" ,length = 2 )
    private Long taskId;

    @Column(name = "date_des" ,length = 45)
    private String dateDes;

    public TaskDescribe(Long desId, Long empId, Long taskId, String dateDes) {
        this.desId = desId;
        this.empId = empId;
        this.taskId = taskId;
        this.dateDes = dateDes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getDesId() {
        return desId;
    }

    public void setDesId(Long desId) {
        this.desId = desId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDateDes() {
        return dateDes;
    }

    public void setDateDes(String dateDes) {
        this.dateDes = dateDes;
    }
}
