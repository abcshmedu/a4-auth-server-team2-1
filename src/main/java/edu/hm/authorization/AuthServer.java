package edu.hm.authorization;


    import org.json.JSONArray;
    import org.json.JSONObject;
    //import io.jsonwebtoken.*;
    import javax.ws.rs.*;
    import javax.ws.rs.core.Response;
    import java.util.HashMap;
    import java.util.Map;


@Path("/auth/")
public class AuthServer implements IAuthServer {
    //USE PostMan oder Perl
    public AuthServer(){
    }
    // token zu verfügbaren informationen
    //Map<String,String> database = new HashMap<>();

    @Override
    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(User user){
        int status = 400;
        JSONObject myResponse= new JSONObject();
        if(!user.exist(user)) {
            System.out.println(user.toString());
            System.out.println("login");
            myResponse.put("code", "200");
            status = 201;
            Token myToken = Token.generateToken(user);
            myResponse.put("token", myToken.toString());
        }
        return Response.status(status).entity(myResponse.toString()).build();
}

    @Override
    @POST
    @Path("signup")
    @Consumes("application/json")
    @Produces("application/json")
    public Response sig(User user){
        System.out.println("add user");
        int status = 200;
        boolean isNew = User.add(user);
        if(!isNew) { // es gibt den user bereits
            status = 400;
        }
        return Response.status(status).build();

    }

    @Override
    @POST
    @Path("logout")
    @Consumes("application/json")
    @Produces("application/json")
    public Response logout(User user){
        int status = 200;
        if(!Token.deleteToken(user)) // user does not exist
            status = 400;

        return Response.status(status).build();
    }


    @Override
    @POST
    @Path("validate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validate(Token token){
        int status = 200;
        if(!token.isAccesGranted())
            status = 400;
        return Response.status(status).build();
    }



}
