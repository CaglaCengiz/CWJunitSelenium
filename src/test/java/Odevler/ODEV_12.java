package Odevler;

      //  Go to URL: http://facebook.com
      //  getCookies,
      //  addCookie,
      //  deleteCookieNamed,
      //  deleteAllCookies.

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class ODEV_12 extends BaseTest {
    @Override
    @After
    public void tearDown() {

    }

    @Test
    public void TestCookies() {
        driver.get("http://facebook.com");

        //  getCookies,
        Set<Cookie>allCookies=driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());

        //  addCookie,
        Cookie co1=new Cookie("yemek","mantı");
        driver.manage().addCookie(co1);
        allCookies=driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());

        //  deleteCookieNamed,
        driver.manage().deleteCookie(co1);
        allCookies=driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());

        //  deleteAllCookies.
        driver.manage().deleteAllCookies();
        allCookies=driver.manage().getCookies();
        System.out.println("allCookies.size() = " + allCookies.size());


    }
}
