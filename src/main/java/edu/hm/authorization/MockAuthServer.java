package edu.hm.authorization;

import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 07.06.2017.
 */
public class MockAuthServer implements IAuthServer {
    @Override
    public Response login(User user) {
        return Response.status(200).build();
    }

    @Override
    public Response sig(User user) {
        return Response.status(200).build();
    }

    @Override
    public Response logout(User user) {
        return Response.status(200).build();
    }

    @Override
    public Response validate(Token token) {
        return Response.status(200).build();
    }
}
