package edu.hm.shareit.resources;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Created by MatHe on 26.04.2017.
 */
public enum MediaServiceResult {

    OK(200, Status.OK),
    Failed(400, Status.BAD_REQUEST),
    conflict(409,Status.CONFLICT);

    private final int id;

    int getCode(){
        return this.id;
    }
    private final Status status;
    Status getStatus(){
        return this.status;
    }

    MediaServiceResult(int id,Status state) { this.id = id; this.status=state;}



    /*public static MediaServiceResult valueOf(String string){
        return null;
    }*/

    /*public static MediaServiceResult[] values(){
        return null;
    }*/
}
