package edu.hm.shareit.resources;

import org.json.JSONObject;

/**
 * Created by MatHe on 26.04.2017.
 */
public class Book extends Medium {

    private String author;
    private String isbn;

    /**
     * Default Ctor.
     */
    public Book() {
        super("");
    }

    /**
     * Constructor.
     * @param title title of the book.
     * @param isbn isbn of the book.
     * @param author author of the book.
     */
    public Book(String title, String isbn, String author) {
        super(title);
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Getter.
     * @return author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter.
     * @return isbn.
     */
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{"
                + "author='" + author + '\''
                + ", isbn='" + isbn + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Book book = (Book) o;
        if (author != null ? !author.equals(book.author) : book.author != null) {
            return false;
        }
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }

    /**
     * Check if book is valid.
     * @param that book to check.
     * @return true if the book is valid.
     */
    public static boolean isValid(Book that) {
        boolean anyNull = that.getAuthor() != null && that.getTitle() != null && that.getIsbn() != null;
        boolean anyEmpty = that.getAuthor() != "" && that.getTitle() != "" && that.getIsbn() != "";
        return anyEmpty && anyNull;
    }

    /**
     * Converts to JSON.
     * @return json Object of the Book.
     */
    public JSONObject toJSON() {
        return new JSONObject()
                .put("author", author)
                .put("isbn", isbn)
                .put("title", this.getTitle());
    }

}
