package edu.hm.Mock;

import com.google.inject.AbstractModule;
import edu.hm.authorization.IAuthServer;
import edu.hm.authorization.MockAuthServer;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;

import java.util.Set;

import static org.mockito.Mockito.mock;

/**
 * Created by axel on 26.05.17.
 */
public class GuiceModuleForTesting extends AbstractModule {

    @Override
    protected void configure() {
        //bind(SessionFactory.class).toInstance(new Configuration().configure().buildSessionFactory());

        //Todo insert Dependency Injection
        bind(MediaService.class)
                .to(MediaServiceImpl.class);
        bind(IAuthServer.class)
                .to(MockAuthServer.class);
    }




}
