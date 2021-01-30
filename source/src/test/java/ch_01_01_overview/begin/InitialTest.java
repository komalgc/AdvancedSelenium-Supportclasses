package ch_01_01_overview.begin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class InitialTest {

    private static WebDriver driver;

    @BeforeAll
    public static void createDriver() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.get("https://eviltester.github.io/supportclasses/");
    }

    @Test
    public void anInitialTest() {

        Assertions.assertEquals("Support Classes Example", driver.getTitle());
    }

    @AfterAll
    public static void closeDriver() {

        driver.quit();
    }
}
