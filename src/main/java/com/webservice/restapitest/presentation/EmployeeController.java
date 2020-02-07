package com.webservice.restapitest.presentation;

import com.webservice.restapitest.business.BusinessService;
import com.webservice.restapitest.model.Employee;
import com.webservice.restapitest.model.EmployeewithTask;
import com.webservice.restapitest.model.Task;
import com.webservice.restapitest.repository.Queryrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController

public class EmployeeController {
    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/employees" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findAllEmployee(){
        return businessService.getEmployes();
    }


    @GetMapping(value = "/employee/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findEmployeeById(@PathVariable(value = "id") Long id){
        return businessService.getEmployeeById(id);
    }
    @PostMapping(value = "/employee" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        return businessService.saveEmployee( employee.getName() ,employee.getAge(), employee.getId_dep());
    }

    @PutMapping(value = "/employee/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateEmployeRepo(@PathVariable(value = "id") Long id , @RequestBody Employee employee){
        return  businessService.update_Employee(id,employee.getName(),employee.getAge(),employee.getId_dep());
    }

    @DeleteMapping(value = "/employee/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity deleteEmployeRepo(@PathVariable(value = "id") Long id ) throws Exception {
        return  businessService.delete_Employee(id) ;
    }

    @PostMapping(value = "/newEmployeenewTask" , produces = APPLICATION_JSON_UTF8_VALUE)
    public  ResponseEntity add_EmpwithTask(@RequestBody EmployeewithTask employeewithTask){
        return businessService.saveEmpwithTask(employeewithTask.getName_emp(),employeewithTask.getAge(),employeewithTask.getId_dep(),employeewithTask.getName_task());
    }

}
