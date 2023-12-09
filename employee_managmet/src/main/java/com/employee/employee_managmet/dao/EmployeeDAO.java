package com.employee.employee_managmet.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.employee_managmet.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

    //@Query(value = "SELECT e.id, name, GROUP_CONCAT(occupation) AS occupation, e.* FROM employee AS e INNER JOIN employee_occupation AS ec ON e.id = ec.employee_id INNER JOIN occupation AS oc ON oc.id = ec.occupation_id GROUP BY e.id", nativeQuery = true)
    //public Page<Object[]> getEmployeeList(Pageable pageable);
}
