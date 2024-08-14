package org.example.service;//package org.example.service;
////
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import org.example.dao.CategoryDao;
//import org.example.model.Category;
//import org.example.model.Category;
//import org.example.model.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//
//import java.util.List;
//
//
//public class CategoryService implements CategoryDao {
//    private SessionFactory sessionFactory;
//
//    public CategoryService() {
//        sessionFactory = new Configuration().configure().buildSessionFactory();
//    }
//
//
//
//    @Override
//    public void saveCategory(Category category) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.persist(category);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public ObservableList<Category> getAllCategoriesByName(String category) {
//        ObservableList<Category> categories;
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Query<Category> query = session.createQuery("from Category where name like :name",Category.class);
//        query.setParameter("name",category.toLowerCase()+ "%");
//        categories = FXCollections.observableArrayList(query.getResultList());
//
//        session.getTransaction().commit();
//        session.close();
//
//        return categories;
//    }
//
//    @Override
//    public void updateCategory(Category category) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.update(category);
//
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void deleteCategory(Category category) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Category e = session.get(Category.class, category.getId());
//        session.delete(e);
//
//        session.getTransaction().commit();
//        session.close();
//
//    }
//
//    @Override
//    public Category getCategoryById(int id) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Category category = session.get(Category.class, id);
//
//        session.getTransaction().commit();
//        session.close();
//
//        return category;
//    }
//
//    @Override
//    public List<Category> getAllCategories() {
//        List<Category> list;
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        Query<Category> query = session.createQuery("from Category ",Category.class);
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
//        Query<Integer> query = session.createQuery("select max(id) from Category ", Integer.class);
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
