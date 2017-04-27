package edu.hm.shareit.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaResource {

    MediaService mediaService = new MediaServiceImpl();

    public MediaResource(){

    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createBook(Book book){

        MediaServiceResult result =  mediaService.addBook(book);
        if (result == MediaServiceResult.OK){

        }
        else if(result== MediaServiceResult.BAD_REQUEST){

        }
        else  if (result == MediaServiceResult.CONFLICT){
            
        }


        //Todo result -> Response

        return null;
    }

    @GET
    @Produces("application/json")
    public Response getBooks(){
        Medium[] result = mediaService.getBooks();
        //Todo result -> JSON -> Response
        return null;
    }


    public Response updateBook(){
        return null;
    }
}
