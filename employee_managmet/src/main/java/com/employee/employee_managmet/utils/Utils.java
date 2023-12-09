package com.employee.employee_managmet.utils;

import java.sql.Date;

import com.employee.employee_managmet.model.Employee;

public class Utils {

  public static Employee getEmployee(Object object[]) {

    Employee employee = new Employee();
    employee.setId((Long) object[0]);
    employee.setName((String) object[1]);
    employee.setDateOfBirth((Date) object[2]);
    employee.setAge((int) object[3]);
    employee.setPhone((String) object[4]);

    return employee;
  }
}
