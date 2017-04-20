package edu.hm.shareit.resources;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by MatHe on 12.04.2017.
 */
@Path("/media/books")
public class TryClass {


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response doSomthing(Book book){

        System.out.println("Post");
        System.out.println(" Titel: " + book.title + "     Autor: " + book.author + "     ISBN : " + book.isbn);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("detail","it_worked");
        return Response.status(200).entity(jsonObject.toString()).build();
    }


    @GET
    @Produces("application/json")
    public Response doElse(){
        System.out.println("GET");
        JSONObject jsonObject = new JSONObject();
       // jsonObject.put("detail","it_worked");
        Book b = new Book("Lustiges Buch", "ich selber","123456789");
        return Response.status(200).entity(b.toJSON().toString()).build();
    }


}
