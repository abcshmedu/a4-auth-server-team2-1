package edu.hm.shareit.resources;

import java.util.HashMap;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaServiceImpl implements MediaService {

    HashMap<String, Book> storage = new HashMap<>();

    @Override
    public MediaServiceResult addBook(Book book) {
        //Todo save Books check isbn here, create MediaServiceResult

        return null;
    }

    @Override
    public MediaServiceResult addDisk(Disc disc) {
        return null;
    }

    @Override
    public Medium[] getBooks() {
        //Todo get Books, create array;
        return new Medium[0];
    }

    @Override
    public Medium[] getDiscs() {
        return new Medium[0];
    }

    @Override
    public MediaServiceResult updateBook(Book book) {
        return null;
    }

    @Override
    public MediaServiceResult updateDisc(Disc disc) {
        return null;
    }
}
