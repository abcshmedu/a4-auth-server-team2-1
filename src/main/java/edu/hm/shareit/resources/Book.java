package edu.hm.shareit.resources;

import org.json.JSONObject;

import javax.persistence.*;

/**
 * Created by MatHe on 26.04.2017.
 */

@Entity
public class Book extends Medium {

    public static final int M13 = 13;
    public static final int M3 = 3;
    public static final int M12 = 12;
    public static final int M10 = 10;
    private String author;
    @Id
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
     * @return true if the book is valid.
     */
    public boolean isValid() {
        Book that = this;
        boolean anyNull = that.getAuthor() != null && that.getTitle() != null && that.getIsbn() != null;
        boolean anyEmpty = that.getAuthor() != "" && that.getTitle() != "" && that.getIsbn() != "";
        boolean isbn = checkIsbn(that.getIsbn());
        // test m = ( [a b c d e f g h i j k l] * [1 3 1 3 1 3 1 3 1 3 1 3] ) mod 10
        return anyEmpty && anyNull && isbn;
    }

    /**
     * check isbn.
     * @param isbn i
     * @return b
     */
    public boolean checkIsbn(String isbn) {
            isbn = isbn.replaceAll("-", "");
            if (isbn.length() != M13) {
                return false;
            }
            char[] arr = isbn.toCharArray();
            int[] intArray = new int[M13];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = arr[i] - '0';
            }
            int sum = 0;
            for (int i = 0; i < intArray.length - 1; i += 2) {
                sum += (1) * intArray[i];
                sum += M3 * intArray[i + 1];
            }
            sum = sum + intArray[M12];

            return sum % M10 == 0;
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

    /**
     * SetA.
     * @param a s
     */
    public void setAuthor(String a) {
        author = a;
    }

    /**
     * setISBN.
     * @param i i
     */
    public void setISBN(String i) {
        isbn = i;
    }

}
