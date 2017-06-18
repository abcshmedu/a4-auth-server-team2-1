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
    /**
     * resop.
     * @param user u
     * @return coe
     */
    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    Response login(User user);

    /**
     * sig in .
     * @param user u
     * @return code
     */
    @POST
    @Path("signup")
    @Consumes("application/json")
    @Produces("application/json")
    Response sig(User user);
    /**
     * lgoin.
     * @param user u
     * @return code
     */
    @POST
    @Path("logout")
    @Consumes("application/json")
    @Produces("application/json")
    Response logout(User user);

    /**
     *vlaid.
     * @param token u
     * @return code
     */
    @POST
    @Path("validate")
    @Consumes("application/json")
    @Produces("application/json")
    Response validate(Token token);
}
