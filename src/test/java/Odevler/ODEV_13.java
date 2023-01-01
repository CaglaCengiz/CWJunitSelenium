package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ODEV_13 extends BaseTest {
   // Go to URL: https://www.monsterindia.com/seeker/registration
 //   Upload file.

    @Test
    public void uploafFile()  {
        driver.get("https://www.monsterindia.com/seeker/registration");
        String filePath="C:\\Users\\ZK\\Desktop\\buyuk klasor";
        WebElement dosyaIndır = driver.findElement(By.id("file-upload"));

        dosyaIndır.sendKeys(filePath);
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
      
    }
}
