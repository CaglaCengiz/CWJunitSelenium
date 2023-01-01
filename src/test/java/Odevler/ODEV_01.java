package Odevler;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class ODEV_01 extends BaseTest {
//   - https://demoqa.com/select-menu sitesine gidin
//  - <select> elementini locate edin
// <select> elementinin seceneklerini yazdirin
// Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
//   * Yellow (index)
//   * Purple (value)
//   * Black  (text)
//   seceneklerini secin

    @Override
    @After
    public void tearDown() {
    }
       @Test
    public void odev01(){
        driver.get(" https://demoqa.com/select-menu");
         WebElement selectMenu= driver.findElement(By.id("oldSelectMenu"));
           Select select=new Select(selectMenu);
           System.out.println(select.isMultiple());
           select.selectByIndex(3);
           select.selectByValue("4");
           select.selectByVisibleText("Black");

        }

        }


