package dao;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */


import entities.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class PaymentDAO {

    public void savePayment(Payment payment) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.save(payment);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePayment(Payment payment) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.update(payment);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public Payment getPaymentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Payment> getAllPayments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Payment", Payment.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletePayment(int id) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            Payment payment = session.get(Payment.class, id);
            if (payment != null) {
                session.delete(payment);
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

