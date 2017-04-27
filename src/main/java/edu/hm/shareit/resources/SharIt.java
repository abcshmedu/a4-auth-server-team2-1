package edu.hm.shareit.resources;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;

import javax.ws.rs.core.Response;

import java.util.Iterator;


/**
 * Created by MatHe on 12.04.2017.
 */
//@Path("/media/books")
public class SharIt {


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response HttpPost(SharItBook that){
        int returnCode = 200;
        JSONObject jsonObject = new JSONObject();
        // System.out.println("Post");
       //System.out.println(" json Post : Titel: " + that.title + "     Autor: " + that.author + "     ISBN : " + that.isbn);
        // es gibt das buch noch nicht
        if(SharItBook.isValid(that)) {
            if (!SharItBook.exist(that)) {
                SharItBook.addBook(that);
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
    }


    @GET
    @Produces("application/json")

    public Response HttpGet(){
        int returnCode = 200;
        //  System.out.println("GET");
        JSONObject jsonObject = new JSONObject();
        Iterator<SharItBook> allBooks = SharItBook.getAllBooks();
        JSONArray array = new JSONArray();
        if(!allBooks.hasNext()) {

            jsonObject.put("detail", "Es gibt noch keine Bücher!");
            array.put(jsonObject);
            returnCode = 400;
            jsonObject.put("code",returnCode);
        }
        else{
            while(allBooks.hasNext()){
                SharItBook t = allBooks.next();

                array.put(t.toJSON());
            //    System.out.println("add to respond : " + t.title); // test
            }
            jsonObject.put("",array);
        }

       //System.out.println("respond : " + jsonObject.toString());
        return Response.status(returnCode).entity( array.toString()).build();
    }


}
