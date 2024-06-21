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
@Table(name = "PurchaseTransaction")
public class PurchaseTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date purchaseDate;

    @Column(nullable = false)
    private double totalAmount;

    @ManyToOne
    @JoinColumn(name = "Person_id", nullable = false)
    private Person person;

    @OneToMany(mappedBy = "purchaseTransaction", cascade = CascadeType.ALL)
    private Set<PurchaseDetail> purchaseDetails;

    // Getters and Setters
}

