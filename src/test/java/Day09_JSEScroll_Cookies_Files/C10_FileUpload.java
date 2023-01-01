package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C10_FileUpload extends BaseTest {
    @Test
    public void fileUpload() {
      // Go to URL: https://the-internet.herokuapp.com/upload
      // Find the path of the file that you want to upload.
      //  Click on Upload button.
      //   Verify the upload message.
       // Yüklemek istediğiniz dosyanın yolunu bulun.
       //  Yükle düğmesine tıklayın.
       //   Yükleme mesajını doğrulayın.
        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec= driver.findElement(By.id("file-upload"));

        dosyaSec.sendKeys("C:\\Users\\ZK\\Desktop\\fileExist (1).png");

        WebElement uploadFile=driver.findElement(By.id("file-submit"));
        uploadFile.click();

        WebElement uploadMessage=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(uploadMessage.isDisplayed());

        Assert.assertEquals("File Uploaded!", uploadMessage.getText());
        //Assert.assertEquals("File Uploaded!" , baslik.getText());
    }
}
