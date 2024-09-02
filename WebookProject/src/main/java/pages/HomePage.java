package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HomePage {
    //variable
    WebDriver driver;
    String homeUrl = "https://webook.com/en";
    Util utilPage;

    //constrain
    public HomePage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
    }

    //element
   private By searchInputLocator =  By.xpath("//input[@class='focus:ring-primary focus:border-primary bg-input/10 h-12 w-full rounded-md border-none border-transparent text-sm ltr:pl-8 rtl:pr-8']");
    private By searchIconButtonLocator =  By.xpath("//*[@id='main']/section[1]/form/button");
    private By signUpButtonLocator = By.linkText("Log In / Sign Up");
    public By elementToValidate = By.linkText("webook.com for business");
    public By searchResultLocator=By.xpath("//*[@id='main']/section[1]/h1");
    public By filtrationTextAssertionLocator=By.xpath("//p[@class='text-2xl font-semibold'][1]");

    //action

    public void navigateToHomePage() {
        utilPage.navigateToPage(homeUrl, elementToValidate);
       }

    public void UserCanSignIn() {
        utilPage.clickOnButton(signUpButtonLocator);
    }

public void UserCanSearch(String search) {
    driver.findElement(searchInputLocator).sendKeys(search);
   driver.findElement(searchIconButtonLocator).submit();
   utilPage.assertOnMassage(searchResultLocator,"Search results for \""+search+"\"");
}
    public void UserCanSearchByFilter(String filter) {
        driver.findElement(searchInputLocator).click();
        utilPage.assertOnMassage(filtrationTextAssertionLocator,"Explore things to book");
        String filterlocator=String.format("//span[text()='%s']", filter);
        driver.findElement( By.xpath(filterlocator)).click();
    }

}

