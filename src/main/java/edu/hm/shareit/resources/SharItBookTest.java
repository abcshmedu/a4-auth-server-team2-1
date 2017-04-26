package edu.hm.shareit.resources;


import edu.hm.shareit.resources.SharItBook;
import org.junit.Test;
import org.junit.Assert;
/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 21.04.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * PACKAGE_NAME                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class SharItBookTest {

    @Test public void BookExist(){
        SharItBook b = new SharItBook("a","a","a");
        SharItBook c = new SharItBook("a","a","a");

        Assert.assertTrue(!SharItBook.exist(b));
        Assert.assertTrue(!SharItBook.exist(c));
        SharItBook.addBook(b);
        Assert.assertTrue(SharItBook.exist(b));
        Assert.assertTrue(SharItBook.exist(c));
    }

    @Test public void BookValid(){
        SharItBook v = new SharItBook("a","a","a");
        SharItBook nv1 = new SharItBook("","","");
        SharItBook nv2 = new SharItBook(null,null,null);

        SharItBook nv3 = new SharItBook("","a","a");
        SharItBook nv4 = new SharItBook(null,"a","a");


        Assert.assertTrue(SharItBook.isValid(v));
        Assert.assertTrue(!SharItBook.isValid(nv2));
        Assert.assertTrue(!SharItBook.isValid(nv1));
        Assert.assertTrue(!SharItBook.isValid(nv3));
        Assert.assertTrue(!SharItBook.isValid(nv4));
    }

    @Test public void toJson(){
        SharItBook b = new SharItBook("a","b","c");
        Assert.assertEquals("{\"author\":\"b\",\"isbn\":\"c\",\"title\":\"a\"}",b.toJSON().toString());
    }

    @Test public void geter(){
        SharItBook b = new SharItBook("a","b","c");
        Assert.assertEquals(b.getTitle(),"a");
        Assert.assertEquals(b.getIsbn(),"c");
        Assert.assertEquals(b.getAuthor(),"b");
    }

    @Test public void ToSting(){
        SharItBook b = new SharItBook("a","b","c");
        Assert.assertEquals("Book[ titel: a autor: b  isbn:c ]",b.toString());
    }

    @Test public void delBook(){
        SharItBook b = new SharItBook("a","b","c");
        SharItBook.deleteBook(b);
        SharItBook.addBook(b);
        Assert.assertTrue(SharItBook.exist(b));
        SharItBook.deleteBook(b);
        Assert.assertFalse(SharItBook.exist(b));
    }
}
