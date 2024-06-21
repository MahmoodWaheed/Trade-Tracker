package dao;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */


import entities.TransactionDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class TransactionDetailDAO {

    public void saveTransactionDetail(TransactionDetail transactionDetail) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.save(transactionDetail);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateTransactionDetail(TransactionDetail transactionDetail) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.update(transactionDetail);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public TransactionDetail getTransactionDetailById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TransactionDetail.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TransactionDetail> getAllTransactionDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TransactionDetail", TransactionDetail.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteTransactionDetail(int id) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            TransactionDetail transactionDetail = session.get(TransactionDetail.class, id);
            if (transactionDetail != null) {
                session.delete(transactionDetail);
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

