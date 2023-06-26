package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup (){

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        // enter the "standard_user" username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // enter the "secret_sauce password in the password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // enter the login button
        driver.findElement(By.id("login-button")).click();
        String expectedMessage = "Products";
        String actualMessage = driver.findElement(By.xpath("//span [text() = 'Products']")).getText();
        Assert.assertEquals("Products",expectedMessage,actualMessage);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // enter the "standard_user" username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // enter the "secret_sauce password in the password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // enter the login button
        driver.findElement(By.id("login-button")).click();
        // verify that six products are displayed on page
        String expectedMessage = "Sauce Labs Backpack\n" +
                "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n" +
                "$29.99\n" +
                "Add to cart\n" +
                "Sauce Labs Bike Light\n" +
                "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.\n" +
                "$9.99\n" +
                "Add to cart\n" +
                "Sauce Labs Bolt T-Shirt\n" +
                "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.\n" +
                "$15.99\n" +
                "Add to cart\n" +
                "Sauce Labs Fleece Jacket\n" +
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.\n" +
                "$49.99\n" +
                "Add to cart\n" +
                "Sauce Labs Onesie\n" +
                "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.\n" +
                "$7.99\n" +
                "Add to cart\n" +
                "Test.allTheThings() T-Shirt (Red)\n" +
                "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.\n" +
                "$15.99\n" +
                "Add to cart";
        String actualMessage = driver.findElement(By.className("inventory_list")).getText();
        Assert.assertEquals("six products are displayed",expectedMessage,actualMessage);

    }

    @After
    public void teardown(){
        //closeBrowser();
    }


}
