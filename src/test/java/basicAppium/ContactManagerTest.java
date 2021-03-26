package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ContactManagerTest {
    private AppiumDriver driver;

    @Before
    public void before() throws MalformedURLException {
        // connection app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","EynarH");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.example.android.contactmanager");
        capabilities.setCapability("appActivity",".ContactManager");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),capabilities);
        // implicit waits
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void verifyAddContact() throws InterruptedException {

        String name="AAAARemoveUPB";
        String phone="111111111111";
        String emial="remove@remove.com";

        // click en el boton OK dialog (si existe)
        if (driver.findElements(By.id("android:id/button1")).size()>0) {
           driver.findElement(By.id("android:id/button1")).click();
        }
        // click en boton Add Contact
        driver.findElement(By.xpath("//android.widget.Button[@text='Add Contact']")).click();
        // fill the name text box
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys(name);
        // fill the phone text box
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys(phone);
        // fill the emial text box
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys(emial);
        // click en boton Save
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();

      //  driver.findElement(By.id("com.example.android.contactmanager:id/showInvisible")).click();

        Thread.sleep(2000);
        // verificacion que el contacto esta creado
        Assert.assertTrue("ERROR !! El contacto no fue creado", driver.findElement(By.xpath("//android.widget.TextView[@text='"+name+"']")).isDisplayed());

    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
