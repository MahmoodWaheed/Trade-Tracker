package org.example.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.dao.ProductDao;

import org.example.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ProductService implements ProductDao {

    private SessionFactory sessionFactory;


    public ProductService() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void saveItem(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(product);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public ObservableList<Product> getAllItemsByName(String itemName) {
        ObservableList<Product> products;
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Product> query = session.createQuery("from Product where name like :name", Product.class);
        query.setParameter("name",itemName.toLowerCase()+ "%");
        products = FXCollections.observableArrayList(query.getResultList());

        session.getTransaction().commit();
        session.close();

        return products;
    }

    @Override
    public void updateItem(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(product);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteItem(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(product);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Product getItemById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Product product = session.get(Product.class, id);

        session.getTransaction().commit();
        session.close();

        return product;
    }

    @Override
    public List<Product> getAllItems() {
        List<Product> list;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Product> query = session.createQuery("from Product ", Product.class);
        list =query.list();


        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public int lastId() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Integer> query = session.createQuery("select max(id) from Product ", Integer.class);
        Integer id = query.uniqueResult();


        session.getTransaction().commit();
        session.close();
        if(id == null)
            return 0;
        else
            return id;
    }
}
