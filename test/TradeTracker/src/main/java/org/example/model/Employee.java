package org.example.model;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Column(name = "job_title")
    private String title;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private int salary;

    @Column(name = "email", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    public Employee() {

    }


    public Employee(String employeeName, Date birthDate, String gender, Date hireDate, String title, String department, int salary, String emailAddress, String phoneNumber, String address) {
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.hireDate = hireDate;
        this.title = title;
        this.department = department;
        this.salary = salary;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Employee(int employeeId, String employeeName, Date birthDate, String gender, Date hireDate, String title, String department, int salary, String emailAddress, String phoneNumber, String address) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.hireDate = hireDate;
        this.title = title;
        this.department = department;
        this.salary = salary;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeID) {
        this.employeeId = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date dateOfBirth) {
        this.birthDate = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String jobTitle) {
        this.title = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


