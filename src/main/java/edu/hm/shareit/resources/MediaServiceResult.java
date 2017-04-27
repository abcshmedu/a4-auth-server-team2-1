package edu.hm.shareit.resources;

import javax.ws.rs.core.Response.Status;

/**
 * Created by MatHe on 26.04.2017.
 */
public enum MediaServiceResult {

    OK(200, Status.OK),
    BAD_REQUEST(400, Status.BAD_REQUEST),
    CONFLICT(409, Status.CONFLICT);

    private final int id;

    /**
     * Getter.
     * @return code.
     */
    int getCode() {
        return this.id;
    }

    private final Status status;

    /**
     * Getter.
     * @return status.
     */
    Status getStatus() {
        return this.status;
    }

    /**
     * Ctor.
     * @param id int id of the HTTP error code.
     * @param state state of the error code.
     */
    MediaServiceResult(int id, Status state) {
        this.id = id; this.status = state;
    }



    /*public static MediaServiceResult valueOf(String string){
        return null;
    }*/

    /*public static MediaServiceResult[] values(){
        return null;
    }*/
}
