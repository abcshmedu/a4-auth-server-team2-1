package edu.hm.authorization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by lapi on 17/05/2017.
 */
@Entity
public class User {


    private static Set<User> userList = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;

    /**
     * konstr.
     * @param name n
     * @param pw p
     */
    public User(String name, String pw) {
        userName = name;
        password = pw;

    }

    /**
     * konstr.
     */
    public User() {

    };

    /**
     * get.
     * @return s
     */
    public String getUserName() {
        return userName;
    }

    /**
     * get.
     * @return s
     */
    public String getPassword() {
        return password;
    }

    /**
     * fügt ein neuen User hinzu.
     * @param user user to add
     * @return true = user added  false user exist
     */
    public static   boolean add(User user) {
        if (exist(user)) {
            return false;
        } else {
            return userList.add(user);
        }
    }


    /**
     * exsit.
     * @param user u
     * @return b
     */
    static   boolean exist(User user) {
        int i = 0;
        return userList.contains(user);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true; }
        if (o == null || getClass() != o.getClass()) {
            return false; }

        User user = (User) o;

        if (id != user.id) {
            return false;
        }
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) {
            return false;
        }
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
