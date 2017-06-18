package edu.hm.authorization;


import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//import io.jsonwebtoken.*;

/**
 * path.
 */
@Path("/auth/")
public class AuthServer implements IAuthServer {
    /**
     * m1.
     */
   private final int magic2 = 200;
    /**
     * m2.
     */
    private final int magic4 = 400;

    /**
     *  USE PostMan oder Perl.
     */

    public AuthServer() {
    }
    // token zu verfügbaren informationen
    //Map<String,String> database = new HashMap<>();

    @Override
    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(User user) {
        int status = magic4;
        JSONObject myResponse = new JSONObject();
        if (User.exist(user)) {
            if (!Token.hasUser(user)) {
                System.out.println(user.toString());
                System.out.println("login");
                myResponse.put("code", "200");
                status = magic2;
                Token myToken = Token.generateToken(user);
                myResponse.put("token", myToken.toString());
            }
        }
        return Response.status(status).entity(myResponse.toString()).build();
}

    @Override
    @POST
    @Path("signup")
    @Consumes("application/json")
    @Produces("application/json")
    public Response sig(User user) {
        System.out.println("add user");
        int status = magic2;
        boolean isNew = User.add(user);
        if (!isNew) { // es gibt den user bereits
            status = magic4;
        }
        return Response.status(status).build();

    }

    @Override
    @POST
    @Path("logout")
    @Consumes("application/json")
    @Produces("application/json")
    public Response logout(User user) {
        int status = magic2;
        if (!Token.deleteToken(user)) { // user does not exist
            status = magic4;
        }

        return Response.status(status).build();
    }


    @Override
    @POST
    @Path("validate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validate(Token token) {
        int status = magic2;
        if (!token.isAccesGranted()) {
            status = magic4;
        }
        return Response.status(status).build();
    }



}
