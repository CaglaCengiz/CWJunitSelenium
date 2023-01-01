import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class calısma1 {
    // 1) Tarayıcıyı açın
    // 2) "http://practice.automationtesting.in/"  URL'sini girin
    // 3) Mağaza Menüsüne tıklayın
    // 4) Şimdi Ana menü düğmesine  tıklayın
    //5) Ana sayfanın yalnızca Üç Kaydırıcısı olup olmadığını test edin
    // 6) Ana sayfa yalnızca üç kaydırıcı içermelidir
//    1) Open the browser
//2) Enter the URL “http://practice.automationtesting.in/”
//            3) Click on Shop Menu
//4) Now click on Home menu button
//5) Test whether the Home page has Three Sliders only
//6) The Home page must contains only three sliders
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
      //  driver.quit();

    }

    @Test
    public void Test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1-->git->"https://amazon.com"
        driver.get("https://amazon.com");
        //2-->arama kutusundan "all" dan "Electronic" seç
        Select select = new Select(driver.findElement(By.cssSelector("#searchDropdownBox")));
        select.selectByValue("search-alias=electronics-intl-ship");
        //3-->arama butonuna "tv" yazdır
        driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("tv" + Keys.ENTER);
        //4-->"2. sayfaya" git
        driver.findElement(By.xpath("//a[@aria-label=\"Go to page 2\"]")).click();
        //5-->tv  sepete ekle

        driver.findElement(By.xpath("(//input[@data-index='5']//a)[2]")).click();
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        //6-->sepete git
        driver.findElement(By.xpath("//span[@id=\"nav-cart-count\"]")).click();
        //7-->Proceed to checkout' a tıkla
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        //8-->"Email or mobile phone number" gir
        driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ebikgabık@gmail.com");
        //9-->"continue" butonuna tıkla
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        //10--->"There was a problem" yazısının görüntülendiğini kontrol et
        Assert.assertTrue(driver.findElement(By.xpath("//h4[.='There was a problem']")).isDisplayed());
        //11-->Taraycı kapat
        driver.quit();



    }
}