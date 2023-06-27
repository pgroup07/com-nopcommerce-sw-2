package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the ‘Computers’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']")).click();
        String expectedMessage = "Computers";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //Verify the text ‘Computers’
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //click on the ‘Electronics’ Tab
        driver.findElement(By.xpath("//a[text()='Electronics ']")).click();
        String expectedMessage = "Electronics";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        // Verify the text ‘Electronics’
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        //click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();
        String expectedMessage = "Apparel";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //  Verify the text ‘Apparel’
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //click on the ‘Digital downloads’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']")).click();
        String expectedMessage = "Digital downloads";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //Verify the text ‘Digital downloads'
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //click on the ‘Books’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']")).click();
        String expectedMessage = "Books";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //Verify the text ‘Books
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //click on the ‘Jewelry’ Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']")).click();
        String expectedMessage = "Jewelry";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //Verify the text ‘Jewelry'
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        // click on the ‘Gift Cards’Tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']")).click();
        String expectedMessage = "Gift Cards";
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();
        //Verify the text ‘Gift Cards'
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closerBrowser();
    }

}