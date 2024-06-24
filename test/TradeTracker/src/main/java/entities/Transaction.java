//package entities;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/21/2024
// * PROJECT NAME: TradeTracker
// */
//
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "Transaction")
//public class Transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false)
//    private String transactionDate;
//
//    @Column(nullable = false)
//    private double totalAmount;
//
//    @ManyToOne
//    @JoinColumn(name = "salesRepId", nullable = false)
//    private Employee salesRep;
//
//    @ManyToOne
//    @JoinColumn(name = "Person_id", nullable = false)
//    private Person person;
//
//    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
//    private Set<TransactionDetail> transactionDetails;
//
//    // Getters and Setters
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTransactionDate() {
//        return transactionDate;
//    }
//
//    public void setTransactionDate(String transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//
//    public double getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public Employee getSalesRep() {
//        return salesRep;
//    }
//
//    public void setSalesRep(Employee salesRep) {
//        this.salesRep = salesRep;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public Set<TransactionDetail> getTransactionDetails() {
//        return transactionDetails;
//    }
//
//    public void setTransactionDetails(Set<TransactionDetail> transactionDetails) {
//        this.transactionDetails = transactionDetails;
//    }
//}
//
package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "salesRepId", nullable = false)
    private Employee salesRep;

    @ManyToOne
    @JoinColumn(name = "Person_id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Set<TransactionDetail> transactionDetails;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Employee getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Employee salesRep) {
        this.salesRep = salesRep;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(Set<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
