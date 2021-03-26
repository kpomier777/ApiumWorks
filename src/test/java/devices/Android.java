package devices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android implements IDevices{
    @Override
    public AppiumDriver crear() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Galaxy J5 Prime");
        capabilities.setCapability("platformVersion","8.0.0");

//      capabilities.setCapability("appPackage","com.android.calculator2");
//      capabilities.setCapability("appActivity",".Calculator");

      capabilities.setCapability("appPackage","com.samsung.android.calendar");
      capabilities.setCapability("appActivity","com.android.calendar.AllInOneActivity");

//        capabilities.setCapability("appPackage","com.example.android.contactmanager");
//        capabilities.setCapability("appActivity",".ContactManager");

        capabilities.setCapability("platformName","Android");

        AppiumDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),capabilities);
        // implicit waits
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
