package org.example.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService implements EmployeeDao {

    private SessionFactory sessionFactory;

    public EmployeeService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee employee = session.get(Employee.class, id);

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    @Override
    public Employee getEmployeeByName(String EmployeeName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Employee> query = session.createQuery("from Employee where employeeName = :name",Employee.class);
        query.setParameter("name",EmployeeName);
        Employee employee = query.uniqueResult();

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    @Override
    public ObservableList<Employee> getAllEmployeesByName(String employeeName) {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Employee> query = session.createQuery("from Employee where employeeName like :name",Employee.class);
        query.setParameter("name",employeeName.toLowerCase()+ "%");
        employees = FXCollections.observableArrayList(query.getResultList());

        session.getTransaction().commit();
        session.close();

        return employees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(employee);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(employee);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Employee e = session.get(Employee.class, employee.getEmployeeId());
        session.delete(e);

        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> list;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Employee> query = session.createQuery("from Employee ",Employee.class);
        list =query.list();


        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public int lastId() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Integer> query = session.createQuery("select max(id) from Employee ", Integer.class);
        Integer id = query.uniqueResult();


        session.getTransaction().commit();
        session.close();
        if(id == null)
            return 0;
        else
            return id;
    }
}
