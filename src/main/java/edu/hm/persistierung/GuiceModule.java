package edu.hm.persistierung;

import com.google.inject.AbstractModule;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.IAuthServer;
import edu.hm.authorization.MockAuthServer;
import edu.hm.shareit.resources.MediaResource;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by axel on 26.05.17.
 */
public class GuiceModule extends AbstractModule {

    protected void configure() {
        //bind(SessionFactory.class).toInstance(new Configuration().configure().buildSessionFactory());

        //Todo insert Dependenc Injection
        bind(MediaService.class)
                .to(MediaServiceImpl.class);
        bind(IAuthServer.class)
                .to(MockAuthServer.class);
    }

}
