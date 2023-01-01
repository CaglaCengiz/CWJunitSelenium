package Day05_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_Checboxes {
    //    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown() {
         driver.quit();

    }
    @Test
    public void test1(){
        driver.get("https://demoqa.com/");
        WebElement elementsButton = driver.findElement(By.xpath("//div[@class='card mt-4 top-card']"));
        elementsButton.click();

        List< WebElement> checkBox = driver.findElements(By.xpath("//li[@id='item-1']"));
        checkBox.get(0).click();


        WebElement result = driver.findElement(By.xpath("//div[@class='pattern-backgound playgound-header']"));
        Assert.assertTrue(result.isDisplayed());
    }}