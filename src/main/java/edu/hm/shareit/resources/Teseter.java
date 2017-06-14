package edu.hm.shareit.resources;

import edu.hm.persistierung.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by MatHe on 14.06.2017.
 */
public class Teseter {
    public static void main(String[] args) {
       Book book = new Book("titettl","1234","authot");
        SessionFactory sessionFactory =
                HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);

        tx.commit();

        session = sessionFactory.getCurrentSession();
        Transaction tx2 = session.beginTransaction();
        CriteriaBuilder builder =  session.getCriteriaBuilder();

        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.where(builder.equal(root.get("isbn"),book.getIsbn()));

        Query<Book> bookQuery=  session.createQuery(query);

        List<Book> answer = bookQuery.getResultList();
        tx2.commit();
        //jetzt answer da
        System.out.println(answer.get(0).toString());

        System.out.println("asdf");
    }
}
