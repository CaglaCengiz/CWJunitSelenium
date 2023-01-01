package Odevler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class ODEV_07 extends BaseTest {
  //  Go to URL: http://demo.automationtesting.in/Alerts.html
  //  Click "Alert with OK" and click 'click the button to display an alert box:’
  //  Accept Alert(I am an alert box!) and print alert on console.
  //  Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
  //  Cancel Alert  (Press a Button !)
  //  Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
  //  And then sendKeys «BootcampCamp» (Please enter your name)
  //  Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
  // URL'ye gidin: http://demo.automationtesting.in/Alerts.html
  // "Tamam ile Uyarı"ya tıklayın ve "bir uyarı kutusu görüntülemek için düğmeye tıklayın:"
  // Uyarıyı Kabul Et(Ben bir uyarı kutusuyum!) ve uyarıyı konsolda yazdır.
  // "Tamam ve İptal ile Uyar"a tıklayın ve "bir onay kutusu görüntülemek için düğmeyi tıklayın"a tıklayın
  // Uyarıyı İptal Et (Bir Düğmeye Bas!)
  // "Textbox ile Uyarı"ya tıklayın ve "bilgi istemi kutusunu göstermek için düğmeyi tıklayın"a tıklayın
  // Ardından «BootcampCamp» anahtarlarını gönderin (Lütfen adınızı girin)
  // Son olarak bu mesajı konsola yazdır "Merhaba BootcampCamp Bugün Nasılsın" iddiası bu mesaj.

    @Override
    @After
    public void tearDown() {

    }

    @Test

    public void test() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
       WebElement AlertWithOk= driver.findElement(By.xpath("(//a[@class='analystic'])[1]"));
        AlertWithOk.click();
      WebElement clickTheButton=driver.findElement(By.xpath("//button[@class='btn btn-danger']")) ;
        clickTheButton.click();

       // Accept Alert(I am an alert box!) and print alert on console.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //   Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        WebElement AlertWithOkCancel= driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        AlertWithOkCancel.click();
        WebElement clickThebuttonConfirmBox=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        clickThebuttonConfirmBox.click();


       // Cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

       // Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        WebElement textbox=driver.findElement(By.xpath("//a[@href='#Textbox']"));
        textbox.click();
        WebElement textboxalert= driver.findElement(By.xpath("(//button[@class='btn btn-info'])"));
        textboxalert.click();



        // And then sendKeys «BootcampCamp» (Please enter your name)

        driver.switchTo().alert().sendKeys("Cagla");

        driver.switchTo().alert().accept();


        // Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        WebElement text= driver.findElement(By.id("demo1"));
        Assert.assertEquals("Hello BootcampCamp How are you today",text.getText());
        System.out.println(text.getText());

    }
    }


