package testsuite;
/*
2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’
2. verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }
    /*
    1. userShouldNavigateToLoginPageSuccessfully
    * click on the ‘Sign In’ link
    * Verify the text ‘Welcome Back!’

     */
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Click on the 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();

        // Verify the text 'Welcome Back!'
        String actualText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]")).getText();
        String expectedText = "Welcome Back!";
        Assert.assertEquals(actualText, expectedText);
    }

    /*
    2. verifyTheErrorMessage
    * click on the ‘Sign In’ link
    * Enter invalid username
    * Enter invalid password
    * Click on Login button
    * Verify the error message ‘Invalid email or password.’
     */
    @Test
    public void verifyTheErrorMessage() {
        // Click on the 'Sign In' link
        driver.findElement(By.linkText("Sign In")).click();
        // Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime123@gmail.com");    //Enter invalid email
        // Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("prime123");           //Enter invalid password
        // Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();         //Click on submit button
        // Verify the error message 'Invalid email or password.'
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("User not able to login with invalid data.", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
