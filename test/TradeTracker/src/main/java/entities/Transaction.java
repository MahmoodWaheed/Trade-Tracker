package entities;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */


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
    private Date transactionDate;

    @Column(nullable = false)
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
}

