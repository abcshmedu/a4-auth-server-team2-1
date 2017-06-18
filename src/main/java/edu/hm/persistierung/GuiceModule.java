package edu.hm.persistierung;

import com.google.inject.AbstractModule;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.IAuthServer;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;

/**
 * Created by axel on 26.05.17.
 */
public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        //bind(SessionFactory.class).toInstance(new Configuration().configure().buildSessionFactory());

        //Todo insert Dependency Injection
        bind(MediaService.class)
                .to(MediaServiceImpl.class);
        bind(IAuthServer.class)
                .to(AuthServer.class);
    }




}
