package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        //launching the browser
        driver = new ChromeDriver();
        //getting the baseUrl
        driver.get(baseUrl);
        //managing the browser size
        driver.manage().window().maximize();
        // implicitly the browser timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }

}
