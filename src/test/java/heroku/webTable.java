package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class webTable {
    @Test
    void findTheLargestDue() {
        /*
        Open browser
        Navigate to https://the-internet.herokuapp.com/tables
        Focus on table 1
        The person who has largest due is "Doe Jacson"
         */
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> dues = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
        List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
        List<WebElement> firstNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        float maxDue = 0;
        String name = "";
        for (int i = 0; i < dues.size(); i++) {
            try{
                float due = Float.parseFloat(dues.get(i).getText().replace("$", ""));
                if (due > maxDue) {
                    maxDue = due;
                    name = firstNames.get(i).getText() + " " + lastNames.get(i).getText();
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing due: " + dues.get(i).getText());
                continue;
            }
        }
        Assert.assertEquals(name, "Jason Doe");

        driver.quit();
    }
}
