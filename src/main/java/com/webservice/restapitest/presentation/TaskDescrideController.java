package com.webservice.restapitest.presentation;

import com.webservice.restapitest.business.BusinessService;
import com.webservice.restapitest.model.Department;
import com.webservice.restapitest.model.TaskDescribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
@RestController
public class TaskDescrideController {

    @Autowired
    private BusinessService businessService;

    @PostMapping(value = "/work" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add_TaskDes(@RequestBody TaskDescribe taskDescribe){
        return businessService.saveDescribe_task(taskDescribe.getEmpId(),taskDescribe.getDesId(),taskDescribe.getDateDes());
    }

    @GetMapping(value = "/EmployeewithTask/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity EmployeeByIdTask(@PathVariable(value = "id" ) Long id ){
        return businessService.getEmpwithTask(id);
    }
}
