package Odevler;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class ODEV_02 extends BaseTest {
//  https://demoqa.com/select-menu sitesine gidin
//  Multiple select yapabileceginiz <select> elementini locate edin
// Birden fazla secim yapip secimlerinizi DOGRULAyin
@Override
@After
public void tearDown() {
}
    @Test
public void odev02() {
    driver.get("https://demoqa.com/select-menu");
        WebElement multıSelect= driver.findElement(By.id("cars"));
        Select select=new Select(multıSelect);
        System.out.println(select.isMultiple());
        select.selectByValue("volvo");
        select.selectByIndex(2);
    select.selectByIndex(1);
    select.selectByVisibleText("Audi");
    select.getAllSelectedOptions().forEach(x-> System.out.println(x.getText()));

    }
    }
    /*konsol cıktısı
        true
        Volvo
        Saab
        Opel
        Audi*/

