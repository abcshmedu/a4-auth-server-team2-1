package edu.hm.authorization;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 07.06.2017.
 */
public interface IAuthServer {
    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    Response login(User user);

    @POST
    @Path("signup")
    @Consumes("application/json")
    @Produces("application/json")
    Response sig(User user);

    @POST
    @Path("logout")
    @Consumes("application/json")
    @Produces("application/json")
    Response logout(User user);

    @POST
    @Path("validate")
    @Consumes("application/json")
    @Produces("application/json")
    Response validate(Token token);
}
