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
public class ImplModul extends AbstractModule{
    @Override
    protected void configure() {
        Set<Disc>DiscSet = new HashSet<>();
        Set<Book>BockSet = new HashSet<>();
        bind(MediaService.class).to(MediaServiceImpl.class);
        bind(IAuthServer.class).to(AuthServer.class);
        // Bind die Variable mit dem Type Set an ein Bestimmtes Obj
        bind(new TypeLiteral<Set<Book>>() {}).toInstance(BockSet);
        bind(new TypeLiteral<Set<Disc>>() {}).toInstance(DiscSet);
    }
}
