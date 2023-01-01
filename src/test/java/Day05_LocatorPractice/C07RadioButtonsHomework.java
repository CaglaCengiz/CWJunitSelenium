package Day05_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07RadioButtonsHomework {
    //Go to URL: https://demoqa.com/radio-button
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
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
    public void radioButtonsHomework() {
        driver.get("https://demoqa.com/radio-button");//label[@for='yesRadio']
        WebElement yess= driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yess.click();
        WebElement Impressive= driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        Impressive.click();
        WebElement noo= driver.findElement(By.xpath("//label[@class='custom-control-label disabled']"));
        noo.click();
        System.out.println(yess.getText());
        System.out.println(Impressive.getText());
        System.out.println(noo.getText());

    }
}