package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
//  https://api.jquery.com/ sitesine gidelim
//  arama alanina "json" yazalim
//  Enter islemini robot class kullanrak yapalim

public class ODEV_11 extends BaseTest {

    @Test
    public void robotTest() throws AWTException {
        driver.get("https://api.jquery.com/");
        WebElement arama= driver.findElement(By.name("s"));
        arama.sendKeys("json");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }
}
