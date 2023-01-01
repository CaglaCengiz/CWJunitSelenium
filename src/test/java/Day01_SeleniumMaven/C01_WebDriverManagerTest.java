package Day01_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverManagerTest {
    // Set Path.
// Create chrome driver.
// Maximize the window.
// Open google home page https://www.google.com/
// Verify that you are Google in the title.
    public static void main(String[] args) {
        //Webdriver Manager classını kullanarak chromedriver bınary leri indirdik
        WebDriverManager.chromedriver().setup();

        //driver objemızı olusturduk
        WebDriver driver =new ChromeDriver();

        //windowu maximize ettik
        driver.manage().window().maximize();

        //goole anasayfasını actık
        driver.get("https://www.goole.com/");

        //title mızı aldık
        String title= driver.getTitle();

        //title mızı dogruladık
        if (title.equalsIgnoreCase("Google")){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }
        driver. quit();
    }
}
