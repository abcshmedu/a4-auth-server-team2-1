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
        User u1 = new User("UserTesta","UserTesta");
        User u2 = new User("UserTest","UserTesta");
        Assert.assertTrue(User.add(u1));
        Assert.assertFalse(User.add(u1));
    }

    @Test
    public void addtthesame(){
        User u1 = new User("UserTestb","UserTestb");
        User u2 = new User("UserTestb","UserTestb");
        Assert.assertTrue(User.add(u1));
        Assert.assertFalse(User.add(u2));
    }

    @Test public void eq(){
        User u1 = new User("UserTestc","UserTestc");
        User u2 = new User("UserTestc","UserTestc");
        User u3 = new User("UserTestcc","UserTestcc");
        Assert.assertTrue(u1.equals(u1));
        Assert.assertTrue(u1.equals(u2));
        Assert.assertFalse(u1.equals(u3));
        Assert.assertFalse(u1.equals(null));
    }

    @Test public void geter(){
        User u = new User();
        User u1 = new User("UserTestd","UserTestf");
        Assert.assertEquals("UserTestd",u1.getUserName());
        Assert.assertEquals("UserTestf",u1.getPassword());
    }
}
