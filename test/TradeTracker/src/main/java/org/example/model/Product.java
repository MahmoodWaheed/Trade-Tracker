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
    private double price;
    @Column(name = "product_count", nullable = false)
    private int count;
    @Column(name = "category", nullable = false)
    @ElementCollection
    private Set<String> category=new HashSet<>();
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

//    public Item(String name, Category category, Date dateAdded, Date expireDate, double price, String barcode, Supplier supplier, int stockAmount, double discount, int count) {
//        this.name = name;
//        this.category = category;
//        this.dateAdded = dateAdded;
//        this.expireDate = expireDate;
//        this.price = price;
//        this.barcode = barcode;
//        this.supplier = supplier;
//        this.stockAmount = stockAmount;
//        this.discount = discount;
//        this.count = count;
//        this.categoryName = category != null ? category.getName() : "jj";
//        this.supplierName = supplier != null ? supplier.getName() : "ii";
//    }

    public Product(String name, double price, int count, Set<String> category) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
    }

    public Product(int id, String name, double price, int count, Set<String> category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
    }

    public Set<String> getCategory() {
        return category;
    }

    public void setCategory(Set<String> category) {
        this.category = category;
    }
    //    public Item(int id, String name, Category category, Date dateAdded, Date expireDate, double price, String barcode, Supplier supplier, int stockAmount, double discount, int count) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//        this.dateAdded = dateAdded;
//        this.expireDate = expireDate;
//        this.price = price;
//        this.barcode = barcode;
//        this.supplier = supplier;
//        this.stockAmount = stockAmount;
//        this.discount = discount;
//        this.count = count;
//    }

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

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//        this.categoryName = category != null ? category.getName() : null;
//
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//
//    public Date getDateAdded() {
//        return dateAdded;
//    }
//
//    public void setDateAdded(Date dateAdded) {
//        this.dateAdded = dateAdded;
//    }
//
//    public Date getExpireDate() {
//        return expireDate;
//    }
//
//    public void setExpireDate(Date expireDate) {
//        this.expireDate = expireDate;
//    }
//
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//
//    public String getBarcode() {
//        return barcode;
//    }
//
//    public void setBarcode(String barcode) {
//        this.barcode = barcode;
//    }
//
//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//        this.supplierName = supplier != null ? supplier.getName() : null;
//
//    }
//
//    public String getSupplierName() {
//        return supplierName;
//    }
//
//
//    public int getStockAmount() {
//        return stockAmount;
//    }
//
//    public void setStockAmount(int stockAmount) {
//        this.stockAmount = stockAmount;
//    }
//
//    public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(double discount) {
//        this.discount = discount;
//    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

