package org.example.dao;


import javafx.collections.ObservableList;
import org.example.model.Employee;

import java.util.List;

public interface EmployeeDao {
     Employee getEmployee(int id);
     Employee getEmployeeByName(String productName);
     ObservableList<Employee> getAllEmployeesByName(String productName);
     void saveEmployee(Employee employee);
     void updateEmployee(Employee employee);
     void deleteEmployee(Employee employee);
     List getAllEmployee();
     int lastId();

}
