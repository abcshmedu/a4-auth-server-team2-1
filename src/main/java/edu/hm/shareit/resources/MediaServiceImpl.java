package edu.hm.shareit.resources;


import com.google.inject.Inject;

import java.util.*;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaServiceImpl implements MediaService {

    @Inject
    private  Set<Book> bookSet;
    @Inject
    private  Set<Disc> discSet;

    /**
     * Default Ctor.
     */
    public MediaServiceImpl() {


    }


    public MediaServiceImpl(boolean reset) {
        if (reset)
            bookSet =  new HashSet<>();
    }


    @Override
    public MediaServiceResult addBook(Book book) {
        MediaServiceResult out = MediaServiceResult.OK;
        if (book.isValid()) {
            if (!existBook(book)) {
                bookSet.add(book);
            }
            else {
                out = MediaServiceResult.CONFLICT;
            }
        }
        else {
            out = MediaServiceResult.BAD_REQUEST;
        }
        return out;

    }

    @Override
    public MediaServiceResult addDisk(Disc disc) {
        MediaServiceResult out = MediaServiceResult.OK;
        if (disc.isValid()) {
            if (!existDisc(disc)) {
                discSet.add(disc);
            }
            else {
                out = MediaServiceResult.CONFLICT;
            }
        }
        else {
            out = MediaServiceResult.BAD_REQUEST;
        }
        return out;
    }

    @Override
    public Medium[] getBooks() {
        Medium[] out = new Medium[bookSet.size()];
        Iterator<Book> i = bookSet.iterator();
        for (int a = 0; a < bookSet.size(); a++) {


            out[a] = i.next();
        }

        return out;
    }

    @Override
    public Medium[] getDiscs() {
        int s = discSet.size();
        Medium[] out = new Medium[s];
        Iterator<Disc> i = discSet.iterator();
        for (int a = 0; a < discSet.size(); a++) {
            out[a] = i.next();
        }

        return out;
    }

    /**
     * update the book with one specific isbn
     * and change all other values
     * @param book isbn shall not ne null
     * @return
     */
    @Override
    public MediaServiceResult updateBook(String isbn,Book book) {
        Iterator<Book>i =  bookSet.iterator();
        while (i.hasNext()){
            Book b = i.next();
            if(b.getIsbn().equals(isbn)){
                if(book.getIsbn() != null && !book.getIsbn().equals(""))
                    return MediaServiceResult.BAD_REQUEST;
                if(book.getAuthor() != null && !book.getAuthor().equals(""))
                    b.setAuthor(book.getAuthor());
                if(book.getTitle() != null && !book.getTitle().equals(""))
                    b.setTitle(book.getTitle());
                return MediaServiceResult.OK;
            }
        }
        return MediaServiceResult.BAD_REQUEST;
    }

    @Override
    public MediaServiceResult updateDisc(String barcode, Disc disc) {
        Iterator<Disc>i =  discSet.iterator();
        while (i.hasNext()){
            Disc b = i.next();
            if(b.getBarcode().equals(barcode)){
                if(disc.getBarcode() == null || disc.getBarcode().equals(""))
                    return MediaServiceResult.BAD_REQUEST;
                if(disc.getDirector() != null && !disc.getDirector().equals(""))
                    b.setDirector(disc.getDirector());
                if(disc.getFsk() >0)
                    b.setFsk(disc.getFsk());
                if(disc.getTitle() != null && !disc.getTitle().equals(""))
                    b.setTitle(disc.getTitle());
                return MediaServiceResult.OK;
            }
        }
        return MediaServiceResult.BAD_REQUEST;
    }


    /**
     * Checks if a book exists.
     * @param that book to check.
     * @return true if the book exists.
     */
    public  boolean existBook(Book that) {

        return bookSet.contains(that);
    }

    /**
     * Checks if a disc exists.
     * @param that disc to check.
     * @return true if the disc exists.
     */
    public  boolean existDisc(Disc that) {

        return discSet.contains(that);
    }
}
