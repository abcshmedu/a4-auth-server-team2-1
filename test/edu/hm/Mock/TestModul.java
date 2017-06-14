package edu.hm.Mock;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import edu.hm.authorization.AuthServer;
import edu.hm.authorization.IAuthServer;
import edu.hm.shareit.resources.Book;
import edu.hm.shareit.resources.Disc;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;

/**
 * Created by lapi on 07/06/2017.
 */
public class TestModul extends AbstractModule{
    @Override
    protected void configure() {
        // erzeuge das Mock Obj
        Set<Book> mockSet = mock(Set.class);
        Set<Disc> mockSetDisc = mock(Set.class);
        // Jdes mal wenn in der Klasse eine Variale vom Type MediService verwendet wird wird ein Default obj von Median Service Imp injekziert
        bind(MediaService.class).to(MediaServiceImpl.class);
        bind(IAuthServer.class).to(AuthServer.class);
        // Bind die Variable mit dem Type Set an ein Bestimmtes Obj
        bind(new TypeLiteral<Set<Book>>() {}).toInstance(mockSet);
        bind(new TypeLiteral<Set<Disc>>() {}).toInstance(mockSetDisc);
    }
}
