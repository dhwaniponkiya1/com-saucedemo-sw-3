package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;


public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(this.baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValid() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));                           //Click on login button
        Assert.assertEquals("PRODUCTS", getTextFromElement(By.xpath("//span[text()='Products']")).toUpperCase());                                                                         //Compare 2 strings
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.id("login-button"));

        Assert.assertEquals("User cannot see 6 products.", 6, driver.findElements(By.className("inventory_item")).size());
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}