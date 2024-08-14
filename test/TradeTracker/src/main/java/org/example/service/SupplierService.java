package org.example.service;//package org.example.service;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import org.example.dao.SupplierDao;
//import org.example.model.Employee;
//import org.example.model.Item;
//import org.example.model.Supplier;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//public class SupplierService implements SupplierDao {
//    private SessionFactory sessionFactory;
//
//
//    public SupplierService() {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//    }
//    @Override
//    public void saveSupplier(Supplier supplier) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.persist(supplier);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public Supplier getSupplierByName(String name) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Query<Supplier> query = session.createQuery("from Supplier where name = :name",Supplier.class);
//        query.setParameter("name",name);
//        Supplier supplier = query.uniqueResult();
//
//        session.getTransaction().commit();
//        session.close();
//
//        return supplier;
//    }
//
//    @Override
//    public ObservableList<Supplier> getAllSuppliersByName(String suppliers) {
//        ObservableList<Supplier> suppliers1;
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Query<Supplier> query = session.createQuery("from Supplier where name like :name",Supplier.class);
//        query.setParameter("name",suppliers.toLowerCase()+ "%");
//        suppliers1 = FXCollections.observableArrayList(query.getResultList());
//
//        session.getTransaction().commit();
//        session.close();
//
//        return suppliers1;
//    }
//
//    @Override
//    public Supplier getSupplierById(int id) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Supplier supplier = session.get(Supplier.class, id);
//
//        session.getTransaction().commit();
//        session.close();
//
//        return supplier;
//    }
//
//    @Override
//    public void updateSupplier(Supplier supplier) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.update(supplier);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void deleteSupplier(Supplier supplier) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Supplier e = session.get(Supplier.class, supplier.getId());
//        session.delete(e);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public List<Supplier> getAllSuppliers() {
//        List<Supplier> list;
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Query<Supplier> query = session.createQuery("from Supplier ",Supplier.class);
//        list =query.list();
//
//
//        session.getTransaction().commit();
//        session.close();
//        return list;
//    }
//
//    @Override
//    public int lastId() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Query<Integer> query = session.createQuery("select max(id) from Supplier ", Integer.class);
//        Integer id = query.uniqueResult();
//
//
//        session.getTransaction().commit();
//        session.close();
//        if(id == null)
//            return 0;
//        else
//            return id;
//    }
//}
