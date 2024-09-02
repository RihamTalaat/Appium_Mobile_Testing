package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegisterPage {
    //variable
    WebDriver driver;
    String homeUrl = "https://webook.com/en/login?redirect=/en/events/wta-finals-tickets";
    Util utilPage;
    HomePage homePage;
    //constrain
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
       homePage=new HomePage(driver);
    }

    //element
    public By elementToValidate = By.xpath("//h4[text()='Create Your Account']");
    private By firstnameLocator = By.id("first_name");
    private By lastnameLocator = By.name("last_name");
    private By emailLocator = By.id("email");
    private  By confirmEmail=By.name("confirm_email");
    private By passwordLocator = By.name("password");
    private By contryCodeinputFeildLocator =By.xpath("//*[@id='signup-form-info']/fieldset[4]/div/div[1]/div/div/div/div/input");
    private By contryCodeSelectorLocator = By.xpath("//*[@class='block flex-1 truncate px-2']");
    private By phoneNumberLocator = By.name("mobile");
    private By agreeTermscheckboxLocator =By.name("agreeTerms");
    private By letterAgreecheckboxLocator =By.name("newsletterAgree");
    private By signUpButtonLocator = By.xpath("//span[text()='Create Account']");

    //action

    public void navigateToRegisterPage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void UserCanRegister(String firstName , String lastName , String email , String password,String mobile,String countryCode) {

       Assert.assertEquals(utilPage.getText(elementToValidate),"Create Your Account");
        utilPage.setText(firstnameLocator,firstName,false);
        utilPage.setText(lastnameLocator,lastName,false);
        utilPage.setText(emailLocator,email,false);
        utilPage.setText(confirmEmail,email,false);
        utilPage.setText(passwordLocator,password,false);
        utilPage.setText(contryCodeinputFeildLocator,countryCode,true);
        utilPage.clickOnButton(contryCodeSelectorLocator);
        utilPage.setText(phoneNumberLocator,mobile,false);
        utilPage.clickOnCheckbox(agreeTermscheckboxLocator);
        utilPage.clickOnCheckbox(letterAgreecheckboxLocator);
        utilPage.clickOnButton(signUpButtonLocator,homePage.elementToValidate);
       }

}

