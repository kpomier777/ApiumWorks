package sesion;

import devices.FactoryDevices;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class Session {

    private static Session session= null;
    private AppiumDriver driver;

    private Session() throws MalformedURLException {
        driver= FactoryDevices.make(FactoryDevices.ANDROID).crear();
    }

    public static Session getInstance() throws MalformedURLException {
        if (session==null)
            session= new Session();
        return session;
    }

    public void closeSession(){
        driver.quit();
        session=null;
    }

    public AppiumDriver getDriver() {
        return driver;
    }


}
