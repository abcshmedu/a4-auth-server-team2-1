package edu.hm.shareit.resources;

/**
 * Created by MatHe on 26.04.2017.
 */
public interface MediaService {

    MediaServiceResult addBook(Book book);
    MediaServiceResult addDisk(Disc disc);
    Medium[] getBooks();
    Medium[] getDiscs();
    MediaServiceResult updateBook(Book book);
    MediaServiceResult updateDisc(Disc disc);


}
