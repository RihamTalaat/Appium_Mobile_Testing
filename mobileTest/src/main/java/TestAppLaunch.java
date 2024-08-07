import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.URL;

public class TestAppLaunch {


    @Test
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version","8.0");
        caps.setCapability("deviceName","TestEmulator");
        caps.setCapability("platformName", "Android");

      caps.setCapability("browserName", "Chrome");
        caps.setCapability("orientation", "PORTRAIT");
//        caps.setCapability("appPackage","com.android.calculator2");
//        caps.setCapability("appActivity","com.android.calculator2.Calculator");

 
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.get("https://www.google.com");
       // driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
//        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
//        driver.findElement(By.xpath("//input[@id ='email' ]")).sendKeys("ITI41@gmail.com");
//        driver.findElement(By.xpath("//input[@id ='passwd' ]")).sendKeys("ITI41");
//        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
    }


}
