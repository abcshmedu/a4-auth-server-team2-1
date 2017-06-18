package edu.hm.authorization;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
    public static void main(String[] args) {
        User u1 = new User("a","a");
        User u2 = new User("a","a");
        System.out.println(Boolean.toString(!exist(u1)));
        System.out.println(Boolean.toString(add(u1)));
        System.out.println(Boolean.toString(!exist(u2)));
        System.out.println(Boolean.toString(!add(u1)));
        System.out.println(Boolean.toString(add(u2)));
        System.out.println(Boolean.toString(exist(u1)));
        System.out.println(Boolean.toString(exist(u2)));

    }

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
        if (exist(user)){
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
        int i = 0;
        return userList.contains(user);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
