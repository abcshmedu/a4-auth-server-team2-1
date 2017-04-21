import edu.hm.shareit.resources.SharIt;
import edu.hm.shareit.resources.SharItBook;
import org.junit.Assert;
import org.junit.Test;

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
public class BookTest {

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
}
