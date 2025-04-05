package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesTest {
    @Test
    void tc02 (){
        /*
        Open browser
        Navigate to https://the-internet.herokuapp.com/checkboxes
        Check on checkbox1
        Verify checkbox1 is checked
        Check on checkbox2
        Verify checkbox2 is checked
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));


        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
//        Thread.sleep(1000);
        Assert.assertTrue(checkbox1.isSelected());

        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected());

        driver.quit();
    }

    void tc03(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        driver.get("https://moatazeldebsy.github.io/test-automation-practices/#/checkboxes");
//        wait.until(ExpectedCondition)


        driver.quit();

    }
}
