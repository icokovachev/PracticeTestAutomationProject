package org.example.LoginPageTests;

import org.example.Common.ConfigurationProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverInitialization {

    // For the sake of simplicity I have implemented only Chrome browser
    // as it is the most used browser in the world currently
    public static WebDriver InitializeChromeDriver(){
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.addArguments("--window-size=1920,1080");
        if (ConfigurationProvider.isHeadlessEnabled) browserOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(browserOptions);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(ConfigurationProvider.BaseURL);
        return driver;
    }
}
