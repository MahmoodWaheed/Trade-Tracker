//package dao;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/21/2024
// * PROJECT NAME: TradeTracker
// */
//
//
//import entities.Phone;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import utils.HibernateUtil;
//
//import java.util.List;
//
//public class PhoneDAO {
//
//    public void savePhone(Phone phone) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(phone);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public void updatePhone(Phone phone) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.update(phone);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public Phone getPhoneById(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.get(Phone.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public List<Phone> getAllPhones() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from Phone", Phone.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void deletePhone(int id) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Phone phone = session.get(Phone.class, id);
//            if (phone != null) {
//                session.delete(phone);
//                transaction.commit();
//            }
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//}
package dao;

/**
 * Author: @ Mahmoud Waheed
 * DATE: 6/21/2024
 * PROJECT NAME: TradeTracker
 */
import entities.Phone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class PhoneDAO {

    public void savePhone(Phone phone) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.save(phone);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updatePhone(Phone phone) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            session.update(phone);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deletePhone(int id) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            Phone phone = session.get(Phone.class, id);
            if (phone != null) {
                session.delete(phone);
                txn.commit();
            }
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Phone> getPhonesByNumber(String phoneNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Phone where phoneNumber = :phoneNumber", Phone.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


