package appiumBasics;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNativeApp {

    @Test
    public void Locators() throws MalformedURLException, InterruptedException {

        //************** add desired caps
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version", "8.0");
        caps.setCapability("deviceName", "TestEmulator");
        caps.setCapability("platformName", "Android");
        //caps.setCapability("appPackage", "com.todoqacart");
        //caps.setCapability("appActivity", "com.todoqacart.MainActivity");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        ////////**************  AndroidElement
        AndroidElement clock = driver.findElement(MobileBy.AccessibilityId("Clock"));
        clock.click();
        ////////**************  By findElements
        List<AndroidElement> menu = driver.findElementsByClassName("android.widget.FrameLayout");
        System.out.println(menu.size());
        ////////************** By ID
        //driver.findElement(By.id("com.google.android.deskclock:id/tab_menu_timer")).click();
        //driver.findElementById("com.google.android.deskclock:id/tab_menu_timer").click();
        //driver.findElement(MobileBy.id("com.google.android.deskclock:id/tab_menu_timer")).click();

        ////////************** By MobileBy
        //driver.findElement(MobileBy.AccessibilityId("Clock")).click();
        //driver.findElement(MobileBy.AndroidUIAutomator("text(\"Bedtime\")"));
        //driver.findElement(MobileBy.AndroidUIAutomator("description(\"More options\")")).click(); //contact_desc


        ////////************** By xpath
        //driver.findElement(By.xpath("//android.widget.FrameLayout[@text='Stopwatch']")).click();
        //driver.findElement(By.xpath("//*[@text='Stopwatch']")).click();
        //driver.findElement(By.xpath("(//android.widget.FrameLayout)[4]")).click();      //index

        ////////************** By className
        //String textViewer= driver.findElement(By.className("android.widget.TextView")).getText();
        //Assert.assertEquals(textViewer,"00h 00m 08s");

    }

    @Test
    public void Actions() throws MalformedURLException {

        //************** add desired caps
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version", "8.0");
        caps.setCapability("deviceName", "TestEmulator");
        caps.setCapability("platformName", "Android");
        //caps.setCapability("appPackage", "com.todoqacart");
        //caps.setCapability("appActivity", "com.todoqacart.MainActivity");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        ////////**************  actions
        AndroidElement clock = driver.findElement(MobileBy.AccessibilityId("Clock"));
        clock.click();
        clock.getText();
        clock.clear();
        clock.sendKeys("hello");
        clock.getAttribute("class");// return value of all attributes execpt index
//        int x = clock.getLocation().x;
//        int y = clock.getLocation().y;
//        int height = clock.getSize().height;
        driver.quit();
        //////////************* advanced actions
        driver.lockDevice();
        driver.unlockDevice();
        driver.isDeviceLocked();
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(ScreenOrientation.PORTRAIT);


    }

    @Test
    public void scroll() throws MalformedURLException, InterruptedException {

        //************** add desired caps
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version", "8.0");
        caps.setCapability("deviceName", "TestEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        ////////**************  actions
        AndroidElement moreOptions = driver.findElement(MobileBy.AccessibilityId("More options"));
        moreOptions.click();
//        Thread.sleep(1000);
        AndroidElement settings = driver.findElement(By.xpath("//*[@text='Settings']"));
        settings.click();
        //text("Night mode")
        String uiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Night mode\"))";

        AndroidElement nightMood = driver.findElement(MobileBy.AndroidUIAutomator(uiAutomatorString));
        nightMood.click();
    }
    @Test
    public void clickAndHold_DragAndDrop() throws MalformedURLException, InterruptedException {

        //************** add desired caps
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version", "8.0");
        caps.setCapability("deviceName", "TestEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        ////////**************  actions
        AndroidElement alarm = driver.findElement(MobileBy.AccessibilityId("Alarm"));
        alarm.click();
        AndroidElement addAlarm = driver.findElement(MobileBy.AccessibilityId("Add alarm"));
        addAlarm.click();

        Actions action=new Actions(driver);

        AndroidElement hour4 = driver.findElement(MobileBy.AccessibilityId("4 o'clock"));
        AndroidElement hour10 = driver.findElement(MobileBy.AccessibilityId("10 o'clock"));

        action.clickAndHold(hour4).moveToElement(hour10).release().build().perform();
        action.dragAndDrop(hour4,hour10).build().perform();
    }

    @Test
    public void snapShoot_implicitlyWait() throws IOException, InterruptedException {

        //************** add desired caps
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version", "8.0");
        caps.setCapability("deviceName", "TestEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        ////////**************  actions
        AndroidElement moreOptions = driver.findElement(MobileBy.AccessibilityId("More options"));
        moreOptions.click();

        //********** implicitly Wait
        //1-global on  all elemints in the code
        //2-if not found it throw execptions
        //3-if it found it before time end not wait untill time end

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        File snapshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(snapshot, new File("qacartImages/hatem.png"));

    }
    @Test
    public void snapshoot() throws IOException, InterruptedException {

        //************** add desired caps
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("version", "8.0");
        caps.setCapability("deviceName", "TestEmulator");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.deskclock");
        caps.setCapability("appActivity", "com.android.deskclock.DeskClock");
        caps.setCapability("orientation", "PORTRAIT");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        ////////**************  actions
        AndroidElement moreOptions = driver.findElement(MobileBy.AccessibilityId("More options"));
        moreOptions.click();

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(moreOptions));


    }
}


