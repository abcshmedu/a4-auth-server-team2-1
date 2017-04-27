package edu.hm.shareit.resources;

import com.sun.org.apache.xerces.internal.util.Status;

/**
 * Created by MatHe on 26.04.2017.
 */
public enum MediaServiceResult {

    OK,
    second,
    good;

    int getCode(){
        return 0;
    }

    Status getStatus(){
        return null;
    }

    /*public static MediaServiceResult valueOf(String string){
        return null;
    }*/

    /*public static MediaServiceResult[] values(){
        return null;
    }*/
}
