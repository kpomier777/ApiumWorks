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

public class CalculadoraTest {

    private AppiumDriver driver;

    @Before
    public void before() throws MalformedURLException {
        // connection app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Galaxy J5 Prime");
        capabilities.setCapability("platformVersion","8.0.0");

//      capabilities.setCapability("appPackage","com.android.calculator2");
//      capabilities.setCapability("appActivity",".Calculator");

        capabilities.setCapability("appPackage","com.simplemobiletools.calendar");
        capabilities.setCapability("appActivity",".calendar.activities.MainActivity");

//        capabilities.setCapability("appPackage","com.example.android.contactmanager");
//        capabilities.setCapability("appActivity",".ContactManager");

        capabilities.setCapability("platformName","Android");
        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),capabilities);
        // implicit waits
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void verifyAdditionCalculadora() throws InterruptedException {
        // actions + verification
        //click 2
        driver.findElement(By.xpath("//android.view.View[@content-desc='miércoles, 10 de marzo, Sin eventos o tareas']")).click();
        //click +
        driver.findElement(By.id("com.samsung.android.calendar:id/title")).sendKeys("Evento");
        // click 7
        driver.findElement(By.id("com.samsung.android.calendar:id/action_done")).click();
        // click =
        Thread.sleep(2000);
        String actualResult=driver.findElement(By.xpath("//android.view.View[@content-desc='miércoles, 10 de marzo, Sin eventos o tareas']")).getText();

        // verificar resulado sea 9
        //String actualResult=driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        String expectedResult="Evento";
        Assert.assertEquals("ERROR la suma es incorrecta",expectedResult,actualResult);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
