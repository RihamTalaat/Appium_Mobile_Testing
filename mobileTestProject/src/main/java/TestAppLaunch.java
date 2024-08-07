
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class TestAppLaunch {
    private AppiumDriver<MobileElement> driver;
   @Test
    public void testRunner(){
       DesiredCapabilities caps = new DesiredCapabilities();
       caps.setCapability("platformName", "Android");
       caps.setCapability("deviceName", "Android Emulator");
       caps.setCapability("app", "/path/to/your/app.apk");

       driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
}
