package Day08_WindowHandles_Actions;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandleSe4 extends BaseTest {
    // https://testproject.io/

    // https://blog.testproject.io/

    @Override
    @After
    public void tearDown() {

    }

    @Test
    public void newWindow() {
        //ana sekmemızde url li zıyaret ediyoruz

        driver.get("https://testproject.io/");
        driver.switchTo().newWindow(WindowType.WINDOW);
        //  WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);

        //yeni pencere olusturulup o encereye switch ediyoruz
        driver.get("https://blog.testproject.io/");
    }

    @Test
    public void newTab() {
        driver.get("https://testproject.io/");
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);

        //yeni sekmeden amazona gidildi
        newTab.get("https://www.amazon.com/");

        //aktif tab in title i yazdırıldı
        System.out.println(driver.getTitle());

    }

    @Test
    public void handleWindows() {
        //ana sekmemızde amazon acılıyor
        driver.get("https://www.amazon.com/");

        //getWindowHandle() getWindowHandles()

        String homePageHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com.tr/");

        //yenı pencere olusturuyoruz
        driver.switchTo().newWindow(WindowType.WINDOW);

        //yenı pencerede Google i actık
        driver.get("https://www.google.com/");

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();
        while (i.hasNext()) {
            String currentTab = i.next();
            driver.switchTo().window(currentTab);
            System.out.println(driver.getTitle());

           //1.yol iyi yol
          //  if (!driver.getWindowHandle().equals(homePageHandle)) {
           //     driver.close();
            }
            //2.yol
            if (!driver.getTitle().contains("Spend")){
               driver.close();
            }
        }
    }

