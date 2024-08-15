package org.example.dao;

import javafx.collections.ObservableList;
import org.example.model.Person;
import org.example.model.Product;

import java.util.List;

public interface PersonDao {
    void savePerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
    Person getPersonById(int personId);
    List<Person> getAllPersons();
    ObservableList<Person> getAllIPersonsByName(String personName);
    int lastId();
}
