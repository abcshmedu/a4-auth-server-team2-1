package edu.hm.authorization;


    import org.json.JSONArray;
    import org.json.JSONObject;
    //import io.jsonwebtoken.*;
    import javax.ws.rs.*;
    import javax.ws.rs.core.Response;
    import java.util.HashMap;
    import java.util.Map;


@Path("/auth/")
public class AuthServer {
    //USE PostMan oder Perl
    public AuthServer(){
    }
    // token zu verfügbaren informationen
    //Map<String,String> database = new HashMap<>();

    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(User user){
        System.out.println(user.toString());

        JSONObject myResponse = new JSONObject();

        myResponse.put("code","200");
        Token myToken = Token.generateToken(user);
        String newToken = "asdfas";
        myResponse.put("token",myToken.toString());
        //database.put(newToken,"name=asdf,info=asdfgs2,ends=2018");

        return Response.status(250).entity(myResponse.toString()).build();
}

    @POST
    @Path("signup")
    @Consumes("application/json")
    @Produces("application/json")
    public Response sig(User user){
        int status = 200;
        boolean isNew = User.add(user);
        if(!isNew) // es gibt den user bereits
            status = 400;
        return Response.status(status).build();

    }

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


    @POST
    @Path("validate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validate(){
        return Response.status(400).build();
    }



}
