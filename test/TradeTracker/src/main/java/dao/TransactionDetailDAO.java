//package dao;
//
///**
// * Author: @ Mahmoud Waheed
// * DATE: 6/21/2024
// * PROJECT NAME: TradeTracker
// */
//
//
//import entities.TransactionDetail;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import utils.HibernateUtil;
//
//import java.util.List;
//
//public class TransactionDetailDAO {
//
//    public void saveTransactionDetail(TransactionDetail transactionDetail) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            session.save(transactionDetail);
//            txn.commit();
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public void updateTransactionDetail(TransactionDetail transactionDetail) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            session.update(transactionDetail);
//            txn.commit();
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public TransactionDetail getTransactionDetailById(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.get(TransactionDetail.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public List<TransactionDetail> getAllTransactionDetails() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from TransactionDetail", TransactionDetail.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void deleteTransactionDetail(int id) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            TransactionDetail transactionDetail = session.get(TransactionDetail.class, id);
//            if (transactionDetail != null) {
//                session.delete(transactionDetail);
//                txn.commit();
//            }
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//}
//
//package dao;
//
//import entities.TransactionDetail;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import utils.HibernateUtil;
//
//import java.util.List;
//
//public class TransactionDetailDAO {
//
//    public void saveTransactionDetail(TransactionDetail transactionDetail) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            session.save(transactionDetail);
//            txn.commit();
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public void updateTransactionDetail(TransactionDetail transactionDetail) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            session.update(transactionDetail);
//            txn.commit();
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    public TransactionDetail getTransactionDetailById(int id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.get(TransactionDetail.class, id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public List<TransactionDetail> getAllTransactionDetails() {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session.createQuery("from TransactionDetail", TransactionDetail.class).list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void deleteTransactionDetail(int id) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            TransactionDetail transactionDetail = session.get(TransactionDetail.class, id);
//            if (transactionDetail != null) {
//                session.delete(transactionDetail);
//                txn.commit();
//            }
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    // Method to delete transaction details by transaction ID
//    public void deleteTransactionDetailsById(int Id) {
//        Transaction txn = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            txn = session.beginTransaction();
//            List<TransactionDetail> transactionDetails = session
//                    .createQuery("from TransactionDetail where transaction.Id = :Id", TransactionDetail.class)
//                    .setParameter("Id", Id)
//                    .list();
//            for (TransactionDetail detail : transactionDetails) {
//                session.delete(detail);
//            }
//            txn.commit();
//        } catch (Exception e) {
//            if (txn != null) {
//                txn.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//
//    // Method to get transaction details by transaction ID
//    public List<TransactionDetail> getTransactionDetailsById(int Id) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            return session
//                    .createQuery("from TransactionDetail where transaction.Id = :Id", TransactionDetail.class)
//                    .setParameter("Id", Id)
//                    .list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}

package dao;

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

    // Method to delete transaction details by transaction ID
    public void deleteTransactionDetailsByTransactionId(int transactionId) {
        Transaction txn = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            txn = session.beginTransaction();
            List<TransactionDetail> transactionDetails = session
                    .createQuery("from TransactionDetail where transaction.id = :transactionId", TransactionDetail.class)
                    .setParameter("transactionId", transactionId)
                    .list();
            for (TransactionDetail detail : transactionDetails) {
                session.delete(detail);
            }
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        }
    }

    // Method to get transaction details by transaction ID
    public List<TransactionDetail> getTransactionDetailsByTransactionId(int transactionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session
                    .createQuery("from TransactionDetail where transaction.id = :transactionId", TransactionDetail.class)
                    .setParameter("transactionId", transactionId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

