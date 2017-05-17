package edu.hm.shareit.authorization;


    import org.json.JSONArray;
    import org.json.JSONObject;

    import javax.ws.rs.*;
    import javax.ws.rs.core.Response;
    import java.util.HashMap;
    import java.util.Map;

/**
 * Created by MatHe on 17.05.2017.
 */
@Path("/")
public class AuthServer {


    Map<String,String> database = new HashMap<>();

    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(JSONObject jsonObject){
        System.out.println(jsonObject.toString());

        JSONObject myResponse = new JSONObject();

        myResponse.put("code","200");
        String newToken = "asdfas";
        myResponse.put("Token",newToken);
        database.put(newToken,"name=asdf,info=asdfgs2");

        return Response.status(400).entity(myResponse.toString()).build();

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
