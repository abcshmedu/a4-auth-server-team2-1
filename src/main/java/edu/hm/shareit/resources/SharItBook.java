package edu.hm.shareit.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
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
//TODO Book Klasse an die beschreibung anpassen
public class SharItBook extends Medium{
    static Set<SharItBook> bookList = new HashSet<>();

    private String author;
    private String isbn;
    private String title;

    /**
     * für den JSON to OBJ parser
     * @param a autor
     * @param i isbn
     * @param t titel
     */
    @JsonCreator
    public SharItBook(@JsonProperty("title") String t, @JsonProperty("author") String a, @JsonProperty("isbn") String i ){
        super(t);
        author = a;
        isbn = i;
        title =t;
    }

    public JSONObject  toJSON(){
        return new JSONObject()
        .put("author",author)
                .put("isbn",isbn)
                .put("title",title);
    }

    /**
     * fügt ein buch zu liste der eingetragenen bücher hinzu
     * @param that book to add
     */
    static public void addBook(SharItBook that ){
        bookList.add(that);
    }

    /**
     * löscht ein buch aus der Liste der vorhandenen Bücker
     * @param that delete book
     */
    static public void deleteBook(SharItBook that){
        bookList.remove(that);
    }

    /**
     * überprüft ob es dieses buch bereits gibt
     * @param that  add book
     * @return  exist?
     */
    static public  boolean exist(SharItBook that){
        boolean exist = false;
        Iterator<SharItBook> it = SharItBook.getAllBooks();
        while(it.hasNext()){
            SharItBook n = it.next();
           // System.out.println("is " +that +" eq to " + n);
            if(n.equals(that)) {
               // System.out.println("is Eq");
                exist = true;
                break;
            }
        }
        return exist;
    }

    /**
     * überprüft, ob ein bucheintrag gültig ist.
     * dafür müssen alle alle inträge != null sein
     * @param that  buch
     * @return isVaild
     */
     static public boolean isValid(SharItBook that){
        boolean anyNull = that.author != null && that.title != null && that.isbn != null;
        boolean anyEmpty = that.author != "" && that.title != "" && that.isbn != "";
        return anyEmpty && anyNull;
    }

    static Iterator<SharItBook> getAllBooks(){
        return bookList.iterator();
    }

    @Override
    public String toString(){
        return "Book[ titel: " + title + " autor: " +author + "  isbn:" + isbn +" ]";
    }

    @Override
    public boolean equals (Object t){
        if (this==t) {
            return true;
        }
        if(t == null )
             return false;
        if(! (t instanceof SharItBook))
            return false;

        SharItBook that = (SharItBook)t ;
        return isbn.equals(that.isbn) && title.equals(that.title)&& that.author.equals(author);
     }

    public String getAuthor() {
        return author;
    }


    public String getIsbn() {
        return isbn;
    }



    public String getTitle() {
        return title;
    }

    /**
     * Löscht alle Bücher wird für die Test Benötigt
     */
    static public void delAllBooks(){
        bookList = new HashSet<>();
    }



}
