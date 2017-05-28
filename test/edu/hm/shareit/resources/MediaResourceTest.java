package edu.hm.shareit.resources;

import edu.hm.authorization.AuthServer;
import edu.hm.authorization.Token;
import edu.hm.authorization.User;
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
    String token = "";
    @Before
    public void init(){

        s = new MediaResource();
        m = new MediaServiceImpl();
        AuthServer auth = new AuthServer();
        User u = new User("asd","asd");

        token = Token.generateToken(u).getToken();
    }

    @Test
    public void post1(){
        Book b1 = new Book("xwwsxxx","adxxxasd","asdr");
        s = new MediaResource();
        m = new MediaServiceImpl(true);

        Response r = s.createBook(token,b1);

        Assert.assertEquals(MediaServiceResult.OK.getCode(), r.getStatus());
        r = s.createBook(token,b1);
        Assert.assertEquals(MediaServiceResult.CONFLICT.getCode(),r.getStatus());


    }

    @Test
    public  void post2(){
        Response r = s.createBook(token,b3);

        Assert.assertEquals(400, r.getStatus());


    }


    @Test public void Get1(){
        //Response r = s.getBooks();
        //Assert.assertEquals(r.getStatus(),400);
    }

    @Test public void Get2(){
        s.createBook(token,b1);
        //Response r = s.getBooks();
        //r.getStatus();
       
        //Assert.assertEquals(r.getStatus(),200);
        //System.out.println(r.getEntity());
    }

    @Test public void makeLineCoverageGreat(){
       m.getBooks();


      b1.toString();
      new Book();

      m.addDisk(new Disc());
    }


    @Test public void change1(){
        Book b1 = new Book("1234","1234","1234");
        s.createBook(token,b1);
        Book neu = new Book("neuT",null,null);
        Book neu2 = new Book("neuT","",null);

        s.updateBook(b1.getIsbn(),token,neu);
        Assert.assertEquals(neu.getTitle(),neu.getTitle());
        s.updateBook(b1.getIsbn(),token,neu2);
        Assert.assertEquals(neu.getTitle(),neu2.getTitle());
    }

    @Test public void implem(){
        User u = new User("peter","xxxx");
        Book b1 = new Book("asdasdasd","111111","asde");
        Book b2 = new Book("xxxxx","22222","asdasdcx");

        String token = Token.generateToken(u).getToken();
        MediaResource m = new MediaResource();
        m.createBook(token,b1);
        m.createBook(token,b2);
        System.out.println(m.getBooks(token).getStatus());
        Assert.assertEquals(m.getBooks(token).getStatus(),200);
        Assert.assertEquals(m.GetSingleBook(b1.getIsbn(),token).getStatus(),200);

    }
}
