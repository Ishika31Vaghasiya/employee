package com.employee.employee_managmet.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.employee.employee_managmet.model.Employee;

@Repository
public interface EmployeeService {
    List<Object[]> getEmployeeByFilter(int pageSize, int pageNumber, int age, String occupation, String timing,
            String gender);
}