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
        // erzeuge das Mock Obj
        Set mockSet = mock(Set.class);
        // Jdes mal wenn in der Klasse eine Variale vom Type MediService verwendet wird wird ein Default obj von Median Service Imp injekziert
        bind(MediaService.class).to(MediaServiceImpl.class);
        bind(IAuthServer.class).to(AuthServer.class);
        // Bind die Variable mit dem Type Set an ein Bestimmtes Obj
        bind(Set.class).toInstance(mockSet);
    }
}
