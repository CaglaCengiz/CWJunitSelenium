package Odevler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

public class ODEV_06 extends BaseTest {
  //  Launch the browser.
  //   Open "https://demoqa.com/select-menu".
  //  Select the Standard Multi-Select using the element id.
  //  Verifying that the element is multi-select.
  //   Select 'Opel' using the index and deselect the same using index.
  //   Select 'Saab' using value and deselect the same using value.
  //  Deselect all the options.
  //Close the browser.

    @Override
    @After
    public void tearDown() {

    }

    @Test
    public void secim(){

        driver.get("https://demoqa.com/select-menu");
        WebElement secimcars= driver.findElement(By.id("cars"));

        Select select=new Select(secimcars);

        Assert.assertTrue(select.isMultiple());

        select.selectByIndex(2);
        select.deselectByIndex(2);

        select.selectByValue("saab");
        select.deselectByValue("saab");

        select.deselectAll();


}}
