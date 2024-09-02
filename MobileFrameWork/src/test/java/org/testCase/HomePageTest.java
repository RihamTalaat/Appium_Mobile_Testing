package org.testCase;


import org.base.Base;

import org.screen.HomePageScreen;
import org.screen.LoginPageScreen;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    private HomePageScreen homePage;
    private LoginPageScreen loginPage;

    @Test
    public void userCanChangeLanguage() {
        homePage = new HomePageScreen();
        homePage.userChangeLanguage();
    }
    @Test
    public void userCanGoToLoginPage() {
        homePage = new HomePageScreen();
        homePage.userGoToHomePage();
        loginPage.userGoToLogInPage();
        driver.navigate().back();
    }


}