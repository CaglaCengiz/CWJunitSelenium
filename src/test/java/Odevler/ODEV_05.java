package Odevler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class ODEV_05 extends BaseTest {
 //  Go to URL: https://the-internet.herokuapp.com/dropdown
 //  Create method selectByIndexTest and Select Option 1 using index .
 //  Create method selectByValueTest Select Option 2 by value.
 //  Create method selectByVisibleTextTest Select Option 1 value by visible text.
 //  Create method printAllTest Print all dropdown value.
 //  Verify the dropdown has Option 2 text.
 //  Create method printFirstSelectedOptionTest Print first selected option.
 //  Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.

    @Override
    @After
    public void tearDown() {

    }

    @Test
public void Test() {

// URL'ye gidin: https://the-internet.herokuapp.com/dropdown
    driver.get("https://the-internet.herokuapp.com/dropdown");

// selectByIndexTest yöntemini oluşturun ve index kullanarak Seçenek 1'i seçin.
        WebElement dropdown= driver.findElement(By.id("dropdown"));
        Select select=new Select(dropdown);
        select.selectByIndex(0);
// method oluştur selectByValueTest Seçenek 2'yi değere göre seçin.
        select.selectByValue("2");
// method selectByVisibleTextTest oluştur Görünür metinle Seçenek 1 değerini seçin.
        select.selectByVisibleText(" Option 1");
// printAllTest yöntemini oluştur Tüm açılan değerleri yazdır.
        select.getOptions().forEach(t-> System.out.println(t.getText()));
// Açılır listede Seçenek 2 metni olduğunu doğrulayın.
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Option 2"));

// printFirstSelectedOptionTest yöntemini oluştur İlk seçilen seçeneği yazdır.
        System.out.println(select.getFirstSelectedOption().getText());
// Açılır listenin boyutunu bulun, açılır listede 3 öğe yoksa "Beklenen Eşit Gerçek Değil" yazdırın.
        Assert.assertEquals("Expected Is Not Equal Actual",select.getOptions().size(),3);
}

    private void printAllTest(Select select,String value) {
        List<WebElement> options = select.getOptions();
        options.stream().forEach(t -> System.out.println(t.getText()));
    }}