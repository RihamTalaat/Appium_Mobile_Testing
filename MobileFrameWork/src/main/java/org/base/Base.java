package org.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
    protected InputStream inputStream;
    protected Properties prop;
    protected static AppiumDriver<MobileElement> driver;

    public Base (){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @Parameters({"platformName"})
    @BeforeClass
    public void desiredCapabilities(String platformName) throws IOException {

        File propFile = new File("src/main/resources/config/config.properties");
        inputStream = Files.newInputStream(propFile.toPath());
        prop = new Properties();
        prop.load(inputStream);


        File app = new File("/src/test/resources/APP/QAcart-To-Do.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platformName.equalsIgnoreCase("Android")) {
            caps.setCapability("platformName", platformName);
            caps.setCapability("version", prop.getProperty("version"));
            caps.setCapability("deviceName", prop.getProperty("deviceName"));
            caps.setCapability("platformName", prop.getProperty("platformName"));
            caps.setCapability("appPackage", prop.getProperty("appPackage"));
            caps.setCapability("appActivity", prop.getProperty("appActivity"));
            caps.setCapability("orientation", "PORTRAIT");
            //caps.setCapability("app", app.getAbsolutePath());
            //caps.setCapability(MobileCapabilityType.APP,"D:/riham/ITI/MobileTesting/project/QACartAppiumCourse/app/QAcart-To-Do.apk");

            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        } else if (platformName.equalsIgnoreCase("Ios")) {

            File iosApp = new File("app/QAcart-To-Do.apk");//replace it with zip of ios app
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone11");
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
            // caps.setCapability(MobileCapabilityType.APP, iosApp.getAbsolutePath()); //to install it in first time
            // caps.setCapability(MobileCapabilityType.APP, "bunndel id");// PUT Bunndel ID OF APPLICATION  ask developer for it
            //caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");
         driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
        else {
            System.out.println("Please enter valid platformName");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }

}
