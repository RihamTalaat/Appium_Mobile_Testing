package org.utils;

import org.apache.commons.io.FileUtils;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class Util extends Base {
    public static boolean validation(By element, ExpectedCondition<WebElement> condition) {
        try {
            new WebDriverWait(driver, 10).until(condition);
            return true;
        } catch (Exception e) {
            System.out.println("The Condition Is wrong ");
            return false;

        }
    }
public static void   clickOnElement(By element){

        try {
            if (validation(element, ExpectedConditions.elementToBeClickable(element))) {
                driver.findElement(element).click();
            }
        } catch (Exception e) {
            Assert.fail("Couldn't click because of" + e.getMessage());
        }

    }
    public static void assertOnMassage(By element, String expectedMessage) {
     if( validation(element, ExpectedConditions.visibilityOfElementLocated(element)))

        Assert.assertEquals(driver.findElement(element).getText(), expectedMessage);
     else {
         System.out.println("expectedMessage not appear");
     }
    }
public static void snapshoot() throws IOException {
    File snapshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(snapshot, new File("qacartImages/failer.png"));
}
}

