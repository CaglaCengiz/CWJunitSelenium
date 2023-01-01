package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C11_AssertElementTrick extends BaseTest {
    @Test
    public void fileUpload() {
      driver.get("https://the-internet.herokuapp.com/upload");

    WebElement dosyaSec= driver.findElement(By.id("file-upload"));

        dosyaSec.sendKeys("C:\\Users\\ZK\\Desktop\\fileExist (1).png");

    WebElement uploadFile=driver.findElement(By.id("file-submit"));
        uploadFile.click();
//elementin locatorunu özellikle yanlış yazıpdurumu nasıl handle ettiğimizi kontrol ediyoruz
    List<WebElement> uploadMessageList=  driver.findElements(By.tagName("h9"));

    Assert.assertEquals("Upload mesajı goruntulenemedi", 1,uploadMessageList.size());
    WebElement uploadMessage=uploadMessageList.get(0);
    Assert.assertTrue(uploadMessage.isDisplayed());
    Assert.assertEquals("mesajın testi istenildiği gibi goruntulenemıyor","File uploaded! ",uploadMessage.getText());

}
}
