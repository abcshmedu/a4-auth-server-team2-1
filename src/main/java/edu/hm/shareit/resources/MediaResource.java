package edu.hm.shareit.resources;

import edu.hm.authorization.IAuthServer;
import edu.hm.authorization.Token;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 26.04.2017.
 */
@Path("/media")
public class MediaResource  {
    public static final int M400 = 400;

    //Todo check isbn for real and make to only numbers


    @Inject
    private MediaService mediaService; //= Guice.createInjector(new ImplModul()).getInstance(MediaService.class);

    @Inject private IAuthServer authServer; // = ShareitServletContextListener.getInjectorInstance().getInstance(IAuthServer.class);


    //Dieser Ctor wird bei jedem Request benutzt
    /**
     * Default Ctor.
     */
    public MediaResource() {


        //mediaService = new MediaServiceImpl();
    }

    /**
     * konst.
     * @param service s
     * @param authServer a
     */
    public MediaResource(MediaService service, IAuthServer authServer) {
        this.mediaService = service;
        this.authServer = authServer;
    }

    /**
     * Creates Book.
     * @param token t
     * @param book b
     * @return r
     */
    @POST
    @Path("/books")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createBook(@QueryParam("token")String token, Book book) {

        if (Token.isAccesGranted(token)) {
            MediaServiceResult result = mediaService.addBook(book);
            JSONObject jsonObject = new JSONObject();
            if (result == MediaServiceResult.OK) {
                jsonObject.put("code", result.getCode());
                jsonObject.put("detail", "Neues Buch wurde hinzugefügt");
            } else if (result == MediaServiceResult.BAD_REQUEST) {
                jsonObject.put("code", result.getCode());
                jsonObject.put("detail", "Ungültige Eingabe");
            } else if (result == MediaServiceResult.CONFLICT) {
                jsonObject.put("code", result.getCode());
                jsonObject.put("detail", "Es gibt dieses Buch schon.");
            }

            return Response.status(result.getCode()).entity(jsonObject.toString()).build();
        }
        return noToken();
    }

