package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    @Test
    void tc01(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type=submit]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");

        driver.quit();
    }
}
