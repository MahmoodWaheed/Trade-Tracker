package dao;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import entities.Transaction; // Import the entities.Transaction class
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class TransactionDAO {

    public void saveTransaction(entities.Transaction transaction) {
        org.hibernate.Transaction txn = null; // Use the fully qualified class name
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.save(transaction);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateTransaction(entities.Transaction transaction) {
        org.hibernate.Transaction txn = null; // Use the fully qualified class name
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.update(transaction);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public entities.Transaction getTransactionById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entities.Transaction.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<entities.Transaction> getAllTransactions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Transaction", entities.Transaction.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteTransaction(int id) {
        org.hibernate.Transaction txn = null; // Use the fully qualified class name
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            entities.Transaction transaction = session.get(entities.Transaction.class, id);
            if (transaction != null) {
                session.delete(transaction);
                txn.commit();
            }
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }
}

