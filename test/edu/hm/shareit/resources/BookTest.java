package edu.hm.shareit.resources;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MatHe on 26.04.2017.
 */
public class BookTest {
    //Todo Equals auf false testen.
    @Test
    public void getAuthorTest() throws Exception {

        String author = "author";
        Book book = new Book("titel","isbn",author);
        assertEquals(author,book.getAuthor());
    }

    @Test
    public void getIsbnTest() throws Exception {
        String isbn = "isbn";
        Book book = new Book("titel",isbn,"author");
        assertEquals(isbn,book.getIsbn());

    }

    @Test
    public void toStringTest() throws Exception {
        String result = "Book{author='author', isbn='isbn'}";
        Book book = new Book("titel","isbn","author");
        assertEquals(result,book.toString());
    }

    @Test
    public void equalsTest() throws Exception {
        Book b1 = new Book("titel","isbn","author");
        Book b2 = new Book("titel","isbn","author");
        assertTrue(b1.equals(b2));


    }

    @Test
    public void hashCodeTest() throws Exception {
        Book b1 = new Book("titel","isbn","author");
        b1.hashCode();
        Book b2 = new Book("titel","isbn","author");
        assertEquals(b2.hashCode(),b1.hashCode());

    }

    @Test
    public void BookAsJSON(){
        Book book = new Book("title","isbn","author");

        System.out.printf(book.toJSON().toString());

    }


}