package Taskler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.time.Duration;
//          Amazon Senaryosu

// o https://www.amazon.com.tr/ sitesi açılır.
// o Ana sayfanın açıldığı kontrol edilir.
// o  Çerez tercihlerinden Çerezleri kabul et seçilir.
// o  Siteye login olunur.
// o Login işlemi kontrol edilir.
// o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
// o Bilgisayar kategorisi seçildiği kontrol edilir.
// o Arama alanına MSI yazılır ve arama yapılır.
// o Arama yapıldığı kontrol edilir.
// o Arama sonuçları sayfasından 2. sayfa açılır.
// o 2. sayfanın açıldığı kontrol edilir.
// o Sayfadaki 2. ürün favorilere eklenir.
// o 2. Ürünün favorilere eklendiği kontrol edilir.
// o Hesabım > Favori Listem sayfasına gidilir
// o “Favori Listem” sayfası açıldığı kontrol edilir.
// o Eklenen ürün favorilerden silinir.
// o Silme işleminin gerçekleştiği kontrol edilir.
// o Üye çıkış işlemi yapılır.
// o Çıkış işleminin yapıldığı kontrol edilir.

public class AmazonMulakat1  {
    WebDriver driver;
    Actions actions;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);

    }
    @After
    public void teardown(){
       // driver.quit();
    }

    @Test
    public void amazon() throws InterruptedException {

//        o https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://amazon.com.tr");
//        o Ana sayfanın açıldığı kontrol edilir.
        Assert.assertEquals("https://www.amazon.com.tr/",driver.getCurrentUrl());
//        o  Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement cerez = driver.findElement(By.id("sp-cc-accept"));
        cerez.click();
//        o  Siteye login olunur.
        WebElement hesaplar = driver.findElement(By.cssSelector("[data-nav-ref=\"nav_ya_signin\"]"));
        hesaplar.click();
        WebElement mailGir = driver.findElement(By.cssSelector("[id=\"ap_email\"]"));
        String mail="45gereksiz@gmail.com";
        String mailPass= "Ders4545";
        mailGir.sendKeys(mail+ Keys.ENTER);
        actions.sendKeys(mailPass).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
//        o Login işlemi kontrol edilir.
        WebElement loginMi = driver.findElement(By.cssSelector("[class=\"nav-line-1-container\"]"));
        Assert.assertTrue(loginMi.isDisplayed());
//        o Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement dropbox = driver.findElement(By.cssSelector("[aria-describedby=\"searchDropdownDescription\"]"));
        Select select= new Select(dropbox);
        select.selectByValue("search-alias=computers");
//        o Bilgisayar kategorisi seçildiği kontrol edilir.
        Assert.assertTrue(dropbox.getText().contains("Bilgisayarlar"));
//        o Arama alanına MSI yazılır ve arama yapılır.
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).sendKeys("MSI").sendKeys(Keys.ENTER).perform();
//        o Arama yapıldığı kontrol edilir.
        WebElement sonuc = driver.findElement(By.cssSelector("[class=\"s-desktop-width-max sg-row-align-items-center sg-row\"]"));
//        o Arama sonuçları sayfasından 2. sayfa açılır.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement sayfa2 = driver.findElement(By.cssSelector("[aria-label=\"2 sayfasına git\"]"));
        actions.click(sayfa2).perform();

//        o 2. sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.linkText("2")).isDisplayed());
//
//        o Sayfadaki 2. ürün favorilere eklenir.
        WebElement urunIkiSectim = driver.findElement(By.xpath("//div[@data-index=\"2\"]"));
        urunIkiSectim.click();

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement listeyeEkle = driver.findElement(By.id("wishListMainButton"));
        listeyeEkle.click();
//        o 2. Ürünün favorilere eklendiği kontrol edilir.
        WebElement listeGoruntule =driver.findElement(By.xpath("//a[.='Listenizi Görüntüleyin']"));
        listeGoruntule.click();

        WebElement listedeurunVarmi = driver.findElement(By.xpath("(//div[@class=\"a-fixed-left-grid-col g-item-sortable-draggable-area a-col-left\"])[1]"));
        Assert.assertTrue(listedeurunVarmi.isDisplayed());
//        o Hesabım > Favori Listem sayfasına gidilir.
        actions.moveToElement(hesaplar).build();
        WebElement listem = driver.findElement(By.xpath("//span[.='Alışveriş Listesi']"));
        listem.click();
//        o “Favori Listem” sayfası açıldığı kontrol edilir.
        WebElement kaldirButonu =driver.findElement(By.name("submit.deleteItem"));
        Assert.assertTrue(kaldirButonu.isDisplayed());
//        o Eklenen ürün favorilerden silinir.
        actions.click(kaldirButonu).perform();
//        o Silme işleminin gerçekleştiği kontrol edilir.
        WebElement silindiMi =driver.findElement(By.xpath("//div[@id=\"wl-item-view\"]"));
        Assert.assertTrue(silindiMi.isDisplayed());
//        o Üye çıkış işlemi yapılır.
        WebElement hesaplarVeList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(hesaplarVeList).perform();
        WebElement cikisYap = driver.findElement(By.xpath("//span[.='Çıkış Yap']"));
        cikisYap.click();
//        o Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertEquals("Amazon Giriş Yap", driver.getTitle());
    }
}
