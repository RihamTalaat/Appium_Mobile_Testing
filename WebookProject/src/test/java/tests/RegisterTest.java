package tests;


import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utility.HelperClass;
/*
this class for login page locators and methods
 */

public class RegisterTest extends TestBase {
  HomePage homePage;
  LoginPage loginPage;
  RegisterPage registerPage;


  @Test
  public void RegisterWithValidData() {
    String email = HelperClass.generateRandomEmail();
    homePage = new HomePage(driver);
    homePage.navigateToHomePage();
    homePage.UserCanSignIn();
   loginPage = new LoginPage(driver);
   loginPage.userCanCreateAnAccount();
   registerPage = new RegisterPage(driver);
   registerPage.UserCanRegister("firstname", "lastname", email, "12345678r","1098083922","+20");
   //homePage.UserCanSearch("Tamer");
   homePage.UserCanSearchByFilter("Events");
  }

}
