package edu.hm.Mock;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.hm.shareit.resources.Book;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;
import edu.hm.shareit.resources.MediaServiceResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;


/**
 * Created by lapi on 01/06/2017.
 */
public class MokTest {
    Book bookMock;
    MediaService mediaService = new MediaServiceImpl();
    @Before public void init(){
        bookMock = mock(Book.class);
    }
    @Test
    public void test(){
        when(bookMock.getAuthor()).thenReturn("peter");
        Assert.assertTrue(bookMock.getAuthor().equals("peter"));
    }

    @Test public void addBook1(){
        Book b = mock(Book.class);
        when(b.isValid()).thenReturn(false);
        Assert.assertEquals(mediaService.addBook(b),MediaServiceResult.BAD_REQUEST);
    }
    @Test public void addBook2(){
        Book b = mock(Book.class);
        Set<Book> l = new HashSet<>();
        Set<Book> mockSet;
        Injector injector = Guice.createInjector(new TestModul());
        mediaService = injector.getInstance(MediaService.class);
        Set mock = injector.getInstance(Set.class);
        when(mock.contains(b)).thenReturn(true);
        when(b.isValid()).thenReturn(true);
        Assert.assertEquals(mediaService.addBook(b),MediaServiceResult.OK);

        when(mock.contains(b)).thenReturn(false);
        Assert.assertEquals(mediaService.addBook(b),MediaServiceResult.CONFLICT);
    }
}
