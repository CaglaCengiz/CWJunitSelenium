package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.swing.interop.LightweightFrameWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //  driver.quit();

    }

    @Test
    public void selectByIndex() {
        driver.get("https://demo.guru99.com/test/newtours/register.php\n");
        //dropDown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));
        //locate edilen dopdown select objesine dönüştürüldü
        Select select = new Select(drpDown);
        select.selectByIndex(1);//ALGERİA
        //selectByIndex methodu 0 ile baslar
    }

    @Test
    public void selectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php\n");
        //dropDown locate edildi
        WebElement drpDown = driver.findElement(By.name("country"));
        //locate edilen dopdown select objesine dönüştürüldü
        Select select = new Select(drpDown);
        select.selectByValue("TURKEY");
//selectByValue() methodu option elementlerinin value attribuye unun degerine göre seçim yapar

    }

    @Test
    public void selectByVisibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php\n");
        //dropDown locate edildi

       WebElement drpDown = driver.findElement(By.name("country"));
        //locate edilen dopdown select objesine dönüştürüldü
        Select select = new Select(drpDown);

        select.selectByVisibleText("NEPAL");
    }

    @Test
    public void multipleSelect() {
        driver.get("https://output.jsbin.com/osebed/2");

        //Dropdown locate ediliyor
        Select select = new Select(driver.findElement(By.id("fruits")));

        System.out.println(select.isMultiple());

        select.selectByValue("apple");

        select.selectByIndex(3);  //Grape

    }

    @Test
    public void getOptions() {
        driver.get("https://demo.guru99.com/test/newtours/register.php\n");
        Select select = new Select(driver.findElement(By.name("country")));
        //getOptions()methodu select elementinın tum seceneklerini bır lıste içerisinde bize verir
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            option.getText();
    //getOptions() arguman olarak string alır ,açılır menu lıstesinden bır secenegin seçilmesini saglar
        }
    }

    @Test
    public void getFirstSelectedOption() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(3);//grape
        select.selectByIndex(2);//orange
        WebElement selectedOption = select.getFirstSelectedOption();
        selectedOption.getText();
        //select.getFirstSelectedOption().getText();

        //getFirstSelectedOption() metodu secili olan ilk option elementini bize verir. (Sectigimiz ilk option degil !!!)
    }
    @Test
    public void getAllSelectedOptions(){
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByValue("banana");
        select.selectByValue("apple");
      List<WebElement>selectedOptions= select.getAllSelectedOptions();
      selectedOptions.stream().forEach(x-> System.out.println(x.getText()));


    }



    }

