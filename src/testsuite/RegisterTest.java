package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    String email;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@class='header-upper']//a[text()='Register']")).click();
        String expectedMessage = "Register";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //Verify the text ‘Register’
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {

        String uuid = UUID.randomUUID().toString();
        email = "admin" + uuid + "@gmail.com";

        // click on the ‘Register’ link
        driver.findElement(By.xpath("//div[@class='header-upper']//a[text()='Register']")).click();
        // Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-male']")).click();


        // Enter First name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("joy");


        // Enter Last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Cash");


        //Select Day Month and Year
        Select select = new Select(driver.findElement(By.name("DateOfBirthDay")));
        select.selectByVisibleText("4");
        // driver.findElement(By.xpath("//div[@class='form-fields']//label[text()='Date of birth:']")).click();

        select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        select.selectByVisibleText("March");

        select = new Select(driver.findElement(By.name("DateOfBirthYear")));
        select.selectByVisibleText("1992");
        // Enter Email address
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

        //  Enter Password
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("admin123");

        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("admin123");

        // Click on REGISTER button
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

    }

    @After
    public void tearDown() {
        closerBrowser();
    }
}
