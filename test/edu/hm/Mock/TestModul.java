package edu.hm.Mock;

import com.google.inject.AbstractModule;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.IAuthServer;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;

import java.util.Set;

import static org.mockito.Mockito.mock;

/**
 * Created by lapi on 07/06/2017.
 */
public class TestModul extends AbstractModule{
    @Override
    protected void configure() {
        Set mockSet = mock(Set.class);
        bind(MediaService.class).to(MediaServiceImpl.class);
        bind(IAuthServer.class).to(AuthServer.class);
        bind(Set.class).toInstance(mockSet);
    }
}
