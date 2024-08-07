package appiumBasics;


import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class IOS {

    @Test
    public void openIosNativeApp() throws MalformedURLException {
        File app=new File("app/QAcart-To-Do.apk");//replace it with zip of ios app
        DesiredCapabilities caps =new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Iphone11");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ios");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        // caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); //to install it in first time
       // caps.setCapability(MobileCapabilityType.APP, "bunndel id");// PUT Bunndel ID OF APPLICATION  ask developer for it
        caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Safari");// for test web



    IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        driver.findElement(By.id("name")).click();  // in IOS NAME==ID
        driver.findElement(MobileBy.AccessibilityId("accesabilityid")).click();
        driver.findElementByClassName("accesabilityid").click();   // in ios TYPE==class name




    }
    @Test
    public void scrollIOS() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"IOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"ios");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.13");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);

        RemoteWebElement parent = (RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
        String parentID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", parentID);
        scrollObject.put("name", "Switches");
        driver.executeScript("mobile:scroll", scrollObject);

    }
}

