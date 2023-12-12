package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/** 2. RegisterPageTest
 Inside RegisterPageTest class create following testmethods
 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
 Click on Register Link
 Verify "Register" text
 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandator
 y()
 Click on Register Link
 Click on "REGISTER" button
 Verify the error message "First name is required."
 Verify the error message "Last name is required."
 Verify the error message "Email is required."
 Verify the error message "Password is required."
 Verify the error message "Password is required."

 2. verifyThatUserShouldCreateAccountSuccessfully()
 Click on Register Link
 Select gender "Female"
 Enter firstname
 Enter lastname
 Select day
 Select month
 Select year
 Enter email
 Enter password
 Enter Confirm Password
 Click on "REGISTER" button
 Verify message "Your registration completed"
 *
 */
@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();
    HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)

    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on Register Link
        homePage.clickOnRegisterLink();
        // Verify "Register" text
        registerPage.verifyRegisterText();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify the error message "First name is required."
        Assert.assertEquals(registerPage.verifyTextFirstNameIsRequired(), "First name is required.");
        // Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.verifyTextLastNameIsRequired(), "Last name is required.");
        // Verify the error message "Email is required."
        Assert.assertEquals(registerPage.verifyTextEmailIsRequired(), "Email is required.");
        // Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyTextPasswordIsRequired(), "Password is required.");
        // Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyTextConfirmPasswordIsRequired(), "Password is required.");
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.selectGenderFemale();
        // Enter firstname
        registerPage.enterFirstName("Spider");
        // Enter lastname
        registerPage.enterLastName("Black");
        // Select day
        registerPage.selectDayOfBirth("1");
        // Select month
        registerPage.selectDateOfBirthMonth("January");
        // Select year
        registerPage.selectDateOfBirthYear("1990");
        // Enter email
        registerPage.enterEmailId("Blackspider123@gmail.com");
        // Enter password
        registerPage.enterPassword("spider123");
        // Enter Confirm Password
        registerPage.enterConfirmPassword("spider123");
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify message "Your registration completed"
        Assert.assertEquals(registerPage.verifyTextRegistrationComplete(), "Your registration completed");


    }
}
