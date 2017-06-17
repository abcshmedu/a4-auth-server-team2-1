package edu.hm.persistierung;

import com.google.inject.AbstractModule;
import com.google.inject.servlet.ServletModule;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.IAuthServer;
import edu.hm.authorization.MockAuthServer;
import edu.hm.shareit.resources.MediaResource;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

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
