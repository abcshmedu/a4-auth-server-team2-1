package edu.hm;

import edu.hm.shareit.resources.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;


/**
 * Created by lapi on 01/06/2017.
 */
public class MokTest {
    Book bookMock;
    @Before public void init(){
        bookMock = mock(Book.class);
    }
    @Test
    public void test(){
        when(bookMock.getAuthor()).thenReturn("peter");
        Assert.assertTrue(bookMock.getAuthor().equals("peter"));
    }
}
