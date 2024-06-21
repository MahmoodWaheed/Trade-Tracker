package entities;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */

import javax.persistence.*;

@Entity
@Table(name = "PurchaseDetail")
public class PurchaseDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false)
    private double purchasingPrice;

    @Column(nullable = true)
    private double comulativePrice;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "PurchaseTransaction_id", nullable = false)
    private PurchaseTransaction purchaseTransaction;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // Getters and Setters
}

