package dao;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */

import entities.PurchaseTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class PurchaseTransactionDAO {

    public void savePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.save(purchaseTransaction);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePurchaseTransaction(PurchaseTransaction purchaseTransaction) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.update(purchaseTransaction);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public PurchaseTransaction getPurchaseTransactionById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PurchaseTransaction.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PurchaseTransaction> getAllPurchaseTransactions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PurchaseTransaction", PurchaseTransaction.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletePurchaseTransaction(int id) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            PurchaseTransaction purchaseTransaction = session.get(PurchaseTransaction.class, id);
            if (purchaseTransaction != null) {
                session.delete(purchaseTransaction);
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

