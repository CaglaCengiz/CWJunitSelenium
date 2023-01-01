package Odevler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ODEV_14 extends BaseTest {
 // Go to https://the-internet.herokuapp.com/download
//  Download sample.png file
//Then verify if the file downloaded successfully Ardından dosyanın başarıyla indirilip indirilmediğini kontrol edin

    @Test
    public void TEST() {
        driver.get("https://the-internet.herokuapp.com/download");

        WebElement samplePng = driver.findElement(By.linkText("sample.png"));
        samplePng.click();

        String downloadPath="C:\\Users\\ZK\\Downloads\\sample.png" ;
        Assert.assertTrue(Files.exists(Paths.get(downloadPath)));
    }
}
