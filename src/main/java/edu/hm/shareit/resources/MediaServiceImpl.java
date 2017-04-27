package edu.hm.shareit.resources;

import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaServiceImpl implements MediaService {

    HashMap<String, Book> storage = new HashMap<>();

    @Override
    public MediaServiceResult addBook(Book book) {

        int returnCode = 200;
        JSONObject jsonObject = new JSONObject();
        // System.out.println("Post");
        //System.out.println(" json Post : Titel: " + that.title + "     Autor: " + that.author + "     ISBN : " + that.isbn);
        // es gibt das buch noch nicht
        if(SharItBook.isValid(book)) {
            if (!SharItBook.exist(book)) {
                SharItBook.addBook(book);
                returnCode = 200;
                jsonObject.put("code",returnCode);
                jsonObject.put("detail", "neues Buch wurde hinzugefügt");
                System.out.println(" add book");
            } else { // das buch gibt es schon
                returnCode = 400;
                //System.out.println("das buch  " + that +" gibt es schon");
                jsonObject.put("code",returnCode);
                jsonObject.put("detail", "Es gibt dieses Buch schon.");
                System.out.println("book exists");
            }
        }
        else {
            returnCode = 400;
            jsonObject.put("code",returnCode);
            jsonObject.put("detail", "Ungültige Eingabe");
            System.out.println("ungültige Eingabe");
        }


        return Response.status(returnCode).entity(jsonObject.toString()).build();
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
