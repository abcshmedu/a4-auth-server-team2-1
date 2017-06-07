package edu.hm.authorization;

import javax.ws.rs.core.Response;

/**
 * Created by MatHe on 07.06.2017.
 */
public class MockAuthServer implements IAuthServer {
    @Override
    public Response login(User user) {
        return null;
    }

    @Override
    public Response sig(User user) {
        return null;
    }

    @Override
    public Response logout(User user) {
        return null;
    }

    @Override
    public Response validate(Token token) {
        return null;
    }
}
