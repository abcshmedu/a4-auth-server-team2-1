package edu.hm.shareit.resources;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by MatHe on 28.05.2017.
 */
public class MediumTest {

    @Test
    public void someTest(){
        Medium book = new Book();
        Medium disc = new Disc();
        Assert.assertFalse(book.equals(disc));
        Medium something = new Medium("titel") {
            @Override
            public String getTitle() {
                return super.getTitle();
            }
        };
        Assert.assertEquals("Medium, title: titel", something.toString());
    }
}
