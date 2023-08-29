import common.DriverHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LunoPage;

public class LunoWebsite extends DriverHandler {

    LunoPage homePage;
    String validusername = getProp().getProperty("validusername");
    String invalidusername = getProp().getProperty("invalidusername");

    String validpassword = getProp().getProperty("validpassword");
    String invalidpassword = getProp().getProperty("invalidpassword");


    LunoPage lunoPage;

    @BeforeMethod
    public void setUp() {
        startBrowser();
        homePage = new LunoPage();
    }

    @Test(priority = 1)
    public void InvalidsignUp() {

        lunoPage.enterUsername(invalidusername);
        lunoPage.enterPassword(invalidpassword);
        lunoPage.clickletsGobutton();
        Assert.assertTrue(driver.getTitle()=="signup");
    }
    @Test(priority = 2)
    public void validsignUp() {

        lunoPage.enterUsername(validusername);
        lunoPage.enterPassword(validpassword);
        lunoPage.clickletsGobutton();
        Assert.assertTrue(driver.getTitle()=="confirm_email");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
