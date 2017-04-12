package edu.hm.shareit.resources;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Produces("application/json")
    public Response doSomthing(){

        System.out.println("wrkt");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("detail","it_worked");

        return Response.status(501).entity(jsonObject).build();
    }


    @GET
    @Produces("application/json")
    public Response doElse(){
        System.out.printf("GETTTT");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("detail","it_worked");

        return Response.status(501).entity(jsonObject).build();
    }


}
