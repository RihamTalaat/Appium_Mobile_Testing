package org.screen;
import org.base.Base;
import org.utils.Util;
import org.openqa.selenium.By;

public class LoginPageScreen extends Base {



    private By  profilePageButton =By.cssSelector("//*[@class='android.widget.Button'][4]");
    private By  logInButton =By.xpath("//*[@text='Log In']");
    private By elementToValidate =By.xpath("//*[@text='Be a part of fun events, join groups, earn rewards and much more!']");

    public void userGoToLogInPage(){
        Util.clickOnElement(profilePageButton);
        Util.assertOnMassage(elementToValidate,"Be a part of fun events, join groups, earn rewards and much more!");
        Util.clickOnElement(logInButton);

    }
}