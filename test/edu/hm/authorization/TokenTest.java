package edu.hm.authorization;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lapi on 23/05/2017.
 */
public class TokenTest {

    @Test
    public void tokenEquals(){
        User u = new User("peter","pw");
        Token t = Token.generateToken(u);
        Token t2 = Token.generateToken(u);

        Assert.assertEquals(t,t2);
    }
    @Test
    public void NottokenEquals(){
        User u = new User("peter","pw");
        Token t = Token.generateToken(u);
        u = new User("peterLustig","pw");
        Token t2 = Token.generateToken(u);

        Assert.assertNotEquals(t,t2);
    }

    @Test public void AccesNotGrand(){
        Token t = new Token("abc");
        Assert.assertFalse(Token.isAccesGranded(t.getToken()));
    }
    @Test public void AccesGranded(){
        User u = new User("peter","pw");
        Token t = Token.generateToken(u);
        Assert.assertTrue(Token.isAccesGranded(t.getToken()));
    }


    @Test public void delUser2(){
        User u = new User("peterXXX","pw");

        Assert.assertFalse(Token.deleteToken(u));
    }

    @Test public void delUser(){
        User u = new User("XXX","pw");
        Token t = Token.generateToken(u);
        Assert.assertTrue(Token.isAccesGranded(t.getToken()));
        Token.deleteToken(u);
        Assert.assertFalse(Token.isAccesGranded(t.getToken()));
    }
}
