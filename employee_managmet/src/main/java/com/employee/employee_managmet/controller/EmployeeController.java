package com.employee.employee_managmet.controller;

import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_managmet.model.Employee;
import com.employee.employee_managmet.serviceimpl.EmployeeServiceImpl;
import com.employee.employee_managmet.utils.Constants;
import com.employee.employee_managmet.utils.Utils;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeServiceImpl employeeServiceImpl;

  @GetMapping("list")
  public String getEmployeeList(@RequestParam(defaultValue = "10", required = false) int pageSize,
      @RequestParam(defaultValue = "0", required = false) int pageNumber,
      @RequestParam(defaultValue = "0", required = false) int age,
      @RequestParam(required = false) String occupation,
      @RequestParam(required = false) String timing,
      @RequestParam(required = false) String gender) {

    JSONArray empArray = new JSONArray();
    JSONObject resObj = new JSONObject();

    resObj.put("status", Constants.STATUS_200);
    resObj.put("message", "employee list successfully fetch");

    // Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
    List<Object[]> employeeList = employeeServiceImpl.getEmployeeByFilter(pageSize, pageNumber, age, timing, occupation,
        gender);

    for (Object[] emp_obj : employeeList) {
      Employee emp = Utils.getEmployee(emp_obj);
      empArray.put(emp.getJsonObject());
    }
    resObj.put("list", empArray);
    return resObj.toString();
  }
}

