package edu.hm.shareit.resources;

/**
 * Created by MatHe on 26.04.2017.
 */
public interface MediaService {


    /**
     * Adds book.
     * @param book book to add.
     * @return result of the operation.
     */
    MediaServiceResult addBook(Book book);

    /**
     * Adds disc.
     * @param disc disc to add.
     * @return result of the operation.
     */
    MediaServiceResult addDisk(Disc disc);

    /**
     * Gets all the books.
     * @return array of the books as medium.
     */
    Medium[] getBooks();

    /**
     * Gets all the discs.
     * @return array of the discs as medium.
     */
    Medium[] getDiscs();

    /**
     * not jet implemented.
     * @param book not jet implemented.
     * @return not jet implemented.
     */
    MediaServiceResult updateBook(String isbn,Book book);

    /**
     * not jet implemented.
     * @param disc not jet implemented.
     * @return not jet implemented.
     */
    MediaServiceResult updateDisc(Disc disc);


}
