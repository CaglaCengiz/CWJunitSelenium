package Odevler;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ODEV_04 extends BaseTest {


    @Override
    @After
    public void tearDown() {

    }

    @Test
    public void dropdownFaker() {
        // Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Login with Username: Admin
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // Login with Password: admin123
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Click login button
        WebElement buttonclick = driver.findElement(By.xpath("//button[@type='submit']"));
        buttonclick.click();

        // Click on PIM
        WebElement PIMClick = driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][2]"));
        PIMClick.click();


        // Click on Employee  list
        WebElement employeeListClick = driver.findElement(By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']"));
        employeeListClick.click();


        // Employee Name -> Use Faker Class
        WebElement fname = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        Faker faker = new Faker();
        fname.sendKeys(faker.name().firstName());
        Actions actions = new Actions(driver);
        //input elementleri için liste(faker ile doldurulacak)
        List<WebElement> infoButtons = driver.
                findElements(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//input"));

        //iç ice div ile yapılan select elementlerinin listesi
        List<WebElement> selectList = driver.
                findElements(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[@class='oxd-select-wrapper']"));


        //Employee Name -> Use Faker Class
        infoButtons.get(0).sendKeys(faker.name().name());

        //ID -> Use Faker Class
        infoButtons.get(1).sendKeys(faker.idNumber().valid());

        //Employment Status -> select by index: 2
        actions.click(selectList.get(0)).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();

        //Include -> selectByVisibleText: Current and Past Employees
        actions.click(selectList.get(1)).sendKeys(Keys.DOWN).click().perform();

        //Supervisor Name -> Use Faker Class
        infoButtons.get(2).sendKeys(faker.name().firstName());

        //Job Title ->selectByValue: IT Manager
        actions.click(selectList.get(2)).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().perform();

        //Sub Unit ->selectByValue: 3
        actions.click(selectList.get(3)).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).
                sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().perform();

        //Click search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Verify text visible : "No Records Found"
        WebElement recordText = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"));
        Assert.assertTrue(recordText.isDisplayed());
    }

    }