package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.util.Set;

public class ODEV_10 extends BaseTest {
  // Go to URL: https://demoqa.com/browser-windows
  // Click on the windows - "WindowButton"
  // Click on all the child windows.
  // Print the text present on all the child windows in the console.
  // Print the heading of the parent window in the console.
    // URL'ye gidin: https://demoqa.com/browser-windows
    // Pencerelere tıklayın - "Pencere Düğmesi"
    // Tüm alt pencerelere tıklayın.
    // Konsoldaki tüm alt pencerelerde bulunan metni yazdırın.
    // Ana pencerenin başlığını konsolda yazdır.
    @Test
    public void test01(){
        driver.get("https://demoqa.com/browser-windows");
        String homePage= driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();
       // driver.findElement(By.id("messageWindowButton")).click();
        Set<String>windows=driver.getWindowHandles();
        String secondPageHandle="";
        for (String each:windows){
            if (!each.equals(homePage)){
                secondPageHandle=each;
            }
        }
        System.out.println("Text on the child window:" + driver.findElement(By.tagName("body")).getText());
        driver.switchTo().window(homePage);
        System.out.println("Heading of the parent window: " + driver.getTitle());
    }}
