package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

       //Enter valid username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

        //Enter valid password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //*	Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(5000);
    }

    @Test

    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter valid username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

        //Enter valid password
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Verify that six products

        List<WebElement> sixProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));

        // Verify that six products are displayed on page
        if (sixProducts.size() == 6) {
            System.out.println("Six products are displayed on the page.");
        } else {
            System.out.println("Number of displayed products is not six.");
        }


    }

    @After

    public void tearDown(){
        closeBrowser();
    }
}