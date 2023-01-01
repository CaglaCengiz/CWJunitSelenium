package Day09_JSEScroll_Cookies_Files;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class C04_Cookies extends BaseTest {
  // Go to URL: https://kitchen.applitools.com/ingredients/cookie
  // Get Cookie.
  // Find the total number of cookies.
  // Print all the cookies.
  // Add Cookie.
  // Edit Cookie.
  // Delete Cookie.
  // Delete All Cookies.
    // Toplam çerez sayısını bulun.
    // Tüm çerezleri yazdır.
    // Çerez Ekle.
    // Tanımlama Bilgisini Düzenle.
    // Çerezi Sil.
    // Tüm Çerezleri Sil.

    @Test
    public void testCookie() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        System.out.println("test get cookie");
        Cookie cookie=driver.manage().getCookieNamed("protein");//isimle çagırdık
        Assert.assertEquals("chicken",cookie.getValue());

        // Find the total number of cookies.
        Set<Cookie>allCookies=driver.manage().getCookies();
        int numOfCookies=allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies);

        // Print all the cookies.
        for (Cookie each:allCookies) {
            System.out.println("each cookie :" + each);
            System.out.println("each cookie name :" +each.getName());
            System.out.println("each cookie value:" +each.getValue());

        }
        // Add Cookie.
        System.out.println("add cookie");
        Cookie cookie1=new Cookie("fruit" ,"apple");//cookie olusturduk
        driver.manage().addCookie(cookie1);//cookie ekledik
        Assert.assertEquals(cookie1.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        allCookies=driver.manage().getCookies();//sayfada var olan cookie leri dondurur
        System.out.println("allCookies = " + allCookies.size());//allCookies = 3

        // Edit Cookie.
        System.out.println(" Edit Cookie");
        Cookie editedCookie=new Cookie(cookie1.getName(),"mango");
        driver.manage().addCookie(editedCookie);
        Assert.assertEquals(editedCookie.getValue(),driver.manage().getCookieNamed(cookie1.getName()).getValue());
        System.out.println(driver.manage().getCookieNamed(cookie1.getName()).getValue()); //mango

    }
   //delete cookies
    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numOfCookies = allCookies.size();
        System.out.println("numOfCookies = " + numOfCookies); //numOfCookies = 2

        Cookie addedCookie = new Cookie("drinks", "ayran"); //cookie olusturduk
        driver.manage().addCookie(addedCookie); //cookie ekledik
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 3

        System.out.println("delete cookies");
        driver.manage().deleteCookie(addedCookie); // cookie sildik
        Assert.assertNull("cookie halen var", driver.manage().getCookieNamed(addedCookie.getName())); //PASSED
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); //allCookies = 2

        driver.manage().deleteAllCookies(); //browserdan hepsi sildik
        allCookies = driver.manage().getCookies(); // sayfada var olan cookieleri dondurur
        System.out.println("allCookies = " + allCookies.size()); // allCookies = 0

    }
}
