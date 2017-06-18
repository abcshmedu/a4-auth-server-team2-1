package edu.hm.authorization;

import edu.hm.persistierung.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.hibernate.query.*;
import org.json.JSONObject;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * Created by lapi on 17/05/2017.
 */
@Entity
public class User {

    private static Set<User> userList = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String userName;
    String password;

    public User(String name, String pw){
        userName = name;
        password = pw;

    }
    public User(){

    };

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    /**
     * fügt ein neuen User hinzu
     * @param user user to add
     * @return true = user added  false user exist
     */
    static public  boolean add(User user){
        if (userList.contains(user)){
            return false;
        }else {
            return userList.add(user);
        }
    }


    //Todo static?
    static public  boolean exist(User user){
        /*
        Session s = injector.getInstance(SessionFactory.class).getCurrentSession();
        Transaction tx = s.beginTransaction();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(builder.equal(root.get("firstName"), "Neville"));
        org.hibernate.query.Query<User> q = s.createQuery(query);
        List<User> persons = q.getResultList();

      if(persons.size() == 0) {
          s.persist(user);
          tx.commit();
          s.close();
          return true;
      }
        s.close();

       /* if(!(userList.contains(user))) {
            Iterator<User> i = userList.iterator();
            while(i.hasNext()){
                if(i.next().equals(user))
                    return false;
            }
            return true;

        }
        */
        return userList.contains(user);

    }

    public boolean equals(User that){
        if(that == null)
            return false;
        if(that.password.equals(password)& that.userName.equals(userName))
            return true;
        else return false;
    }


}
