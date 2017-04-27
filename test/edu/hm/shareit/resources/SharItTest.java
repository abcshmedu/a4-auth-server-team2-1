package edu.hm.shareit.resources;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 25.04.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.shareit.resources                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class SharItTest {

    static SharIt s;
    static SharItBook b1 = new SharItBook("a","a","a");
    static SharItBook b2 = new SharItBook("c","c","c");
    static SharItBook b3 = new SharItBook("c","c",null);

    @Before public void init(){
        s = new SharIt();
        SharItBook.delAllBooks();
    }

    @Test
    public  void post1(){
        Response r = s.HttpPost(b1);
        Assert.assertTrue(SharItBook.exist(b1));
        Assert.assertEquals(200, r.getStatus());
        r = s.HttpPost(b1);
        Assert.assertEquals(400,r.getStatus());


    }

    @Test
    public  void post2(){
        Response r = s.HttpPost(b3);
        Assert.assertTrue(!SharItBook.exist(b3));
        Assert.assertEquals(400, r.getStatus());


    }


    @Test public void Get1(){
        Response r = s.HttpGet();
        Assert.assertEquals(r.getStatus(),400);
    }

    @Test public void Get2(){
        s.HttpPost(b1);
        Response r = s.HttpGet();
        Assert.assertEquals(r.getStatus(),200);
        System.out.println(r.getEntity());
    }



}
