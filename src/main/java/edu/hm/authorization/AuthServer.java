package edu.hm.authorization;


    import org.json.JSONArray;
    import org.json.JSONObject;
    //import io.jsonwebtoken.*;
    import javax.ws.rs.*;
    import javax.ws.rs.core.Response;
    import java.util.HashMap;
    import java.util.Map;

/**
 * Created by MatHe on 17.05.2017.
 */
@Path("/")
public class AuthServer {
    //USE PostMan oder Perl

    // token zu
    Map<String,String> database = new HashMap<>();

    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public JSONObject login(JSONObject jsonObject){
        System.out.println(jsonObject.toString());

        JSONObject myResponse = new JSONObject();

        myResponse.put("code","200");
        String newToken = "asdfas";
        myResponse.put("Token",newToken);
        database.put(newToken,"name=asdf,info=asdfgs2");

        return myResponse;
}

    @GET
    @Path("signup")
    //@Consumes("application/json")
    @Produces("application/json")
    public Response signup(){

        return Response.status(400).build();

    }

    @POST
    @Path("/logout")
    @Consumes("application/json")
    @Produces("application/json")
    public Response logout(){
        return Response.status(400).build();
    }


    @POST
    @Path("/validate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validate(){
        return Response.status(400).build();
    }



}
