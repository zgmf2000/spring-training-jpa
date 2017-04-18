package com.spring.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long>
{
    public List<Employee> findByLastName(@Param("last_name") String name);

    public List<Employee> findByLastNameContainingIgnoreCase(@Param("last_name") String name);

    public List<Employee> findByGender(@Param("gender") String gender);
}