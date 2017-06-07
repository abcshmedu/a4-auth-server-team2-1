package edu.hm.authorization;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by MatHe on 17.05.2017.
 */
public class AuthServerTest {
    AuthServer auth = new AuthServer();

   /*@Test public void addUser(){
       User u = new User("a","a");


       Assert.assertEquals( auth.sig(u).getStatus(),200);
       Assert.assertEquals(  auth.login(u).getStatus(),250);
       Assert.assertEquals(  auth.logout(u).getStatus(),200);



   }*/

   /* @Test public void addDubbleUser(){
        User u = new User("b","b");

        //TODO Static MOCK
        Assert.assertEquals( auth.sig(u).getStatus(),200);

        Assert.assertEquals(  auth.sig(u).getStatus(),400);
    }*/

   @Test public void valid(){

        Token tokenMock = mock(Token.class);
        when(tokenMock.isAccesGranted()).thenReturn(false);
        Assert.assertFalse(auth.validate(tokenMock).getStatus() == 200);
       when(tokenMock.isAccesGranted()).thenReturn(true);
       Assert.assertTrue(auth.validate(tokenMock).getStatus() == 200);
    }
}
