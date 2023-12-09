package com.employee.employee_managmet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "occupation")
public class Occupation {
    
  @Id
  private Long id;
  private String occupation;
  
  public Long getId() {
      return id;
  }
  public void setId(Long id) {
      this.id = id;
  }
  public String getOccupation() {
      return occupation;
  }
  public void setOccupation(String occupation) {
      this.occupation = occupation;
  }
}
