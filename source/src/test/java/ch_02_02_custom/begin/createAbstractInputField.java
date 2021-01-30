package ch_02_02_custom.begin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class createAbstractInputField {
     private static WebDriver driver;


    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterAll
    public static void  teardown(){

            driver.quit();
        }


    @Test
    public void testAbstractInputField() throws InterruptedException {

        WebElement inputfield = driver.findElement(By.id("username"));

        InputText input = new InputText(inputfield);

        input.sendkeys("tomsmith");

        Thread.sleep(1000);
    }

    private class InputText implements WrapsElement {

        private final WebElement input;

        public InputText(WebElement inputfield){
            this.input = inputfield;
        }


        @Override
        public WebElement getWrappedElement() {
            return input;
        }

        public void sendkeys(String username){

            input.sendKeys(username);


        }
    }
}

