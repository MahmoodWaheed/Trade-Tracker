package dao;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import entities.PurchaseDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class PurchaseDetailDAO {

    public void savePurchaseDetail(PurchaseDetail purchaseDetail) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.save(purchaseDetail);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePurchaseDetail(PurchaseDetail purchaseDetail) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.update(purchaseDetail);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public PurchaseDetail getPurchaseDetailById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PurchaseDetail.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PurchaseDetail> getAllPurchaseDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PurchaseDetail", PurchaseDetail.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletePurchaseDetail(int id) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            PurchaseDetail purchaseDetail = session.get(PurchaseDetail.class, id);
            if (purchaseDetail != null) {
                session.delete(purchaseDetail);
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

