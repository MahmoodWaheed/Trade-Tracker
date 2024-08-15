package org.example.model;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;

    @Column(name = "name", nullable = false)
    private String personName;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "number_of_purchase")
    private int numberOfPurchase;

    // Default constructor
    public Person() {
    }

    public Person(String personName, String type, String address, String phoneNumber, String email, int numberOfPurchase) {
        this.personName = personName;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberOfPurchase = numberOfPurchase;
    }

    public Person(int personId, String personName, String type, String address, String phoneNumber, String email, int numberOfPurchase) {
        this.personId = personId;
        this.personName = personName;
        this.type = type;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.numberOfPurchase = numberOfPurchase;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfPurchase() {
        return numberOfPurchase;
    }

    public void setNumberOfPurchase(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
    }
}

