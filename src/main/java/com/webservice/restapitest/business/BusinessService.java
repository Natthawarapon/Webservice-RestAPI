package com.webservice.restapitest.business;

import com.webservice.restapitest.model.Department;
import com.webservice.restapitest.model.Employee;
import com.webservice.restapitest.repository.Persisrepo;
import com.webservice.restapitest.repository.Queryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class BusinessService {

    private final Queryrepo queryrepo;
    private final Persisrepo persisrepo;

    @Autowired
    public BusinessService(Queryrepo queryrepo, Persisrepo persisrepo) {
        this.queryrepo = queryrepo;
        this.persisrepo = persisrepo;
    }

    //SUPPORTS มีก้ได้ ไม่มีก็ได้  Query
    //REQUIRED เอาอันใหม่ตลอด Insert
    // REQUIRED_NEW ไม่มีถ้าไม่มีต้องสร้างใหม่เสมอ
    //Transactional : ต้องมีเมื่อ Insert - update - delete

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getEmployes() {

        return ResponseEntity.ok(queryrepo.getEmployees());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getEmployeeById(Long id) {
        return ResponseEntity.ok(queryrepo.getEmployeeById(id));
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity saveEmployee(@RequestBody String name, Long age, Long id_dep) {
        return ResponseEntity.ok(persisrepo.addEmployee(name, age, id_dep));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity update_Employee(Long id, String name, Long age, Long id_dep) {
        return ResponseEntity.ok(persisrepo.updateEmployee(id, name, age, id_dep));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public ResponseEntity delete_Employee(Long id) throws Exception {
        int delete = persisrepo.deleteEmployee(id);
        String status = null;
        HashMap<String,String> map = new HashMap<>();

        if (delete == 1) {
            status = "Delete Success";
            System.out.println(status);
            map.put("status",status);
            return ResponseEntity.ok(map);
        } else {
            status = "Delete Fail";
            System.out.println(status);
            map.put("status",status);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getDepartment() {
        return ResponseEntity.ok(queryrepo.getDepartments());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity saveDepartment(String name) {
        return ResponseEntity.ok(persisrepo.addDepartment(name));
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getDepartmentByID(Long id_dep) {
        return ResponseEntity.ok(queryrepo.getDepartmentById(id_dep));

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getEmployeewithDepartment(Long id_dep) {
        return ResponseEntity.ok(queryrepo.getEmployeewithDepartmentById(id_dep));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity saveDescribe_task(Long id_emp, Long id_task, String date_des) {
        return ResponseEntity.ok(persisrepo.addDescride_Task(id_emp, id_task, date_des));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public ResponseEntity getEmpwithTask(Long id) {
        return ResponseEntity.ok(queryrepo.getEmployeeByIdwithTask(id));
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity saveEmpwithTask(String name_emp, Long age, Long id_dep, String name_task) {
        int resultAddEmp = persisrepo.addEmployee(name_emp, age, id_dep);
        int resultAddTask = persisrepo.addTask(name_task);
        String status = null;
        if (resultAddEmp == 1 && resultAddTask == 1) {
            status = "addEmployee and addTask success";
        }
        return ResponseEntity.ok(status);
    }
}
