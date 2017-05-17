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
        System.out.print("XXX");
    }
    // token zu verfügbaren informationen
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
    public Response sig(){

        return Response.status(400).build();

    }

    @POST
    @Path("logout")
    @Consumes("application/json")
    @Produces("application/json")
    public Response logout(){
        return Response.status(400).build();
    }


    @POST
    @Path("validate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validate(){
        return Response.status(400).build();
    }



}
