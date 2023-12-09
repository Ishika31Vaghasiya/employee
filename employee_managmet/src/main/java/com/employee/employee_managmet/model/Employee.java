package com.employee.employee_managmet.model;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "employee")
public class Employee {

  @Id
  @Column(name = "id")
  private Long id;

  private Date dateOfBirth;
  private String name;
  private String phone;
  private int age;

  @OneToMany(targetEntity = EmployeeOccupation.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private List<EmployeeOccupation> employeeOccupations;

  public List<EmployeeOccupation> getEmployeeOccupations() {
    return employeeOccupations;
  }

  public void setEmployeeOccupations(List<EmployeeOccupation> employeeOccupations) {
    this.employeeOccupations = employeeOccupations;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public JSONObject getJsonObject() {
    JSONObject obj = new JSONObject();

    obj.put("id", id);
    obj.put("name", name);
    obj.put("date_of_birth", dateOfBirth);
    obj.put("age", age);
    obj.put("phone", phone);

    return obj;
  }
}
