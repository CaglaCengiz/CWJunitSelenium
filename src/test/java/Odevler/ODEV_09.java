package Odevler;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

public class ODEV_09 extends BaseTest {
   // Go to URL: https://testproject.io/
   // Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
   //         "https://blog.testproject.io/"
    //TestProject'in Blog sayfası için yeni bir Pencere açmak için Selenium'un 4 newWindow() yöntemi.


    @Test
    public void Test() {
        driver.get("https://blog.testproject.io/");
        WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://blog.testproject.io/");

    }

}
