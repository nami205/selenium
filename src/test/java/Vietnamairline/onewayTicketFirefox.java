package Vietnamairline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class onewayTicketFirefox {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setUp(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.geo", 2); // 1 = allow, 2 = deny
        profile.setPreference("permissions.default.desktop-notification", 2); // 1 = allow, 2 = deny
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    void testAbleChoseOneTicket() throws InterruptedException {
        driver.get("https://www.vietnamairlines.com/vn/vi/Home");
        //todo: accept cookie
        driver.findElement(By.xpath("//button[.='Đồng ý']")).click();
        //todo: select ngay di
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roundtrip-date-depart"))).click();
//        driver.findElement(By.id("roundtrip-date-depart")).click();
        //todo: select 1 chieu
        driver.findElement(By.id("oneway")).click();
        //todo: select 7/4/2025
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("roundtrip-date-depart"))).click();
        driver.findElements(By.cssSelector(".ui-datepicker-group-first a"))
                .stream()
                .filter(el -> el.getText().equals("11"))
                .findFirst()
                .get()
                .click();
        String departDate = driver.findElement(By.id("roundtrip-date-depart")).getDomProperty("value");
        Assert.assertEquals(departDate, "11/04/2025");

    }

        @AfterClass
                void exitWeb(){
//            driver.quit();
        }


}

