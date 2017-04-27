package edu.hm.shareit.resources;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 26.04.2017.
 */
@Path("/media/books")
public class MediaResource {

    MediaService mediaService ;

    public MediaResource(){
        mediaService = new MediaServiceImpl();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createBook(Book book){

        MediaServiceResult result =  mediaService.addBook(book);
        JSONObject jsonObject = new JSONObject();
        if (result == MediaServiceResult.OK){
            jsonObject.put("code",result.getCode());
            jsonObject.put("detail", "Neues Buch wurde hinzugefügt");
        }
        else if(result== MediaServiceResult.BAD_REQUEST){
            jsonObject.put("code",result.getCode());
            jsonObject.put("detail", "Ungültige Eingabe");
        }
        else  if (result == MediaServiceResult.CONFLICT){
            jsonObject.put("code",result.getCode());
            jsonObject.put("detail", "Es gibt dieses Buch schon.");
        }

        return Response.status(result.getCode()).entity(jsonObject.toString()).build();

    }

    @GET
    @Produces("application/json")
    public Response getBooks(){
        //Todo check if books there?


        Medium[] result = mediaService.getBooks();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int returnCode = 200;
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                jsonArray.put(((Book)result[i]).toJSON());
            }
        }
        else{
            returnCode = 400;
            jsonObject.put("detail", "Es gibt noch keine Bücher!");
            return Response.status(returnCode).entity(jsonObject.toString()).build();
        }
        jsonObject.put("",jsonArray);

        return Response.status(returnCode).entity( jsonArray.toString()).build();
        //Todo result -> JSON -> Response
    }


    public Response updateBook(){
        return null;
    }
}
