package appiumBasics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestAPK {
    @Test
    public void testRunner() throws MalformedURLException {
        //************** add desire cap
File app =new File("app/QAcart-To-Do.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version","8.0");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", app.getAbsolutePath());
        //caps.setCapability(MobileCapabilityType.APP,"D:/riham/ITI/MobileTesting/project/QACartAppiumCourse/app/QAcart-To-Do.apk");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

    }

}
