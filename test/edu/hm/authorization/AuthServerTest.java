package edu.hm.authorization;

import org.json.JSONObject;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 17.05.2017.
 */
public class AuthServerTest {
    AuthServer auth = new AuthServer();

   @Test public void addUser(){
       User u = new User("a","a");
       auth.sig(u);
       auth.login(u);
       auth.logout(u);


   }
}
