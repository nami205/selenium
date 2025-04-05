package heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    @Test
    void testAbleDropdown(){
        /*
        Open browser

        Navigate to https://the-internet.herokuapp.com/dropdown

        Select "option 1"

        Validate "option 1" is selected
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        Assert.assertTrue(dropdown.getFirstSelectedOption().isSelected());

        dropdown.selectByIndex(2);
        Assert.assertTrue(dropdown.getOptions().equals("Option 2"));


        driver.quit();
    }
}
