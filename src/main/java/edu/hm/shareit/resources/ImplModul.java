package edu.hm.shareit.resources;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.IAuthServer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lapi on 14/06/2017.
 */
public class ImplModul extends AbstractModule {
    @Override
    protected void configure() {
        Set<Disc>disk = new HashSet<>();
        Set<Book>book = new HashSet<>();
        bind(MediaService.class).to(MediaServiceImpl.class);
        bind(IAuthServer.class).to(AuthServer.class);
        // Bind die Variable mit dem Type Set an ein Bestimmtes Obj
        bind(new TypeLiteral<Set<Book>>() { }).toInstance(book);
        bind(new TypeLiteral<Set<Disc>>() { }).toInstance(disk);
    }
}
