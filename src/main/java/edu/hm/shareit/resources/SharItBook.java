package edu.hm.shareit.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * *****************************************************************
 * Hochschule Muenchen Fakultaet 07 (Informatik)		**
 * Praktikum fuer Softwareentwicklung 1 IF1B  WS15/16	**
 * *****************************************************************
 * Autor: Sebastian Balz					**
 * Datum 12.04.2017											**
 * Software Win 7 JDK8 Win 10 JDK8 Ubuntu 15.4 OpenJDK7	**
 * edu.hm.shareit.resources                **
 * *****************************************************************
 * **
 * *****************************************************************
 */
public class Book {
    static Set<Book> bookList = new HashSet<>();
    String author;
    String isbn;
    String title;

    /**
     * für den JSON to OBJ parser
     * @param a autor
     * @param i isbn
     * @param t titel
     */
    @JsonCreator
    public Book(@JsonProperty("title") String t,@JsonProperty("author") String a,@JsonProperty("isbn") String i ){
        author = a;
        isbn = i;
        title =t;
    }

    JSONObject toJSON(){
        return new JSONObject()
        .put("author",author)
                .put("isbn",isbn)
                .put("title",title);
    }

    /**
     * fügt ein buch zu liste der eingetragenen bücher hinzu
     * @param that book to add
     */
    static public void addBook(Book that ){
        bookList.add(that);
    }

    /**
     * löscht ein buch aus der Liste der vorhandenen Bücker
     * @param that delete book
     */
    static public void deleteBook(Book that){
        bookList.remove(that);
    }

    /**
     * überprüft ob es dieses buch bereits gibt
     * @param that  add book
     * @return  exist?
     */
    static public  boolean exist(Book that){
        return bookList.contains(that);
    }

    /**
     * überprüft, ob ein bucheintrag gültig ist.
     * dafür müssen alle alle inträge != null sein
     * @param that  buch
     * @return isVaild
     */
    static boolean isValid(Book that){
        boolean anyNull = that.author != null && that.title != null && that.isbn != null;
        boolean anyEmpty = that.author != "" && that.title != "" && that.isbn != "";
        return anyEmpty && anyNull;
    }

    static Iterator<Book> getAllBooks(){
        return bookList.iterator();
    }

}
