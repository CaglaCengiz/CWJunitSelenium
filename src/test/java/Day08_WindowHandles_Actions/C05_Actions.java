package Day08_WindowHandles_Actions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.prefs.BackingStoreException;


public class C05_Actions extends BaseTest {
    @Override
    @After
    public void tearDown() {

    }

    @Test
     public void hoverOver(){
        driver.get("https://www.amazon.com.tr/");

        WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);

        // Hesaplar ve listeler alaninin ustune gelip siparislerim linkine tikladik
        actions
                .moveToElement(accountsAndLists)
                .click(driver.findElement(By.id("nav_prefetch_yourorders")))
                .perform();


        // Amazon login sayfasinin acildigini dogruladik
        Assert.assertEquals("Amazon Giriş Yap" , driver.getTitle());
    }

}
