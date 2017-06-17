package edu.hm.Mock;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import edu.hm.shareit.resources.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
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
    @Ignore
    @Test public void addBook2(){
        Book mockBook = mock(Book.class);
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaService.class);
        // Hole eine bestimmte Variable aus dem Inktor raus

        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Book>>() {}));
        when(mockSet.contains(mockBook)).thenReturn(false);
        when(mockBook.isValid()).thenReturn(true);
        Assert.assertEquals(mediaService.addBook(mockBook),MediaServiceResult.OK);
        verify(mockBook).isValid();
        verify(mockSet).contains(mockBook);
        when(mockSet.contains(mockBook)).thenReturn(true);
        Assert.assertEquals(mediaService.addBook(mockBook),MediaServiceResult.CONFLICT);
    }
    @Test public void addDisk1(){
        Disc b = mock(Disc.class);
        when(b.isValid()).thenReturn(false);
        Assert.assertEquals(mediaService.addDisk(b),MediaServiceResult.BAD_REQUEST);
    }
    @Ignore
    @Test public void addDisk2(){
        Disc mockDisc = mock(Disc.class);
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaService.class);
        // Hole eine bestimmte Variable aus dem Inktor raus
        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Disc>>() {}));
        when(mockSet.contains(mockDisc)).thenReturn(false);
        when(mockDisc.isValid()).thenReturn(true);
        Assert.assertEquals(mediaService.addDisk(mockDisc),MediaServiceResult.OK);
        when(mockSet.contains(mockDisc)).thenReturn(true);
        Assert.assertEquals(mediaService.addDisk(mockDisc),MediaServiceResult.CONFLICT);
    }

    @Ignore
    @Test public void getBooks1(){
       Book b =  new Book("1","1","1");
        Iterator<Book> i = new Iterator<Book>() {
            @Override
            public boolean hasNext() {
                return true;
            }
            Book[] bl = new Book[]{b,new Book("2","2","2")};
            int c = -1;
            @Override
            public Book next() {
                c++;
                return bl[c];
            }
        };
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaServiceImpl.class);
        // Hole eine bestimmte Variable aus dem Inktor raus
        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Book>>() {}));
        when(mockSet.size()).thenReturn(2);
        when(mockSet.iterator()).thenReturn(i);
        mediaService.getBooks()[0].equals(b);
    }

    @Ignore
    @Test public void getDisc(){
        Disc d = new Disc("1","",1,"1");
        Iterator<Disc> i = new Iterator<Disc>() {
            @Override
            public boolean hasNext() {
                return true;
            }
            Disc[] b = new Disc[]{d,new Disc("2","",2,"2")};
            int c = -1;
            @Override
            public Disc next() {
                c++;
                return b[c];
            }
        };
        // Erzeuge ein Injektor mit den Definierten Bindings
        Injector injector = Guice.createInjector(new TestModul());
        // Erzeuge ein Obj mit den vom Injktor erstellen Variablen
        mediaService = injector.getInstance(MediaServiceImpl.class);
        // Hole eine bestimmte Variable aus dem Inktor raus
        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Disc>>() {}));
        when(mockSet.size()).thenReturn(2);
        when(mockSet.iterator()).thenReturn(i);
        mediaService.getDiscs()[0].equals(d);

    }

    @Ignore
    @Test public void updateBook1(){
        Book mockBook = mock(Book.class);
        Injector injector = Guice.createInjector(new TestModul());
        mediaService = injector.getInstance(MediaService.class);
        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Book>>() {}));

        Book b =  new Book("1","1","1");
        Iterator<Book> i = new Iterator<Book>() {
            @Override
            public boolean hasNext() {
                return false;
            }
            @Override
            public Book next() {
                return null;
            }
        };


        when(mockSet.iterator()).thenReturn(i);
       Assert.assertEquals(mediaService.updateBook("11",mockBook),MediaServiceResult.BAD_REQUEST);
    }
    @Ignore
   @Test public void updateBook2(){
       Iterator<Book> i = mock(Iterator.class);
       Book mockBook = mock(Book.class);
       Injector injector = Guice.createInjector(new TestModul());
       mediaService = injector.getInstance(MediaService.class);
       Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Book>>() {}));
        Book b = new Book("1","123","1");
       when(mockSet.iterator()).thenReturn(i);
       when(i.hasNext()).thenReturn(true);
       when(i.next()).thenReturn(b);
       Assert.assertEquals(mediaService.updateBook("123",mockBook),MediaServiceResult.OK);
   }

   @Ignore
    @Test public void updateDisc(){
        Disc mockBook = mock(Disc.class);
        Injector injector = Guice.createInjector(new TestModul());
        mediaService = injector.getInstance(MediaService.class);
        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Disc>>() {}));

        Disc b =  new Disc("1","1",1,"1");
        Iterator<Disc> i = new Iterator<Disc>() {
            @Override
            public boolean hasNext() {
                return false;
            }
            @Override
            public Disc next() {
                return null;
            }
        };


        when(mockSet.iterator()).thenReturn(i);
        Assert.assertEquals(mediaService.updateDisc("11",mockBook),MediaServiceResult.BAD_REQUEST);
    }

    @Ignore
    @Test public void updateDisc2(){
        Iterator<Disc> i = mock(Iterator.class);
        Disc mockBook = mock(Disc.class);
        Injector injector = Guice.createInjector(new TestModul());
        mediaService = injector.getInstance(MediaService.class);
        Set mockSet = injector.getInstance(Key.get(new TypeLiteral<Set<Disc>>() {}));
        Disc b = new Disc("1","123",1,"1");
        when(mockSet.iterator()).thenReturn(i);
        when(i.hasNext()).thenReturn(true);
        when(i.next()).thenReturn(b);
        when(mockBook.getBarcode()).thenReturn("123");
        Assert.assertEquals(mediaService.updateDisc("123",mockBook),MediaServiceResult.OK);
    }

}
