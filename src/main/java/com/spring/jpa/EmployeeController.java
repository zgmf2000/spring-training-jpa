package com.spring.jpa;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;

/**
 * Created by trainee on 18/04/2017.
 */
@RestController
public class EmployeeController {

    @RequestMapping(value = "employees/{empId}/score", method = RequestMethod.GET)
    AbstractMap.SimpleEntry<String, Double> getEmployeeByFilter(@PathVariable long empId) {
        double result = Math.random() * 100;
        return new AbstractMap.SimpleEntry<String, Double>("score", result);
    }
}
