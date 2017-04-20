package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.AbstractMap;

/**
 * Created by trainee on 18/04/2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "employees/{empId}/score", method = RequestMethod.GET)
    AbstractMap.SimpleEntry<String, Double> getEmployeeByFilter(@PathVariable long empId) {
        double result = Math.random() * 100;
        return new AbstractMap.SimpleEntry<String, Double>("score", result);
    }

    //Uncomment the following if you don't use global CORS (see SpringJpaApplication.java)
    //@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "employees/{empId}/experiment", method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployees(@PathVariable long empId) {
        return new ResponseEntity<>(repository.findOne(empId), HttpStatus.OK);
    }
}
