package edu.hm.shareit.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    public Book(@JsonProperty("author") String a,@JsonProperty("isbn") String i,@JsonProperty("title") String t ){
        author = a;
        isbn = i;
        title =t;
    }

}
