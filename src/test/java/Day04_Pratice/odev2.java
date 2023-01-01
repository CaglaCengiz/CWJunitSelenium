package Day04_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev2 {
    //Navigate to https://testpages.herokuapp.com/styled/index.html
// Click on Calculate under Micro Apps.
// Type any number in the first input.
// Type any number in the second input.
// Click on Calculate.
// Get the result.
// Print the result.

 //https://testpages.herokuapp.com/styled/index.html adresine gidin
// Mikro Uygulamalar altında Hesapla'ya tıklayın.
// İlk girişe herhangi bir sayı yazın.
// İkinci girdiye herhangi bir sayı yazın.
// Hesapla'ya tıklayın.
// Sonucu alın.
// Sonucu yazdırın.
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
   // driver.quit();
    }

    @Test
    public void test() {
        driver.get(" https://testpages.herokuapp.com/styled/index.html");

        // Mikro Uygulamalar altında Hesapla'ya tıklayın.
        driver.findElement(By.id("calculatetest")).click();

        // İlk girişe herhangi bir sayı yazın.
        driver.findElement(By.name("number1")).sendKeys("50");

        // İkinci girdiye herhangi bir sayı yazın.
        driver.findElement(By.xpath("//input[@id='number2']")).sendKeys("30");

        // Hesapla'ya tıklayın.
        driver.findElement(By.xpath("//input[@id='calculate']")).click();

        // Sonucu alınve  Sonucu yazdırın.
        System.out.println(driver.findElement(By.xpath("//span[@id='answer']")).getText());

    }
}