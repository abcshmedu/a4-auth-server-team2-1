package edu.hm;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import edu.hm.persistierung.GuiceTestModule;
import edu.hm.shareit.resources.MediaService;
import edu.hm.shareit.resources.MediaServiceImpl;

/**
 * Context Listener to enable usage of google guice together with jersey.
 */
public class ShareitServletContextListener
extends GuiceServletContextListener {

    public static final Injector injector
            = Guice.createInjector(new GuiceTestModule() );
    
    @Override
    protected Injector getInjector() {
        return injector;
    }

    /**
     * This method is only required for the HK2-Guice-Bridge in the
     * Application class.
     *
     * @return Injector instance.
     */
    public static Injector getInjectorInstance() {
        return injector;
    }
}
