package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class BaseTest {
   /* TestBase Class: Her test class’ında tekrar tekrar
    yazdığımız setup ve teardown metotları tekrar
    yazmaktan kurtulmak için Java OOP konsepti kullanarak
    oluşturduğumuz bir class’dır.
    Test Base parent olarak kabul eden class’lar hazırlık için
    oluşturduğumuz driver, setup() ve teardown()
    oluşturmak zorunda kalmazlar, kendilerinde olmasa bile
    parent class’dan kullanılmış olur.
    TestBase genelde testlerden farklı bir package’da
    olduğundan driver’ın kullanabilmesi için public veya
    protected yapılması gerekir. Biz hep child class’lardan
    kullanacağımız için protected yapmayı yapmayı tercih
    ediyoruz.
            TestBase, Test classlarını temiz tutmamıza yardımcı
    olur.
            TestBase sınıfı
    abstract olmalıdır,
    böylece kullanıldığında
    sadece extends
    edilmesi yeterlidir ve
    bu classtan obje
    üretilmesi engellenir.*/

   protected WebDriver driver;
  //  Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
  //  TestBase Class'ı sadece extends ile inherit ederek kullanacağız.
  //  Dolayısıyla oluşturduğumuz driver variable'i için protected access modifier seçiyoruz. (edited)

    @Before
    public void setup() {
        //Driver ile ilgili her turlu initial(baslangic) islemi burada yapilir
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        // test sonrasinda driver kapatmak (varsa raporlari dosyalamak) icin kullanilir.
        driver.quit();
    }


}