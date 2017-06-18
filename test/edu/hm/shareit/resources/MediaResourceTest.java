package edu.hm.shareit.resources;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.hm.Mock.TestModul;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.Token;
import edu.hm.authorization.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 18.06.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.shareit.resources                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class MediaResourceTest {

    String token;
    Book b1,b2,b3;
    Disc d1,d2,d3;
    MediaResource m;


    @Test
    public void dummy(){

        Injector injector = Guice.createInjector(new TestModul());
        m = new MediaResource();
        injector.injectMembers(m);


        User user = new User("1","1");
        User.add(user);
        token = Token.generateToken(user).toString();
        b1 = new Book("1","1","1");
        b2 = new Book("2","2","2");
        b3 = new Book("3","3","3");
        d1 = new Disc("1","1",1,"1");
        d2 = new Disc("2","2",1,"2");
        d3 = new Disc("3","3",1,"3");

        //get Books
        Assert.assertEquals(m.getBooks(token).getStatus(),400);
        Assert.assertEquals(m.getDiscs(token).getStatus(),400);
        // Add Book
        Assert.assertEquals(m.createBook("noTOken",b1).getStatus(),400);
        Assert.assertEquals(m.createBook("token",new Book("12","","")).getStatus(),MediaServiceResult.BAD_REQUEST.getCode());
        Assert.assertEquals(m.createBook(token,b1).getStatus(),MediaServiceResult.OK.getCode());
        Assert.assertEquals(m.createBook(token,b1).getStatus(),MediaServiceResult.CONFLICT.getCode());

        //Add Disc
        Assert.assertEquals(m.createDisc("noTOken",d1).getStatus(),400);
        Assert.assertEquals(m.createDisc("token",new Disc("12","",1,"")).getStatus(),MediaServiceResult.BAD_REQUEST.getCode());
        Assert.assertEquals(m.createDisc(token,d1).getStatus(),MediaServiceResult.OK.getCode());
        Assert.assertEquals(m.createDisc(token,d1).getStatus(),MediaServiceResult.CONFLICT.getCode());


        // get Book
        Assert.assertEquals(m.getBooks("").getStatus(),400);
        Assert.assertEquals(m.GetSingleBook("","").getStatus(),400);
        Assert.assertEquals(m.getBooks(token).getStatus(),MediaServiceResult.OK.getCode());
        Assert.assertEquals(m.GetSingleBook("",token).getStatus(),MediaServiceResult.BAD_REQUEST.getCode());
        Assert.assertEquals(m.GetSingleBook(b1.getIsbn(),token).getStatus(),MediaServiceResult.OK.getCode());


        // get Disc
        Assert.assertEquals(m.getDiscs("").getStatus(),400);
        Assert.assertEquals(m.getDiscs(token).getStatus(),MediaServiceResult.OK.getCode());
        Assert.assertEquals(m.GetSingleDisc("","").getStatus(),400);
        Assert.assertEquals(m.GetSingleDisc("",token).getStatus(),MediaServiceResult.BAD_REQUEST.getCode());
        Assert.assertEquals(m.GetSingleDisc(d1.getBarcode(),token).getStatus(),MediaServiceResult.OK.getCode());


        // update
        Book b = new Book("","2","");
        Assert.assertEquals(m.updateBook("","",null).getStatus(),400);
        Assert.assertEquals(m.updateBook(b1.getIsbn(),token,b).getStatus(),MediaServiceResult.BAD_REQUEST.getCode());
        b = new Book("bX","","");
        Assert.assertEquals(m.updateBook(b1.getIsbn(),token,b).getStatus(),MediaServiceResult.OK.getCode());

        Disc d = new Disc("","2",2,"");
        Assert.assertEquals(m.updateDisc("","",null).getStatus(),400);
        Assert.assertEquals(m.updateDisc(d1.getBarcode(),token,d).getStatus(),MediaServiceResult.BAD_REQUEST.getCode());
        d = new Disc("bX","",1,"");
        Assert.assertEquals(m.updateDisc(d1.getBarcode(),token,d).getStatus(),MediaServiceResult.OK.getCode());



        MediaServiceImpl imp = new MediaServiceImpl();

        Medium[] m = imp.getAllBooks();
        boolean bool = m[0].equals(b1) |m[1].equals(b2) |m[2].equals(b3);
        Assert.assertTrue(bool);
        m = imp.getAllDisc();

        bool = m[0].equals(d1) |m[1].equals(d2) |m[2].equals(d3);
        Assert.assertTrue(bool);

        imp.update(b2);
        imp.update(d2);

        Assert.assertEquals(imp.getBook(b1.getIsbn()),b1);
        Assert.assertEquals(imp.getBook(d1.getBarcode()),d1);

    }

}
