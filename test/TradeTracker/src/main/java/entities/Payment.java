package entities;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType;

    @Column(nullable = false)
    private String paymentWay;

    @ManyToOne
    @JoinColumn(name = "Transaction_id", nullable = true)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "Person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "PurchaseTransaction_id", nullable = true)
    private PurchaseTransaction purchaseTransaction;

    // Enum for PaymentType
    public enum PaymentType {
        PAYMENT, RECEIPT
    }

    // Getters and Setters
}
