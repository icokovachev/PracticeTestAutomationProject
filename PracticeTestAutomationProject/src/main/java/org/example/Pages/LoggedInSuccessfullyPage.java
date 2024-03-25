package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedInSuccessfullyPage {

    WebDriver driver;

    public static final String TabTitle = "Logged In Successfully | Practice Test Automation";

    @FindBy(how = How.XPATH, using = "//*[@id=\"loop-container\"]/div/article/div[2]/div/div/div/a")
    WebElement logOutButton;

    public LoggedInSuccessfullyPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean logOutButtonIsDisplayed() {
        waitForLogOutButtonToBeDisplayed();
        return logOutButton.isDisplayed();
    }

    private void waitForLogOutButtonToBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logOutButton));
    }
}
