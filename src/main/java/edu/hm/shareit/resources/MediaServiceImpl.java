package edu.hm.shareit.resources;

import edu.hm.persistierung.MediumPersist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaServiceImpl implements MediaService {

    //@Inject
    private  Set<Book> bookSet = new HashSet<>();
    //@Inject
    private  Set<Disc> discSet = new HashSet<>();

    private MediumPersist persist = new MediumPersist();

    /**
     * Default Ctor.
     */
    public MediaServiceImpl() {


    }


    /**
     * KOnst. Depricated.
     * @param reset true
     */
    public MediaServiceImpl(boolean reset) {
        if (reset) {
            bookSet = new HashSet<>();
        }
    }


    @Override
    public MediaServiceResult addBook(Book book) {


        MediaServiceResult out = MediaServiceResult.OK;
        if (book.isValid()) {
            if (!persist.existBook(book.getIsbn())) {
                persist.add(book);
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
            if (!persist.existDisc(disc.getBarcode())) {
                persist.add(disc);
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

    //TODO
    @Override
    public Medium[] getBooks() {

        return persist.getAllBooks();
    }

    @Override
    public Medium[] getDiscs() {
       return persist.getAllDisc();
    }

    /**
     * update the book with one specific isbn.
     * and change all other values
     * @param book isbn shall not ne null
     * @return
     */
    @Override
    public MediaServiceResult updateBook(String isbn, Book book) {
        Iterator<Book> i = bookSet.iterator();
        if (persist.existBook(isbn)) {
            Book b = persist.getBook(isbn);
                if (book.getIsbn() != null && !book.getIsbn().equals("")) {
                    return MediaServiceResult.BAD_REQUEST;
                }
                if (book.getAuthor() != null && !book.getAuthor().equals("")) {
                    b.setAuthor(book.getAuthor());
                }
                if (book.getTitle() != null && !book.getTitle().equals("")) {
                    b.setTitle(book.getTitle());
                }
            persist.update(b);
                return MediaServiceResult.OK;

            }
            return MediaServiceResult.BAD_REQUEST;
        }

    @Override
    public MediaServiceResult updateDisc(String barcode, Disc disc) {
        Iterator<Disc>i =  discSet.iterator();
      if (persist.existDisc(barcode)) {
            Disc b = persist.getDisc(barcode);
            if (b.getBarcode().equals(barcode)) {
                if (disc.getBarcode() == null || disc.getBarcode().equals("")) {
                    return MediaServiceResult.BAD_REQUEST;
                }
                if (disc.getDirector() != null && !disc.getDirector().equals("")) {
                    b.setDirector(disc.getDirector());
                }
                if (disc.getFsk() > 0) {
                    b.setFsk(disc.getFsk());
                }
                if (disc.getTitle() != null && !disc.getTitle().equals("")) {
                    b.setTitle(disc.getTitle());
                }
                persist.update(b);
                return MediaServiceResult.OK;
            }
        }
        return MediaServiceResult.BAD_REQUEST;
    }



}
