package Odevler;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ODEV_15_28Aralık extends BaseTest {
   // Go to URL: https://opensource-demo.orangehrmlive.com/
   // Getting screenshot of  Orange HRM Page Section.
   // Save the screenshot with format 'screenshotname_yyyy_MM_dd_hh_mm_ss.png'

    // Orange HRM Sayfa Bölümünün ekran görüntüsü alınıyor.
    // Ekran görüntüsünü 'screenshotname_yyyy_MM_dd_hh_mm_ss.png' formatında kaydedin
    @Test
    public void getPageScreenshot() throws IOException {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement HRMsayfa = driver.findElement(By.className("orangehrm-login-slot"));
        File hrMsayfaScreenshotAs =HRMsayfa .getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        String path = "test-output\\Screenshots\\Orange HRM Page Section" + date + ".png";
        FileUtils.copyFile(hrMsayfaScreenshotAs,new File(path));
    }
}
