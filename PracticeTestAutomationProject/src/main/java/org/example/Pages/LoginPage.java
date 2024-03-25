// We need to create a Page Object class for our Login Page
// We will use Page Factory pattern

// I like to sort the elements by where they are located on the page
// I start from top left and end on bottom right

package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    // This will be the expected browser title of the page
    // Can be found under the DevTools of the browser -> Elements tab -> <head>/<title>
    // We will use it for page validation
    public static final String TabTitle = "Test Login | Practice Test Automation";

    // I used @FindBy annotation to locate the elements
    // Remember that ID is the fastest way to locate an element
    // and Xpath is the slowest way to locate an element
    // You can find all the elements in the DevTools of the browser -> Elements tab
    @FindBy(how = How.ID, using = "site-title")
    WebElement loginPageLogo;
    @FindBy(how = How.XPATH, using = "//*[@id='login']/h2")
    WebElement loginPageTitle;
    @FindBy(how = How.ID, using = "username")
    WebElement userNameField;
    @FindBy(how = How.ID, using = "password")
    WebElement passwordField;
    @FindBy(how = How.ID, using = "submit")
    WebElement loginButton;
    @FindBy(how = How.ID, using = "error")
    WebElement errorMessage;

    // We create a constructor that will initialize the elements of the page
    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void attemptToLoginWithGivenCredentials(String username, String password) {
        waitForPageToLoad();
        enterCredentialsInUsernameAndPasswordFields(username, password);
        clickLoginButton();
    }

    public boolean errorMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    // We will use this method to wait for the page to load
    // It takes a WebDriver instance as a parameter to wait for the page to load
    // The method will wait for maximum of 10 seconds for a given element to load before throwing an exception
    private void waitForPageToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPageLogo));
        wait.until(ExpectedConditions.visibilityOf(loginPageTitle));
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    // We will use this method to enter credentials
    private void enterCredentialsInUsernameAndPasswordFields(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    // We will use this method to click on the login button
    private void clickLoginButton() {
        loginButton.click();
    }
}