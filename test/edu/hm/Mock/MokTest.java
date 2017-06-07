package edu.hm.Mock;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.hm.shareit.resources.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
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
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaService.class);
        // Hole eine bestimmte Variable aus dem Inktor raus
        Set mock = injector.getInstance(Set.class);
        when(mock.contains(b)).thenReturn(true);
        when(b.isValid()).thenReturn(true);
        Assert.assertEquals(mediaService.addBook(b),MediaServiceResult.OK);

        when(mock.contains(b)).thenReturn(false);
        Assert.assertEquals(mediaService.addBook(b),MediaServiceResult.CONFLICT);
    }
    @Test public void addDisk1(){
        Disc b = mock(Disc.class);
        when(b.isValid()).thenReturn(false);
        Assert.assertEquals(mediaService.addDisk(b),MediaServiceResult.BAD_REQUEST);
    }
    @Test public void addDisk2(){
        Disc b = mock(Disc.class);
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaService.class);
        // Hole eine bestimmte Variable aus dem Inktor raus
        Set mock = injector.getInstance(Set.class);
        when(mock.contains(b)).thenReturn(true);
        when(b.isValid()).thenReturn(true);
        Assert.assertEquals(mediaService.addDisk(b),MediaServiceResult.OK);

        when(mock.contains(b)).thenReturn(false);
        Assert.assertEquals(mediaService.addDisk(b),MediaServiceResult.CONFLICT);
    }

    @Test public void getBooks1(){
        Iterator<Book> i = new Iterator<Book>() {
            @Override
            public boolean hasNext() {
                return true;
            }
            Book[] b = new Book[]{new Book("1","1","1"),new Book("2","2","2")};
            int c = -1;
            @Override
            public Book next() {
                c++;
                return b[c];
            }
        };
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaServiceImpl.class);
        // Hole eine bestimmte Variable aus dem Inktor raus
        Set mock = injector.getInstance(Set.class);
        when(mock.size()).thenReturn(2);
        //TODO wird nicht weder iterator noch metheo wird indeziert
        when(mock.iterator()).thenReturn(i);
        mediaService.getDiscs();
    }
}
