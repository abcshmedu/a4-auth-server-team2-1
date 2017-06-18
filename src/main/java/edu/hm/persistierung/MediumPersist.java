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
 * Created by lapi on 17/05/2017.
 */
public class MediumPersist {


    /**
     * check if book is in db.
     *
     * @param isbn isbn
     * @return true if in db
     */
    public boolean existBook(String isbn) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.where(builder.equal(root.get("isbn"), isbn));
        Query<Book> bookQuery = session.createQuery(query);
        List<Book> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.size() != 0;
    }

    /**
     * get a singel bock from db.
     *
     * @param isbn isbn
     * @return book
     */
    public Book getBook(String isbn) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.where(builder.equal(root.get("isbn"), isbn));
        Query<Book> bookQuery = session.createQuery(query);
        List<Book> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.get(0);
    }

    /**
     * add a book to the db.
     *
     * @param book book
     */
    public void add(Book book) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);

        tx.commit();
    }

    /**
     * Checks if a disc exists.
     *
     * @param id disc to check.
     * @return true if the disc exists.
     */
    public boolean existDisc(String id) {

        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Disc> query = builder.createQuery(Disc.class);
        Root<Disc> root = query.from(Disc.class);
        query.where(builder.equal(root.get("barcode"), id));
        Query<Disc> bookQuery = session.createQuery(query);
        List<Disc> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.size() != 0;
    }

    /**
     * get single disc.
     *
     * @param id id
     * @return disc
     */
    public Disc getDisc(String id) {

        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<Disc> query = builder.createQuery(Disc.class);
        Root<Disc> root = query.from(Disc.class);
        query.where(builder.equal(root.get("barcode"), id));
        Query<Disc> bookQuery = session.createQuery(query);
        List<Disc> answer = bookQuery.getResultList();
        tx2.commit();
        return answer.get(0);
    }

    /**
     * add disc to db.
     *
     * @param that disc
     */
    public void add(Disc that) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(that);
        tx.commit();
    }

    /**
     * update book in db.
     *
     * @param that book
     */
    public void update(Book that) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(that);
        tx.commit();
    }

    /**
     * update Disc in db.
     *
     * @param that disc
     */
    public void update(Disc that) {
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(that);
        tx.commit();
    }


    /**
     * get all books from db.
     *
     * @return books
     */
    public Book[] getAllBooks() {
        Transaction trans = HibernateUtils.getSessionFactory().getCurrentSession().beginTransaction();
        CriteriaBuilder builder = HibernateUtils.getSessionFactory().getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);

        Query<Book> q = HibernateUtils.getSessionFactory().getCurrentSession().createQuery(query);
        List<Book> results = q.getResultList();
        trans.commit();
        Book[] resultArray = new Book[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArray[i] = results.get(i);
        }
        return resultArray;
    }

    /**
     * get all Disc from Db.
     *
     * @return discs
     */
    public Disc[] getAllDisc() {
        Transaction trans = HibernateUtils.getSessionFactory().getCurrentSession().beginTransaction();
        CriteriaBuilder builder = HibernateUtils.getSessionFactory().getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Disc> query = builder.createQuery(Disc.class);
        Root<Disc> root = query.from(Disc.class);

        Query<Disc> q = HibernateUtils.getSessionFactory().getCurrentSession().createQuery(query);
        List<Disc> results = q.getResultList();
        trans.commit();
        Disc[] resultArray = new Disc[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArray[i] = results.get(i);
        }
        return resultArray;
    }


}
