package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    //variable
    WebDriver driver;
    String homeUrl = "https://webook.com/en/login?redirect=/en/events/wta-finals-tickets";
    Util utilPage;

    //constrain
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
    }

    //element
    private By elementToValidate = By.xpath("//Div[text()='Login to webook.com']");
    private By createAnAccountButtonLocator = By.xpath("//button[text()='Create an account']");





    //action

    public void navigateToLoinPage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
    }

    public void userCanCreateAnAccount() {
        utilPage.assertOnMassage(elementToValidate,"Login to webook.com");
        driver.findElement(createAnAccountButtonLocator).click();

    }



}

