package edu.hm.shareit.resources;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.Test;

/**
 * Created by MatHe on 12.04.2017.
 */
public class JettyStarterTest {

    public static final String APP_URL = "/";
    public static final int PORT = 8082;
    public static final String WEBAPP_DIR = "./src/main/webapp/";

    @Test(timeout=10000)
    public void firstTry() throws Exception {
        Server jetty = new Server(PORT);
        jetty.setHandler(new WebAppContext(WEBAPP_DIR, APP_URL));
        jetty.start();
        System.out.println("Jetty listening on port " + PORT);
        jetty.stop();
        jetty.join();
    }

    /**
     * Created by MatHe on 24.05.2017.
     */
    public static class TestApplication {
    }
}