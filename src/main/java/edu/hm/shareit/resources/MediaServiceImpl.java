package edu.hm.shareit.resources;

import com.google.inject.Inject;
import edu.hm.persistierung.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.google.inject.Inject;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaServiceImpl implements MediaService {

    //@Inject
    private  Set<Book> bookSet = new HashSet<>();
    //@Inject
    private  Set<Disc> discSet = new HashSet<>();

    /**
     * Default Ctor.
     */
    public MediaServiceImpl() {


    }


    public MediaServiceImpl(boolean reset) {
        if (reset)
            bookSet =  new HashSet<>();
    }


    @Override
    public MediaServiceResult addBook(Book book) {


        MediaServiceResult out = MediaServiceResult.OK;
        if (book.isValid()) {
            if (!existBook(book.getIsbn())) {
                add(book);
            }
            else {
                out = MediaServiceResult.CONFLICT;
            }
        }
        else {
            out = MediaServiceResult.BAD_REQUEST;
        }
        return out;

    }

    @Override
    public MediaServiceResult addDisk(Disc disc) {
        MediaServiceResult out = MediaServiceResult.OK;
        if (disc.isValid()) {
            if (!existDisc(disc.getBarcode())) {
                add(disc);
            }
            else {
                out = MediaServiceResult.CONFLICT;
            }
        }
        else {
            out = MediaServiceResult.BAD_REQUEST;
        }
        return out;
    }

    //TODO
    @Override
    public Medium[] getBooks() {

        return getAllBooks();
    }

    @Override
    public Medium[] getDiscs() {
       return getAllDisc();
    }

    /**
     * update the book with one specific isbn
     * and change all other values
     * @param book isbn shall not ne null
     * @return
     */
    @Override
    public MediaServiceResult updateBook(String isbn,Book book) {
        Iterator<Book> i = bookSet.iterator();
        if (existBook(isbn)) {
            Book b = getBook(isbn);
                if (book.getIsbn() != null && !book.getIsbn().equals(""))
                    return MediaServiceResult.BAD_REQUEST;
                if (book.getAuthor() != null && !book.getAuthor().equals(""))
                    b.setAuthor(book.getAuthor());
                if (book.getTitle() != null && !book.getTitle().equals(""))
                    b.setTitle(book.getTitle());
                update(b);
                return MediaServiceResult.OK;

            }
            return MediaServiceResult.BAD_REQUEST;
        }

    @Override
    public MediaServiceResult updateDisc(String barcode, Disc disc) {
        Iterator<Disc>i =  discSet.iterator();
      if(existDisc(barcode)){
            Disc b = getDisc(barcode);
            if(b.getBarcode().equals(barcode)){
                if(disc.getBarcode() == null || disc.getBarcode().equals(""))
                    return MediaServiceResult.BAD_REQUEST;
                if(disc.getDirector() != null && !disc.getDirector().equals(""))
                    b.setDirector(disc.getDirector());
                if(disc.getFsk() >0)
                    b.setFsk(disc.getFsk());
                if(disc.getTitle() != null && !disc.getTitle().equals(""))
                    b.setTitle(disc.getTitle());
                update(b);
                return MediaServiceResult.OK;
            }
        }
        return MediaServiceResult.BAD_REQUEST;
    }





      private boolean existBook(String isbn) {
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

    Book getBook(String isbn) {
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

     void add(Book book){
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
     private  boolean existDisc(String id) {

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
    Disc getDisc(String id) {

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

    void add(Disc that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(that);
        tx.commit();
    }

    void update(Book that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(that);
        tx.commit();
    }
    void update(Disc that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(that);
        tx.commit();
    }

    void del(Disc that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(that);
        tx.commit();
    }
    void del(Book that){
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(that);
        tx.commit();
    }

    Book[] getAllBooks(){
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

    Disc[] getAllDisc(){
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
