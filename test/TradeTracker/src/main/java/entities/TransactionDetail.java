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
//
//@Entity
//@Table(name = "TransactionDetail")
//public class TransactionDetail {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(nullable = false)
//    private double quantity;
//
//    @Column(nullable = false)
//    private double sellingPrice;
//
//    @Column(nullable = false)
//    private double comulativePrice;
//
//    @Column(nullable = false)
//    private double price;
//
//    @ManyToOne
//    @JoinColumn(name = "Transaction_id", nullable = false)
//    private Transaction transaction;
//
//    @ManyToOne
//    @JoinColumn(name = "item_id", nullable = false)
//    private Item item;
//
//    // Getters and Setters
//}
//
package entities;

import javax.persistence.*;

@Entity
@Table(name = "TransactionDetail")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double quantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private double sellingPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private double comulativePrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private double price;

    @ManyToOne
    @JoinColumn(name = "Transaction_id", nullable = false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getComulativePrice() {
        return comulativePrice;
    }

    public void setComulativePrice(double comulativePrice) {
        this.comulativePrice = comulativePrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

