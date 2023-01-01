package Taskler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class AmazonMulakat extends BaseTest {
   /* Proje Hazırlanırken Dikkat Edilmesi Gerekenler

● Proje Java programlama dilinde yazılmalıdır.
● Kodlar GitHub üzerinden paylaşılması gereklidir.
            (Fmharmanci ve VirgosolQA kullanıcı adları ile proje paylaşılacaktır.)
            ● Yazılacak senaryo için Selenium ve JUnit kullanılmalıdır.
● Assertions kullanarak senaryonun doğru çalışırlığı kontrol edilmelidir.
● Log4j kullanılmalıdır.
            ● Page Object Model uygulanmalıdır.
            ● OOP prensiplerine uygun geliştirilmelidir.
    Projeyi aşağıdaki senaryoya uygun olarak hazırlamalısın.*/

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


    @Override
    @After
    public void tearDown() {

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");

        // Ana sayfanın açıldığı kontrol edilir.
        WebElement anasayfaKontrol= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(anasayfaKontrol.isDisplayed());
        //  String currentURL = driver.getCurrentUrl();
        //  Assert.assertTrue("url amazon içermiyor", currentURL.contains("amazon"));

        // Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement cerezleriKabul= driver.findElement(By.id("sp-cc-accept"));
        cerezleriKabul.click();

        // Siteye login olunur.
        Actions action=new Actions(driver);

        WebElement login=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        login.click();

      WebElement emailyazma=driver.findElement(By.xpath("//input[@id='ap_email']"));
       emailyazma.sendKeys("45gereksiz@gmail.com"+ Keys.ENTER);

       WebElement sifreyazma=driver.findElement(By.xpath("//input[@id='ap_password']"));
       sifreyazma.sendKeys("Ders4545"+Keys.ENTER);
       //WebElement emailInput = driver.findElement(By.xpath("//input[@name='email']"));

       //String mail = "45gereksiz@gmail.com";

       //String mailPassword = "Ders4545";

       //emailInput.sendKeys(mail + Keys.ENTER);

       //Actions actions = new Actions(driver);

       //actions.sendKeys(mailPassword).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

//        o Login işlemi kontrol edilir.
        WebElement logincontrol=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        action.moveToElement(logincontrol).perform();

        // Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
      WebElement searchDropDownBox = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        searchDropDownBox.click();

        Select select= new Select(searchDropDownBox);
        select.selectByValue("search-alias=computers");

//    Bilgisayar kategorisi seçildiği kontrol edilir.
        Assert.assertTrue(searchDropDownBox.getText().contains("Bilgisayarlar"));

        // Arama alanına MSI yazılır ve arama yapılır.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("MSI" + Keys.ENTER);

        // Arama yapıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-normal']")).isDisplayed());
       // o Arama yapıldığı kontrol edilir.
      //  WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

      //  System.out.println(result.getText());
      //  Assert.assertTrue(result.getText().contains("MSI"));
        // Arama sonuçları sayfasından 2. sayfa açılır.
      //  JavascriptExecutor jse = (JavascriptExecutor) driver;
      //  WebElement ikincSayfa = driver.findElement(By.linkText(" 2 sayfasına git"));
      //  jse.executeScript("arguments[0].scrollIntoView();" ,ikincSayfa);
      //  action.click(ikincSayfa).perform();
       // // o Arama sonuçları sayfasından 2. sayfa açılır.
        Actions actions=new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN).perform();
//
       WebElement page2 = driver.findElement(By.cssSelector("[aria-label=\"2 sayfasına git\"]"));
//
       actions.click(page2).perform();

        // 2. sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.linkText("Geçerli sayfa, sayfa 2")).isDisplayed());

        // Sayfadaki 2. ürün favorilere eklenir.
      //  WebElement urunIkiSectim = driver.findElement(By.xpath("//div[@data-index=\"2\"]"));
        WebElement ikinciUrun=driver.findElement(By.xpath("((//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();

        WebElement listeyeEkle=driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-submit']"));
        listeyeEkle.click();

        WebElement listeGoruntele=driver.findElement(By.linkText("Sepete Git"));
        listeGoruntele.click();

        //   2. Ürünün favorilere eklendiği kontrol edilir.
        WebElement ikinciUrunEklımı=driver.findElement(By.linkText("Listenizi Görüntüleyin"));
        Assert.assertTrue(ikinciUrunEklımı.isDisplayed());
        action.sendKeys(Keys.ESCAPE).perform();

       /* // Hesabım > Favori Listem sayfasına gidilir.
        WebElement hesabvelıste=driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(hesabvelıste).perform();
        WebElement  alısverişListesi= driver.findElement(By.linkText("Alışveriş Listesi"));
        alısverişListesi.click();

        // “Favori Listem” sayfası açıldığı kontrol edilir.
        WebElement alısverişlistesiControl=driver.findElement(By.className("nav-cart-icon nav-sprite"));
        Assert.assertTrue(alısverişlistesiControl.getText().contains("Listesi"));

        // Eklenen ürün favorilerden silinir.
        WebElement favDeleteButton=driver.findElement(By.id("delete-button-I391HRJ9TA8EM3-announce"));
        action.moveToElement(favDeleteButton).click(favDeleteButton).perform();

        // Silme işleminin gerçekleştiği kontrol edilir.
        WebElement deletedMessage=driver.findElement(By.xpath("//div[@class='a-alert-content'][text()='Silindi']"));
        Assert.assertTrue(deletedMessage.isDisplayed());

        // Üye çıkış işlemi yapılır.
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).perform();
        WebElement cıkısYap=driver.findElement(By.id("nav-item-signout"));
        cıkısYap.click();

        // Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertEquals("Amazon Giriş Yap", driver.getTitle());*/
    }


    }

