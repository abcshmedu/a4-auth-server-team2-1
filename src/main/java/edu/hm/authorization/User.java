package edu.hm.authorization;

import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lapi on 17/05/2017.
 */
public class User {

    private static Set userList = new HashSet<>();
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

    public  boolean add(User user){
        if(!(userList.contains(user))) {
            userList.add(user);
            return true;
        }
        return false;

    }

    public boolean equals(User that){
        if(that == null)
            return false;
        if(that.password.equals(password)& that.userName.equals(userName))
            return true;
        else return false;
    }


}
