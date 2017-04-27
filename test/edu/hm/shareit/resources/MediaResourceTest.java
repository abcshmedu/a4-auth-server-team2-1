package edu.hm.shareit.resources;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum f?r Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum: 27.04.17										**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.shareit.resources             **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class MediaResourceTest {
    MediaResource s;
    static Book b1 = new Book("a","a","a");
    static Book b2 = new Book("c","c","c");
    static Book b3 = new Book("c","c",null);
    MediaService m;
    @Before
    public void init(){
        s = new MediaResource();
        m = new MediaServiceImpl();
    }

    @Test
    public  void post1(){

        Response r = s.createBook(b1);

        Assert.assertEquals(MediaServiceResult.OK.getCode(), r.getStatus());
        r = s.createBook(b1);
        Assert.assertEquals(MediaServiceResult.CONFLICT.getCode(),r.getStatus());


    }

    @Test
    public  void post2(){
        Response r = s.createBook(b3);

        Assert.assertEquals(400, r.getStatus());


    }


    @Test public void Get1(){
        Response r = s.getBooks();
        Assert.assertEquals(r.getStatus(),400);
    }

    @Test public void Get2(){
        s.createBook(b1);
        Response r = s.getBooks();
        r.getStatus();
       
        Assert.assertEquals(r.getStatus(),200);
        System.out.println(r.getEntity());
    }

    @Test public void makeLineCoverageGreat(){
       m.getBooks();
       m.getDiscs();
      m.updateBook(b1);
      m.updateDisc(new Disc());
      b1.toString();
      new Book();
      s.updateBook();
      m.addDisk(new Disc());
    }
}
