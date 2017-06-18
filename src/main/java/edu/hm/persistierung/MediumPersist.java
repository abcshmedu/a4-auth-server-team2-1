package edu.hm.persistierung;

import edu.hm.shareit.resources.Book;
import edu.hm.shareit.resources.Disc;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 18.06.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.persistierung                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class MediumPersist {




    public boolean existBook(String isbn) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder =  session.getCriteriaBuilder();

        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.where(builder.equal(root.get("isbn"),isbn));
        Query<Book> bookQuery=  session.createQuery(query);
        List<Book> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.size() != 0;
    }

    public Book getBook(String isbn) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder =  session.getCriteriaBuilder();

        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.where(builder.equal(root.get("isbn"),isbn));
        Query<Book> bookQuery=  session.createQuery(query);
        List<Book> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.get(0);
    }

    public void add(Book book){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);

        tx.commit();
    }

    /**
     * Checks if a disc exists.
     * @param id disc to check.
     * @return true if the disc exists.
     */
    public   boolean existDisc(String id) {

        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder =  session.getCriteriaBuilder();

        CriteriaQuery<Disc> query = builder.createQuery(Disc.class);
        Root<Disc> root = query.from(Disc.class);
        query.where(builder.equal(root.get("barcode"),id));
        Query<Disc> bookQuery=  session.createQuery(query);
        List<Disc> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.size() != 0;
    }
    public Disc getDisc(String id) {

        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder =  session.getCriteriaBuilder();

        CriteriaQuery<Disc> query = builder.createQuery(Disc.class);
        Root<Disc> root = query.from(Disc.class);
        query.where(builder.equal(root.get("barcode"),id));
        Query<Disc> bookQuery=  session.createQuery(query);
        List<Disc> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.get(0);
    }

    public void add(Disc that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(that);
        tx.commit();
    }

    public void update(Book that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(that);
        tx.commit();
    }
    public void update(Disc that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(that);
        tx.commit();
    }


    public Book[] getAllBooks(){
        Transaction trans = HibernateUtils.getSessionFactory().getCurrentSession().beginTransaction();
        CriteriaBuilder builder = HibernateUtils.getSessionFactory().getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        Query<Book> q = HibernateUtils.getSessionFactory().getCurrentSession().createQuery(query);
        List<Book> results = q.getResultList();
        trans.commit();
        Book[] resultArray = new Book[results.size()];
        for (int i = 0; i < results.size(); i++){
            resultArray[i]= results.get(i);
        }
        return resultArray;
    }

    public Disc[] getAllDisc(){
        Transaction trans = HibernateUtils.getSessionFactory().getCurrentSession().beginTransaction();
        CriteriaBuilder builder = HibernateUtils.getSessionFactory().getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Disc> query = builder.createQuery(Disc.class);
        Root<Disc> root = query.from(Disc.class);

        Query<Disc> q = HibernateUtils.getSessionFactory().getCurrentSession().createQuery(query);
        List<Disc> results = q.getResultList();
        trans.commit();
        Disc[] resultArray = new Disc[results.size()];
        for (int i = 0; i < results.size(); i++){
            resultArray[i]= results.get(i);
        }
        return resultArray;
    }


}