    /**
     * Gets all the books.
     * @param token t
     * @return Response of all books in JSON.
     */
    @GET
    @Path("/books")
    @Produces("application/json")
    //?token=asdfasdfasd
    public Response getBooks(@QueryParam("token")String token) {
        //Todo check if books there?
        //String-> Token
        //Validieren
        if (Token.isAccesGranted(token)) {
        Medium[] result = mediaService.getBooks();
        //HttpRequest für teilbare Microservices
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int returnCode = MediaServiceResult.OK.getCode();
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                jsonArray.put(((Book)result[i]).toJSON());
            }
        }
        else {
            /* old
            returnCode = MediaServiceResult.BAD_REQUEST.getCode();
            jsonObject.put("detail", "Es gibt noch keine Bücher!");
            return Response.status(returnCode).entity(jsonObject.toString()).build();
            */
            returnCode = MediaServiceResult.OK.getCode();

        }
        jsonObject.put("", jsonArray);
            return Response.status(returnCode).entity(jsonArray.toString()).build();
        }
        else {
            return noToken();
        }
    }

    /**
     * get sngle .
     * @param isbn i
     * @param token t
     * @return r
     */
    @GET
    @Path("/books/{isbn}")
    @Produces("application/json")
    public Response getSingleBook(@PathParam("isbn") String isbn, @QueryParam("token") String token) {
        if (Token.isAccesGranted(token)) {

            Medium[] result = mediaService.getBooks();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            int returnCode = MediaServiceResult.OK.getCode();
            if (result.length > 0) {
                for (int i = 0; i < result.length; i++) {
                    if (((Book) result[i]).getIsbn().equals(isbn)) {
                        return Response.status(MediaServiceResult.OK.getCode()).entity(((Book) result[i]).toJSON().toString()).build();
                    }

                }
            }
            return Response.status(MediaServiceResult.BAD_REQUEST.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
        } else {
            return noToken();
        }
    }

    /**
     * update.
     * @param isbn isbn
     * @param token token
     * @param book book
     * @return resop
     */
    @POST
    @Path("/books/{isbn}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateBook(@PathParam("isbn") String isbn, @QueryParam("token")String token, Book book) {

        if (Token.isAccesGranted(token)) {
            MediaServiceResult r = MediaServiceResult.BAD_REQUEST;
            if (book.getIsbn() == null || book.getIsbn().equals("")) {
                r = mediaService.updateBook(isbn, book);
                return Response.status(r.getCode()).entity(MediaServiceResult.OK.getStatus()).build();
            } else {
                System.out.println("Didnt work");
                return Response.status(r.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
            }
        } else {
            return noToken();
        }
    }

//'''''''''''''''''''''''''''''''''''''''''''''''Discs''''''''''''''''''''''''''''''''''''''''''''''''''''

    /**
     * creat.
     * @param token token
     * @param  disc disc
     * @return resp
     */
    @POST
    @Path("/discs")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createDisc(@QueryParam("token")String token, Disc disc) {
        if (Token.isAccesGranted(token)) {

            MediaServiceResult result = mediaService.addDisk(disc);
            JSONObject jsonObject = new JSONObject();
            if (result == MediaServiceResult.OK) {
                jsonObject.put("code", result.getCode());
                jsonObject.put("detail", "Neue Disc wurde hinzugefügt");
            } else if (result == MediaServiceResult.BAD_REQUEST) {
                jsonObject.put("code", result.getCode());
                jsonObject.put("detail", "Ungültige Eingabe");
            } else if (result == MediaServiceResult.CONFLICT) {
                jsonObject.put("code", result.getCode());
                jsonObject.put("detail", "Es gibt diese Disc schon.");
            }

            return Response.status(result.getCode()).entity(jsonObject.toString()).build();

        } else {
            return noToken();
        }
    }

    /**
     * getDIsc.
     * @param token token
     * @return resp.
     */
    @GET
    @Path("/discs")
    @Produces("application/json")
    public Response getDiscs(@QueryParam("token")String token) {
        if (Token.isAccesGranted(token)) {
            Medium[] result = mediaService.getDiscs();
            //HttpRequest für teilbare Microservices
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            int returnCode = MediaServiceResult.OK.getCode();
            if (result.length > 0) {
                for (int i = 0; i < result.length; i++) {
                    jsonArray.put(((Disc)result[i]).toJSON());
                }
            }
            else {
            /* old
            returnCode = MediaServiceResult.BAD_REQUEST.getCode();
            jsonObject.put("detail", "Es gibt noch keine Bücher!");
            return Response.status(returnCode).entity(jsonObject.toString()).build();
            */
                returnCode = MediaServiceResult.OK.getCode();

            }
            jsonObject.put("", jsonArray);
            return Response.status(returnCode).entity(jsonArray.toString()).build();
        }
        else {
            return noToken();
        }
    }

    /**
     * get single .
     * @param barcode barcode
     * @param token token
     * @return resp.
     */
    @GET
    @Path("/discs/{barcode}")
    @Produces("application/json")
    public Response getSingleDisc(@PathParam("barcode") String barcode, @QueryParam("token")String token) {
        if (Token.isAccesGranted(token)) {
            Medium[] result = mediaService.getDiscs();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObject = new JSONObject();
            int returnCode = MediaServiceResult.OK.getCode();
            if (result.length > 0) {
                for (int i = 0; i < result.length; i++) {
                    if (((Disc) result[i]).getBarcode().equals(barcode)) {
                        return Response.status(MediaServiceResult.OK.getCode()).entity(((Disc) result[i]).toJSON().toString()).build();
                    }
                }
            }
            return Response.status(MediaServiceResult.BAD_REQUEST.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
        } else {
            return noToken();
        }
    }

    /**
     * update .
     * @param barcode barcode
     * @param token token
     * @param disc disc
     * @return resp
     */
    @POST
    @Path("/discs/{barcode}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateDisc(@PathParam("barcode") String barcode, @QueryParam("token")String token, Disc disc) {

        if (Token.isAccesGranted(token)) {
            MediaServiceResult r = MediaServiceResult.BAD_REQUEST;
            if (disc.getBarcode() != null && !disc.getBarcode().equals("")) {
                r = mediaService.updateDisc(barcode, disc);
                return Response.status(r.getCode()).entity(MediaServiceResult.OK.getStatus()).build();
            } else {
                System.out.println("Didnt work");
                return Response.status(r.getCode()).entity(MediaServiceResult.BAD_REQUEST.getStatus()).build();
            }
        } else {
            return noToken();
        }
    }


    /**
     * noTOken.
     * @return resp
     */
    private Response noToken() {
        String message = "Fail Authorization!";
        JSONObject result = new JSONObject();
        result.put("detail", message);
        return Response.status(M400).entity(result.toString()).build();
    }

}
