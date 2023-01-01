package Day08_WindowHandles_Actions;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C06_Actions extends BaseTest {
    @Override
    @After
    public void tearDown() {

    }

    @Test
    public void keyboardActions(){
        driver.get("https://demoqa.com/auto-complete");
        WebElement input= driver.findElement(By.id("autoCompleteSingleContainer"));
        Actions actions=new Actions(driver);
        actions.click(input)
                .keyDown(Keys.SHIFT)
                .sendKeys("y")
                .keyUp(Keys.SHIFT)
                .sendKeys("ou are")
                .keyDown(Keys.SHIFT)
                .sendKeys("e")
                .keyUp(Keys.SHIFT)
                .sendKeys("xceptional").perform();
    }
}
