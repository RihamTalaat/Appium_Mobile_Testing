package org.screen;
import org.base.Base;
import org.utils.Util;
import org.openqa.selenium.By;

public class HomePageScreen extends Base {


    private By  languageButton = By.xpath("//*[@text='android.widget.TextView']");
    private By continueButton =By.xpath("//*[@text='Continue']");
    private By  skipButton =By.xpath("//*[@text='Skip']");
    private By elementToValidate =By.xpath("//*[@text='SFA Domes']");

    public void userChangeLanguage() {
        Util.clickOnElement( languageButton);
    }
    public void userGoToHomePage(){
        Util.clickOnElement(continueButton);
        Util.clickOnElement(skipButton);
        Util.assertOnMassage(elementToValidate,"SFA Domes");
    }
}