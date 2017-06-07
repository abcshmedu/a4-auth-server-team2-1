package edu.hm.shareit.resources;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MatHe on 31.05.2017.
 */
public class IsbnTest {
    @Test
    public void firstCheck(){
        Book.checkIsbn("1234567890");
    }


    @Test
    public void secondCheck(){
        boolean bool;
        bool = Book.checkIsbn("978-3-12-732320-7");
        Assert.assertTrue(bool);
    }

    @Test
    public void firstFailCheck(){
        boolean bool;
        bool = Book.checkIsbn("978-3-12-732320-6");
        Assert.assertFalse(bool);
    }
    @Test
    public void secondFailCheck(){
        boolean bool;
        bool = Book.checkIsbn("12-732320-6");
        Assert.assertFalse(bool);
    }
    @Test
    public void thirdFailCheck(){
        boolean bool;
        bool = Book.checkIsbn("9783127323206");
        Assert.assertFalse(bool);
    }
}
