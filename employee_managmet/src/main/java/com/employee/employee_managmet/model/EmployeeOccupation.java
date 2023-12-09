package com.employee.employee_managmet.model;

import java.util.Date;

import org.json.JSONObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "employee_occupation")
public class EmployeeOccupation {
  
  @Id
  private Long id;

  // @ManyToOne
  // @JoinColumn(name = "employee_id", referencedColumnName = "id")
  // private Employee employee;

  // @ManyToOne
  // @JoinColumn(name =  "occupation_id", referencedColumnName = "id")
  // private Occupation occupation;

  private Date availableFrom;
  private Date availableTo;

  public Date getAvailableFrom() {
    return availableFrom;
  }

  public void setAvailableFrom(Date availableFrom) {
    this.availableFrom = availableFrom;
  }

  public Date getAvailableTo() {
    return availableTo;
  }

  public void setAvailableTo(Date availableTo) {
    this.availableTo = availableTo;
  }

  public JSONObject getJsonObject() {
    JSONObject obj = new JSONObject();

    obj.put("occupation_id", id);
    //obj.put("occupation",occupation);
    obj.put("available_from", availableFrom);
    obj.put("available_to", availableTo);

    return obj;
  }
}
