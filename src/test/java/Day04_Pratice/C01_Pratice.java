package Day04_Pratice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Pratice {
 //Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.
  WebDriver driver;

    @Before
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public  void tearDown() {
       driver.quit();
    }

    @Test
    public void test() {
        driver.get(" https://testpages.herokuapp.com/styled/index.html");
        WebElement alertsLink= driver.findElement(By.xpath("//a[@id='alerts']"));
        alertsLink.click();
        String allertsUrl=  driver.getCurrentUrl();
        System.out.println("allertsUrl = " + allertsUrl);
        driver.navigate().back();
        String homeUrl= driver.getCurrentUrl();
        System.out.println("homeUrl = " + homeUrl);
        WebElement basicAjaxLink= driver.findElement(By.id("basicajax"));
        basicAjaxLink.click();
        String basicAjaxUrl=  driver.getCurrentUrl();
        System.out.println("basicAjaxUrl = " + basicAjaxUrl);
        //Text alanina 20 yazilip ENTER a basildi
        driver.findElement(By.id("lteq30")).sendKeys("20" + Keys.ENTER);
        //Submitted Values yazisinin goruntulendigini dogrula
        WebElement submittedValuesText = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(submittedValuesText.isDisplayed());

}


}
