package devices;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public interface IDevices {
    AppiumDriver crear() throws MalformedURLException;
}
