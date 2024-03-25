package org.example.LoginPageTests;

import org.example.Common.ConfigurationProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class TestConfiguration {

    static WebDriver driver;

    //For this implementation I have decided to use 'BeforeAll' and 'AfterAll' which
    // will run before the test execution have started and after the LAST test is done
    // If you need to implement a test specific things you can use BeforeEach and AfterEach
    @BeforeAll
    public static void setUp() {
        // We use this method to initialize the driver
        driver = DriverInitialization.InitializeChromeDriver();
    }

    @AfterEach
    public void tearDownEach() {
        // We use this method to reset the browser to the login page as our scope of testing is limited to the login page
        // This can be done in the tests themselves, but then you have code replication
        driver.navigate().refresh();
        driver.get(ConfigurationProvider.BaseURL);
    }

    @AfterAll
    public static void tearDown() {
        //The difference between quit() and close() is that quit() will close all the browser windows
        // while close() will only close the current window
        driver.quit();
    }
}
