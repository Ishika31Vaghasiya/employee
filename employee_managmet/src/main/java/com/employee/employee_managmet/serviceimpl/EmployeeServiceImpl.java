package com.employee.employee_managmet.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employee.employee_managmet.model.Employee;
import com.employee.employee_managmet.service.EmployeeService;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Component
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EntityManager em;

  @Override
  public List<Object[]> getEmployeeByFilter(int pageSize, int pageNumber, int age, String timing, String occupation,
      String gender) {

    String query = "SELECT e.id, e.name, e.date_of_birth, e.age, e.phone, e.description  FROM employee AS e INNER JOIN employee_occupation AS ec ON e.id = ec.employee_id INNER JOIN occupation AS oc ON oc.id = ec.occupation_id";

    StringBuilder whereClause = new StringBuilder(" WHERE e.id > 0");
    StringBuilder groupByClause = new StringBuilder(" GROUP BY e.id");
    StringBuilder pagination = new StringBuilder(" LIMIT " + (pageNumber * pageSize) + ", " + pageSize + " ");

    if (!StringUtils.isEmpty(occupation)) {
      whereClause.append(" AND occupation = '" + occupation + "'");
    }
    if (age > 0) {
      whereClause.append(" AND age = " + age + "");
    }
    if (timing != null) {
      // whereClause.append(" AND ");
    }
    if (StringUtils.isNotEmpty(gender)) {
      int type = gender.equalsIgnoreCase("female") ? 1 : 2;
      whereClause.append(" AND gender = " + type + " ");
    }
    query = query + whereClause.toString() + groupByClause.toString() + pagination.toString();
    List<Object[]> res = em.createNativeQuery(query).getResultList();
    return res;
  }
}
