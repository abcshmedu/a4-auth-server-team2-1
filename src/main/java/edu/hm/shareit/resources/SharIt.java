package edu.hm.shareit.resources;

import org.json.JSONObject;

import javax.ws.rs.*;

import javax.ws.rs.core.Response;

import java.util.Iterator;


/**
 * Created by MatHe on 12.04.2017.
 */
@Path("/media/books")
public class SharIt {


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response doSomthing(SharItBook that){
        int returnCode = 200;
        JSONObject jsonObject = new JSONObject();
        // System.out.println("Post");
        System.out.println(" Titel: " + that.title + "     Autor: " + that.author + "     ISBN : " + that.isbn);
        // es gibt das buch noch nicht
        if(SharItBook.isValid(that)) {
            if (!SharItBook.exist(that)) {
                SharItBook.addBook(that);
                returnCode = 202;
                //jsonObject.put("detail", "neues buch wurde hinzu gefügt");
                System.out.println(" add book");
            } else { // das buch gibt es schon
                returnCode = 226;
                System.out.println("das buch  " + that +" gibt es schon");
                jsonObject.put("detail", "es gibt dieses Buch schon");
                //System.out.println("book exists");
            }
        }
        else {
            returnCode = 400;
            jsonObject.put("detail", "Ungültige eingabe");
            System.out.println("ungültige eingabe");
        }

        return Response.status(returnCode).entity(jsonObject.toString()).build();
    }


    @GET
    @Produces("application/json")
    public Response doElse(){
        //  System.out.println("GET");
        JSONObject jsonObject = new JSONObject();
        Iterator<SharItBook> allBooks = SharItBook.getAllBooks();

        if(!allBooks.hasNext())
            jsonObject.put("detail","Es gibt noch keine bücker");
        else{
            while(allBooks.hasNext()){
                SharItBook t = allBooks.next();
                jsonObject.accumulate("books",t.toJSON()); // add to respond
                System.out.println("add to respond : " + t.title); // test
            }

        }

        System.out.println("respond : " + jsonObject.toString());
        return Response.status(200).entity( jsonObject.toString()).build();
    }


}
/*
 if(!allBooks.hasNext())
            jsonObject.put("detail","Es gibt noch keine bücker");
        else{
            while(allBooks.hasNext()){
                SharItBook t = allBooks.next();
                jsonObject.accumulate("books",t.toJSON()); // add to respond
                System.out.println("add to respond : " + t.title); // test
            }

        }
 */