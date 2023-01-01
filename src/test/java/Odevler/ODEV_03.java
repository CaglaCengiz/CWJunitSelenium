package Odevler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class ODEV_03 extends BaseTest {
    //  https://demoqa.com/select-menu sitesine gidin
    //  multiple <select> elementini locate edin
   //   getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    // Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
    @Override
    @After
    public void tearDown() {
    }

    @Test
    public void odev03() {
        driver.get("https://demoqa.com/select-menu");
        Select select=new Select(driver.findElement(By.id("cars")));
        System.out.println(select.isMultiple());

        // getOptions() methodu ile
        List<WebElement> options =select.getOptions();
        for (WebElement option : options) {
        option.getText();


       //getFirstSelectOption() methodu ile
       select.selectByValue("volvo");
       select.selectByIndex(1);
       WebElement selectedoptions= select.getFirstSelectedOption();
       selectedoptions.getText();

       // getAllSelected() methodu ile
       List<WebElement>selectedOptions=select.getAllSelectedOptions();
       selectedOptions.stream().forEach(x-> System.out.println(x.getText()));


    }
}}