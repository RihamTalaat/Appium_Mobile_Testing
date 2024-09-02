package stepsCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BrowserAction;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utility.HelperClass;

public class Steps  {
    public  WebDriver driver;
    public BrowserAction browserAction;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    String email = HelperClass.generateRandomEmail();




    @Given("I am on the home page")
    public void iAmOnHomePage() {
        browserAction = new BrowserAction (driver);
        driver = browserAction.driverSetup("chrome");
        browserAction.maxBrowser();
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.UserCanSignIn();
        loginPage = new LoginPage(driver);
        loginPage.userCanCreateAnAccount();
        }

    @When("I register with valid details")
    public void RegisterWithValidDetails() {
        registerPage = new RegisterPage(driver);
        registerPage.UserCanRegister("firstname", "lastname", email, "12345678r","1098083922","+20");
    }
    @Then("I can search without Filter")
    public void search_without_filter() {
        homePage.UserCanSearch("Tamer");
        homePage.navigateToHomePage();
    }
    @Then("I can search with Filter")
    public void search_with_filter() {
        homePage.UserCanSearchByFilter("Events");

    }

}