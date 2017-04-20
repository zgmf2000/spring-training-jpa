package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trainee on 18/04/2017.
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @RequestMapping(value = "employees/{empId}/score", method = RequestMethod.GET)
    AbstractMap.SimpleEntry<String, Double> getEmployeeByFilter(@PathVariable long empId) {
        double result = Math.random() * 100;
        return new AbstractMap.SimpleEntry<String, Double>("score", result);
    }

    @RequestMapping(value = "employees/{empId}/experiment", method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployees(@PathVariable long empId) {
        return new ResponseEntity<>(repository.findOne(empId), HttpStatus.OK);
    }
}
