package edu.hm.authorization;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 23.05.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.authorization                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class UserTest {
    @Test
    public void add(){
        User u1 = new User("a","a");
        User u2 = new User("a","a");
        Assert.assertTrue(User.add(u1));
        Assert.assertFalse(User.add(u1));
    }

    @Test
    public void addtthesame(){
        User u1 = new User("b","b");
        User u2 = new User("b","b");
        Assert.assertTrue(User.add(u1));
        Assert.assertFalse(User.add(u2));
    }

    @Test public void eq(){
        User u1 = new User("c","c");
        User u2 = new User("c","c");
        User u3 = new User("cc","cc");
        Assert.assertTrue(u1.equals(u1));
        Assert.assertTrue(u1.equals(u2));
        Assert.assertFalse(u1.equals(u3));
        Assert.assertFalse(u1.equals(null));
    }

    @Test public void geter(){
        User u = new User();
        User u1 = new User("d","f");
        Assert.assertEquals("d",u1.getUserName());
        Assert.assertEquals("f",u1.getPassword());
    }
}
