package cleanAppium;

import org.junit.After;
import sesion.Session;

import java.net.MalformedURLException;

public class TestBase {
    @After
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
