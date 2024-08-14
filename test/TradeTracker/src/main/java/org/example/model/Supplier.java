package org.example.model;//package org.example.model;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "supplier")
//public class Supplier {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "supplier_name")
//    private String name;
//    @Column(name = "last_supplied_date")
//    @Temporal(TemporalType.DATE)
//    private Date lastSupplied;
//    @OneToMany(mappedBy = "supplier")
//    private List<Item> items;
//
//    public Supplier() {
//    }
//
//    public Supplier(String name, Date lastSupplied) {
//        this.name = name;
//        this.lastSupplied = lastSupplied;
//
//    }
//
//    public Supplier(int id, String name, Date lastSupplied) {
//        this.id = id;
//        this.name = name;
//        this.lastSupplied = lastSupplied;
//
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Date getLastSupplied() {
//        return lastSupplied;
//    }
//
//    public void setLastSupplied(Date lastSupplied) {
//        this.lastSupplied = lastSupplied;
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//}
