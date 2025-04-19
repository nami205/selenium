package Vietnamairline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class register {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    void testRegister() throws InterruptedException {
        /*
        open browser
        navigate to https://www.vietnamairlines.com/vn/vi/Home
        select 1 chieu
        select day 7/4/2025
        verify day selected


         */
//        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.vietnamairlines.com/vn/vi/Home");
        // todo: accept cookie
        driver.findElement(By.xpath("//button[.='Đồng ý']")).click();
        // todo: select ngay di
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roundtrip-date-depart"))).click();
        // todo: select 1 chieu
        driver.findElement(By.id("oneway")).click();
        // todo: select 7/4/2025
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roundtrip-date-depart"))).click();
        driver.findElements(By.cssSelector(".ui-datepicker-group-first a"))
                .stream()
                .filter(el -> el.getText().equals("15"))
                .findFirst()
                .get()
                .click();

    }
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
