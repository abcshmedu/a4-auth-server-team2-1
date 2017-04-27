package edu.hm.shareit.resources;

/**
 * Created by MatHe on 26.04.2017.
 */
public interface MediaService {


    /**
     *
     * @param book
     * @return
     */
    MediaServiceResult addBook(Book book);

    /**
     *
     * @param disc
     * @return
     */
    MediaServiceResult addDisk(Disc disc);

    /**
     *
     * @return
     */
    Medium[] getBooks();

    /**
     *
     * @return
     */
    Medium[] getDiscs();

    /**
     *
     * @param book
     * @return
     */
    MediaServiceResult updateBook(Book book);

    /**
     *
     * @param disc
     * @return
     */
    MediaServiceResult updateDisc(Disc disc);


}
