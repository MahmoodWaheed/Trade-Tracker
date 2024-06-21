package entities;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */


import javax.persistence.*;

@Entity
@Table(name = "TransactionDetail")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private double sellingPrice;

    @Column(nullable = false)
    private double comulativePrice;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "Transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // Getters and Setters
}

