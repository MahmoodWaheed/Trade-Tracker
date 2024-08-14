package org.example.model;//package org.example.model;
//
//import javax.persistence.*;
//import java.sql.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "category")
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name = "category_name")
//    private String name;
//    @Column(name = "date_of_creation")
//    @Temporal(TemporalType.DATE)
//    private Date dateCreated;
//    @OneToMany(mappedBy = "category")
//    private List<Item> items;
//
//    public Category() {
//    }
//
//    public Category(String name, Date dateCreated) {
//        this.name = name;
//        this.dateCreated = dateCreated;
//
//    }
//
//    public Category(int id, String name, Date dateCreated) {
//        this.id = id;
//        this.name = name;
//        this.dateCreated = dateCreated;
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
//    public Date getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(Date dateCreated) {
//        this.dateCreated = dateCreated;
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
