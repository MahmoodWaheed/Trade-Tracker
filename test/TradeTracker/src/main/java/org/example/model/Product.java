package org.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name = "product_price", nullable = false)
    private int price;
    @Column(name = "product_count", nullable = false)
    private int count;
    @Column(name = "category", nullable = false)
    private String category ;

//    @ElementCollection
//    private Set<String> category=new HashSet<>();
    //    @ManyToOne
    //    @JoinColumn(name = "category")
    //    private Category category;
    //    @Column(name = "category_name")
    //    private String categoryName;
    //    @Column(name = "date_of_adding")
    //    @Temporal(TemporalType.DATE)
    //    private Date dateAdded;
    //    @Column(name = "expire_date", nullable = false)
    //    @Temporal(TemporalType.DATE)
    //    private Date expireDate;
//    @Column(name = "barcode")
//    private String barcode;
//    @ManyToOne
//    @JoinColumn(name = "supplier")
//    private Supplier supplier;
//    @Column(name = "supplier_name")
//    private String supplierName;
//    @Column(name = "stock_amount")
//    private int stockAmount;
//    @Column(name = "discount")
//    private double discount;

    public Product() {
    }


    public Product(int id, String name, int price, int count, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
    }

    public Product(String name, int price, int count, String category) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

