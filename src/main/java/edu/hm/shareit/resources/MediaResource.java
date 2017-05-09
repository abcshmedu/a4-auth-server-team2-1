package edu.hm.shareit.resources;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 26.04.2017.
 */
@Path("/media")
public class MediaResource {


    private MediaService mediaService = new MediaServiceImpl();

    /**
     * Default Ctor.
     */
    public MediaResource() {
        //mediaService = new MediaServiceImpl();
    }

    public MediaResource(MediaService service){
        this.mediaService = service;
    }

    /**
     * Creates Book.
     * @param book book to create.
     * @return Response if book was successfully created.
     */
    @POST
    @Path("/books")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createBook(Book book) {

        MediaServiceResult result =  mediaService.addBook(book);
        JSONObject jsonObject = new JSONObject();
        if (result == MediaServiceResult.OK) {
            jsonObject.put("code", result.getCode());
            jsonObject.put("detail", "Neues Buch wurde hinzugefügt");
        }
        else if (result == MediaServiceResult.BAD_REQUEST) {
            jsonObject.put("code", result.getCode());
            jsonObject.put("detail", "Ungültige Eingabe");
        }
        else  if (result == MediaServiceResult.CONFLICT) {
            jsonObject.put("code", result.getCode());
            jsonObject.put("detail", "Es gibt dieses Buch schon.");
        }

        return Response.status(result.getCode()).entity(jsonObject.toString()).build();

    }



    /**
     * Gets all the books.
     * @return Response of all books in JSON.
     */
    @GET
    @Path("/books")
    @Produces("application/json")
    public Response getBooks() {
        //Todo check if books there?


        Medium[] result = mediaService.getBooks();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int returnCode = MediaServiceResult.OK.getCode();
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                jsonArray.put(((Book)result[i]).toJSON());
            }
        }
        else {
            returnCode = MediaServiceResult.BAD_REQUEST.getCode();
            jsonObject.put("detail", "Es gibt noch keine Bücher!");
            return Response.status(returnCode).entity(jsonObject.toString()).build();
        }
        jsonObject.put("", jsonArray);

        return Response.status(returnCode).entity(jsonArray.toString()).build();
        //Todo result -> JSON -> Response
    }

    /**
     * Not jet implemented.
     * @return not jet implemented.
     */
    public Response updateBook() {
        return null;
    }





}
