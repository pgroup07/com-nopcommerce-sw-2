package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find the login Link and click on Login link
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        String expectedText = "Welcome, Please Sign In!";
        String actualText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Not Redirected to Login Page", expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        RegisterTest registerTest = new RegisterTest();
        registerTest.userShouldRegisterAccountSuccessfully();
        String email = registerTest.email;

        // Find the login link and click on login link
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        // Enter valid username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        // Enter valid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin123");
        // Click on Login Button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        // Click on Logout Button

        String actualMessage = "Log out";
        String expectedMessage = driver.findElement(By.xpath("//a[text()='Log out']")).getText();
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);

        // Check Assert or Not
    }

    @Test
    public void verifyTheErrorMessage() {
        // Find the login link and click on login link
        driver.findElement(By.linkText("Log in")).click();
        // Enter invalid username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("kjg552@gmail.com");
        // Enter invalid password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Hgf987");
        // Click on Login Button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closerBrowser();
    }

}
