package appiumBasics;

import io.appium.java_client.android.AndroidDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class TestMobileWeb {
    @Test
    public void testRunner() throws MalformedURLException {
        //************** add desire cap
        WebDriverManager.chromedriver().setup();
        String chromeDriverPath = WebDriverManager.chromedriver().getBinaryPath();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version","8.0");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("platformName", "Android");
           caps.setCapability("browserName", "Chrome");
        caps.setCapability("orientation", "PORTRAIT");
        caps.setCapability("chromedriverExecutable", chromeDriverPath);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("123")).sendKeys("1234");
    }

}
