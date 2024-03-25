package org.example.LoginPageTests;

import org.example.Common.ConfigurationProvider;
import org.example.Pages.LoggedInSuccessfullyPage;
import org.example.Pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends TestConfiguration {

    // We create an instance of the Login Page class and call the methods that we want to test
    // We will use the driver from the TestConfiguration class, BeforeAll method
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void testCase1_PositiveLogInTest() {
        // We will wait for the page to load,then enter credentials and click on login button
        loginPage.attemptToLoginWithGivenCredentials(ConfigurationProvider.validLoginUsername, ConfigurationProvider.validLoginPassword);

        // After we click the login button we are redirected to the Logged In Successfully page
        // We need to state this in our test
        LoggedInSuccessfullyPage loggedInSuccessfullyPage = new LoggedInSuccessfullyPage(TestConfiguration.driver);

        // We will verify if the page title is correct,
        // if the page source contains the text "Logged In Successfully" and if the Log out button is displayed
        Assertions.assertEquals(LoggedInSuccessfullyPage.TabTitle, driver.getTitle());
        Assertions.assertTrue(driver.getPageSource().contains("Logged In Successfully"));
        Assertions.assertTrue(loggedInSuccessfullyPage.logOutButtonIsDisplayed());
    }

    @Test
    public void testCase2_NegativeUsernameTest() {
        // As in the test above we will attempt to Login, but this time with invalid username
        loginPage.attemptToLoginWithGivenCredentials(ConfigurationProvider.invalidLoginUsername, ConfigurationProvider.validLoginPassword);

        // We will verify if the error message is displayed
        // and if the page source contains the text "Your username is invalid!"
        Assertions.assertTrue(loginPage.errorMessageIsDisplayed());
        Assertions.assertTrue(driver.getPageSource().contains("Your username is invalid!"));
    }

    @Test
    public void testCase3_NegativePasswordTest() {
        // As in the test above we will attempt to Login, but this time with invalid password
        loginPage.attemptToLoginWithGivenCredentials(ConfigurationProvider.validLoginUsername, ConfigurationProvider.invalidLoginPassword);

        // We will verify if the error message is displayed
        // and if the page source contains the text "Your password is invalid!"
        Assertions.assertTrue(loginPage.errorMessageIsDisplayed());
        Assertions.assertTrue(driver.getPageSource().contains("Your password is invalid!"));
    }
}
