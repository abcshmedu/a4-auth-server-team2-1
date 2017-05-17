package edu.hm.shareit.authorization;

import org.json.JSONObject;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 17.05.2017.
 */
public class AuthServerTest {

    @Test
    public void firstTest(){
        AuthServer authServer = new AuthServer();
        JSONObject myObject = new JSONObject();
        myObject.put("name","matthias");
        myObject.put("pass","matthias");

        Response asdf =  authServer.login(myObject);
        System.out.println(asdf.toString());
        


    }
}
