package com.webservice.restapitest.presentation;

import com.webservice.restapitest.business.BusinessService;
import com.webservice.restapitest.model.Department;
import com.webservice.restapitest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class DepartmentController {
    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/departments" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findAllDepartment(){
        return businessService.getDepartment();
    }

    @PostMapping(value = "/department" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity add_Department(@RequestBody Department department){
        return businessService.saveDepartment(department.getDepartment());
    }

    @GetMapping(value = "/dep/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity DepByIdd(@PathVariable(value = "id" ) Long id ){
        return businessService.getDepartmentByID(id);
    }


}
