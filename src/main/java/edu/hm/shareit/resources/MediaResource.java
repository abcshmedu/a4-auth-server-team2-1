package edu.hm.shareit.resources;

import edu.hm.authorization.AuthServer;
import edu.hm.authorization.Token;
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
    private AuthServer authServer = new AuthServer();

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
    @Consumes("application/json")
    public Response getBooks(Token token) {
        //Todo check if books there?
        if (authServer.validate(token).getStatus() == 200){
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


        //Todo result -> JSON -> Response
            return Response.status(returnCode).entity(jsonArray.toString()).build();
        }
        return Response.status(400).build();
    }

    @GET
    @Path("/books/{isbn}")
    @Produces("application/json")
    public Response GetSingleBook(@PathParam("isbn") String isbn){
        Medium[] result = mediaService.getBooks();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int returnCode = MediaServiceResult.OK.getCode();
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                if(((Book)result[i]).getIsbn().equals(isbn))
                    return Response.status(MediaServiceResult.OK.getCode()).entity(((Book)result[i]).toJSON().toString()).build();
            }
        }
        return Response.status(MediaServiceResult.BAD_REQUEST.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
    }
    /**
     * Not jet implemented.
     * @return not jet implemented.
     */
    @POST
    @Path("/books/{isbn}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateBook(@PathParam("isbn") String isbn,Token token, Book book) {

        MediaServiceResult r = MediaServiceResult.BAD_REQUEST;
        if(book.getIsbn() != null || !book.getIsbn().equals("")){
                        r = mediaService.updateBook(isbn,book);
            return Response.status(r.getCode()).entity(MediaServiceResult.OK.getStatus()).build();
        }
        else {
            System.out.println("Didnt work");
            return Response.status(r.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
        }
    }

//'''''''''''''''''''''''''''''''''''''''''''''''Discs''''''''''''''''''''''''''''''''''''''''''''''''''''
    /**
     * Creates Book.
     * @param disc book to create.
     * @return Response if book was successfully created.
     */
    @POST
    @Path("/discs")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createDisc(Disc disc) {

        MediaServiceResult result =  mediaService.addDisk(disc);
        JSONObject jsonObject = new JSONObject();
        if (result == MediaServiceResult.OK) {
            jsonObject.put("code", result.getCode());
            jsonObject.put("detail", "Neue Disc wurde hinzugefügt");
        }
        else if (result == MediaServiceResult.BAD_REQUEST) {
            jsonObject.put("code", result.getCode());
            jsonObject.put("detail", "Ungültige Eingabe");
        }
        else  if (result == MediaServiceResult.CONFLICT) {
            jsonObject.put("code", result.getCode());
            jsonObject.put("detail", "Es gibt diese Disc schon.");
        }

        return Response.status(result.getCode()).entity(jsonObject.toString()).build();

    }

    /**
     * Gets all the books.
     * @return Response of all books in JSON.
     */
    @GET
    @Path("/discs")
    @Produces("application/json")
    public Response getDiscs() {
        //Todo check if books there?


        Medium[] result = mediaService.getDiscs();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int returnCode = MediaServiceResult.OK.getCode();
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                jsonArray.put(((Disc)result[i]).toJSON());
            }
        }
        else {
            returnCode = MediaServiceResult.BAD_REQUEST.getCode();
            jsonObject.put("detail", "Es gibt noch keine Discs!");
            return Response.status(returnCode).entity(jsonObject.toString()).build();
        }
        jsonObject.put("", jsonArray);

        return Response.status(returnCode).entity(jsonArray.toString()).build();
        //Todo result -> JSON -> Response
    }

    @GET
    @Path("/discs/{barcode}")
    @Produces("application/json")
    public Response GetSingleDisc(@PathParam("barcode") String barcode){
        Medium[] result = mediaService.getDiscs();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int returnCode = MediaServiceResult.OK.getCode();
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                if(((Disc)result[i]).getBarcode().equals(barcode))
                    return Response.status(MediaServiceResult.OK.getCode()).entity(((Disc)result[i]).toJSON().toString()).build();
            }
        }
        return Response.status(MediaServiceResult.BAD_REQUEST.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
    }
    /**
     * Not jet implemented.
     * @return not jet implemented.
     */
    @POST
    @Path("/discs/{barcode}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateDisc(@PathParam("barcode") String barcode,Disc disc) {



        MediaServiceResult r = MediaServiceResult.BAD_REQUEST;
        if(disc.getBarcode() != null || !disc.getBarcode().equals("")){
            r = mediaService.updateDisc(disc);
            return Response.status(r.getCode()).entity(MediaServiceResult.OK.getStatus()).build();
        }
        else {
            System.out.println("Didnt work");
            return Response.status(r.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
        }
    }





}
