package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class ODEV_08 extends BaseTest {
   // Go to URL: http://demo.guru99.com/test/guru99home/
   // Find the number of iframes on the page.
   // Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
   // Exit the iframe and return to the main page.,
    // Sayfadaki iframe sayısını bulun.
    // Dördüncü iframe bağlantısı (JMeter Made Easy) (https://www.guru99.com/live Selenium project.html) buraya tıklayın.
    // iframe'den çıkın ve ana sayfaya dönün.,



 @Test
public void iframe(){
    driver.get("http://demo.guru99.com/test/guru99home/");
    String anasayfaID= driver.getWindowHandle();
    List<WebElement>listFrame=driver.findElements(By.xpath("//iframe"));
    System.out.println(listFrame.size());
     driver.switchTo().frame("a077aa5e");
    driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
    driver.switchTo().defaultContent();
    driver.switchTo().window(anasayfaID);


}}