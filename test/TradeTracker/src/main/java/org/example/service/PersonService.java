package org.example.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.dao.PersonDao;
import org.example.model.Person;
import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class PersonService implements PersonDao {

    private SessionFactory sessionFactory;

    public PersonService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            if (person != null) {
                session.delete(person);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Person getPersonById(int personId) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Person.class, personId);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Person> getAllPersons() {
        Session session = sessionFactory.openSession();
        try {
            Query<Person> query = session.createQuery("FROM Person", Person.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    @Override
    public ObservableList<Person> getAllIPersonsByName(String personName) {
        System.out.println("hhhhhhhhhhhhhhhhhhhh");
        ObservableList<Person> persons;
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Query<Person> query = session.createQuery("from Person where personName like :name", Person.class);
            query.setParameter("name",personName.toLowerCase()+ "%");
            persons = FXCollections.observableArrayList(query.getResultList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        session.getTransaction().commit();
        session.close();

        return persons;
    }

    @Override
    public int lastId() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Integer> query = session.createQuery("select max(id) from Person ", Integer.class);
        Integer id = query.uniqueResult();


        session.getTransaction().commit();
        session.close();
        if(id == null)
            return 0;
        else
            return id;
    }
}
