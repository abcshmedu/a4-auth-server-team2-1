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
        System.out.println(" post Data titel :" + book.title + "     Autor " + book.author + "     isbn " + book.isbn);

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
        jsonObject.put("title","spanendes_Buch");
        jsonObject.put("author","ich");
        jsonObject.put("isbn",123);


        return Response.status(200).entity(jsonObject.toString()).build();
    }


}
