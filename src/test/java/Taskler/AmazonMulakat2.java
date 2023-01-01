package Taskler;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class AmazonMulakat2 extends BaseTest {
    @Test
    public void test()  {
        // https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.com.tr/");
        // Ana sayfanın açıldığı kontrol edilir.
        String homePageTitle=driver.getTitle();
        Assert.assertEquals( "Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi", homePageTitle);
        // Çerez tercihlerinden Çerezleri kabul et seçilir.
        WebElement acceptCookiesButton= driver.findElement(By.id("a-autoid-0"));
        acceptCookiesButton.click();
        // Siteye login olunur.
        Actions action=new Actions(driver);
        WebElement loginHoverPoint=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        WebElement loginButton=driver.findElement(By.xpath("//span[@class='nav-action-inner']"));
        action.moveToElement(loginHoverPoint)
                .click(loginButton)
                .perform();
        WebElement emailInput= driver.findElement(By.id("ap_email"));
        emailInput.sendKeys("isim@gmail.com"+ Keys.ENTER);
        action.sendKeys("şifre"+ Keys.ENTER)
                .perform();
        // Login işlemi kontrol edilir.
        WebElement userNamePointer=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(!userNamePointer.getText().contains("Giriş yapın"));
        // Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement searchDropBox=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(searchDropBox);
        select.selectByValue("search-alias=computers");
        // Bilgisayar kategorisi seçildiği kontrol edilir.
        WebElement kategoriPC=driver.findElement(By.id("nav-search-label-id"));
        Assert.assertEquals("Bilgisayarlar", kategoriPC.getText());
        // Arama alanına MSI yazılır ve arama yapılır.
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("MSI"+Keys.ENTER);
        // Arama yapıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base a-text-normal']")).isDisplayed());
        // Arama sonuçları sayfasından 2. sayfa açılır.
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement secondPage=driver.findElement(By.linkText("2"));
        jse.executeScript("arguments[0].scrollIntoView();" ,secondPage);
        action.click(secondPage).perform();
        // 2. sayfanın açıldığı kontrol edilir.
        WebElement secondPcontrol=driver.findElement(By.xpath("//*[text()='2']"));
        Assert.assertTrue(secondPcontrol.getText().contains("2"));
        // Sayfadaki 2. ürün favorilere eklenir.
        WebElement secondProduct=driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        secondProduct.click();
        WebElement wishListButton=driver.findElement(By.id("add-to-wishlist-button"));
        wishListButton.click();
        WebElement wishList=driver.findElement(By.id("atwl-list-name-LCBZWZ79LMDD"));
        wishList.click();
        //   2. Ürünün favorilere eklendiği kontrol edilir.
        WebElement secondProductWishlistcontrol=driver.findElement(By.xpath("//*[text()='1 ürün şuraya eklendi:']"));
        Assert.assertTrue(secondProductWishlistcontrol.isDisplayed());
        action.sendKeys(Keys.ESCAPE).perform();
        // Hesabım > Favori Listem sayfasına gidilir.

        WebElement hoverPointForWishList=driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(hoverPointForWishList).perform();
        WebElement  shoppingListClick= driver.findElement(By.linkText("Alışveriş Listesi"));
        shoppingListClick.click();
        // “Favori Listem” sayfası açıldığı kontrol edilir.
        WebElement shoppingListPage=driver.findElement(By.id("profile-list-name"));
        Assert.assertTrue(shoppingListPage.getText().contains("Listesi"));
        // Eklenen ürün favorilerden silinir.
        WebElement favDeleteButton=driver.findElement(By.id("delete-button-I391HRJ9TA8EM3-announce"));
        action.moveToElement(favDeleteButton).click(favDeleteButton).perform();
        // Silme işleminin gerçekleştiği kontrol edilir.
        WebElement deletedMessage=driver.findElement(By.xpath("//div[@class='a-alert-content'][text()='Silindi']"));
        Assert.assertTrue(deletedMessage.isDisplayed());
        // Üye çıkış işlemi yapılır.
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).perform();
        WebElement signOutbutton=driver.findElement(By.id("nav-item-signout"));
        signOutbutton.click();
        // Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertEquals("Amazon Giriş Yap", driver.getTitle());
    }
}
