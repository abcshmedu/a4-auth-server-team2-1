package edu.hm.authorization;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 17.05.2017.
 */
public class AuthServerTest {
    AuthServer auth = new AuthServer();

   @Test public void addUser(){
       User u = new User("a","a");


       Assert.assertEquals( auth.sig(u).getStatus(),200);
       Assert.assertEquals(  auth.login(u).getStatus(),250);
       Assert.assertEquals(  auth.logout(u).getStatus(),200);



   }

    @Test public void addDubbleUser(){
        User u = new User("b","b");


        Assert.assertEquals( auth.sig(u).getStatus(),200);
        Assert.assertEquals(  auth.sig(u).getStatus(),400);
    }

   @Test public void valid(){
        Token t = new Token("asdasd");
        Assert.assertFalse(auth.validate(t).getStatus() == 200);
        User u = new User("asd","ads");
        t = Token.generateToken(u);
       Assert.assertTrue(auth.validate(t).getStatus() == 200);
    }
}
