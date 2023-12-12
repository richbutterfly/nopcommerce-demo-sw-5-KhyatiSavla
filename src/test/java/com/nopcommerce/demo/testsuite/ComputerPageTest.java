package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

/** 3. ComputerPageTest
 Inside ComputerPageTest class create following testmethods
 1. verifyUserShouldNavigateToComputerPageSuccessfully()
 Click on Computer tab
 Verify "Computer" text

 2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
 Click on Computer tab
 Click on Desktops link
 Verify "Desktops" text

 3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
 processor, String ram, String hdd, String os, String software)
 Click on Computer tab
 Click on Desktops link
 Click on product name "Build your own computer"
 Select processor "processor"
 Select RAM "ram"
 Select HDD "hdd"
 Select OS "os"
 Select Software "software"
 Click on "ADD TO CART" Button
 Verify message "The product has been added to your shopping cart"
 *
 */
@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    ComputerPage computerPage = new ComputerPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopPage = new DesktopPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        // Click on Computer tab
        homePage.clickOnComputers();
        // Verify "Computers" text
        Assert.assertEquals(computerPage.verifyComputerText(), "Computers");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // Click on Computer tab
        homePage.clickOnComputers();
        // Click on Desktops link
        computerPage.clickOnDesktops();
        // Verify "Desktops" text
        Assert.assertEquals(desktopPage.verifyTextDesktops(), "Computers");

    }

    @Test(groups = {"regression"},dataProvider = "DataSet",dataProviderClass = TestData.class)
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        // Click on Computer tab
        homePage.clickOnComputers();
        // Click on Desktops link
        computerPage.clickOnDesktops();
        // Click on product name "Build your own computer"
        desktopPage.clickOnBuildYourOwnComputer();
        // Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);
        // Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);
        // Select HDD "hdd"
        buildYourOwnComputerPage.selectHDD(hdd);
        // Select OS "os"
        buildYourOwnComputerPage.selectOS(os);
        // Select Software "software"
        buildYourOwnComputerPage.clickOnCheckBox3(software);
        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCart();
        // Verify message "The product has been added to your shopping cart"
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = buildYourOwnComputerPage.verifyTextProductAdded();
        Assert.assertEquals(expectedMsg, actualMsg);
    }

}
