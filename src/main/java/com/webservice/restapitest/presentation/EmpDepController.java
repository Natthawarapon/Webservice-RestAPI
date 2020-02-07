package com.webservice.restapitest.presentation;

import com.webservice.restapitest.business.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class EmpDepController {

    @Autowired
    private BusinessService businessService;

    @GetMapping(value = "/EmployeewithDepartment/{id}" , produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findEmployeeByIdd(@PathVariable(value = "id" ) Long id_dep ){
        return businessService.getEmployeewithDepartment(id_dep);
    }

}
