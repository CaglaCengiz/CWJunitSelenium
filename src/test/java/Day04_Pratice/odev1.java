package Day04_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev1 {
    //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.
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
    public void test() {
        driver.get("https://id.heroku.com/login ");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("caglacengiz123");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("01234"+ Keys.ENTER);

        // test görünür ise " Kayıt Yapılamadı "  yazdir, eger gorunur degilse "  Kayıt Yapıldı" yazdir
       //      By.name("commit")
     WebElement gorunur= driver.findElement(By.name("commit"));
     if (gorunur.isDisplayed()==true){
         System.out.println("kayıt yapılmadı");
     }else System.out.println("kayıt yapıldı");

    }
}