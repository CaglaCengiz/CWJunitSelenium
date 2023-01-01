package Odevler;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;



public class ODEV_16_28Aralık extends BaseTest {
  // Go to URL: https://the-internet.herokuapp.com/tables
  // Print the entire table
  // Print All Rows
  // Print Last row data only
  // Print column 5 data in the table body
  // Write a method that accepts 2 parameters
  // parameter 1 = row number
  // parameter 2 = column number
  // printData(3,4); => prints
  // parameter 3 = table id
  // printData(3,4,"table1") => prints data in 3rd row 4th Column with table id



    @Test
    public void name() {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement table1= driver.findElement(By.id("table1"));
        System.out.println(table1.getText());
       int table1Satır=table1.findElements(By.xpath(".//tr")).size();
        System.out.println(table1Satır);
        for (int i = 1; i <table1Satır ; i++) {
            table1.findElement(By.xpath(".//tr["+i+"]")).getText();


        }
        WebElement sonSatır= driver.findElement(By.xpath(".//tr["+(table1Satır-1)+"]"));
        System.out.println(sonSatır.getText());
        for (int i = 1; i < table1Satır; i++) {
            table1.findElement(By.xpath((".//tr["+i+"]//td[5]"))).getText();

        }
        printData(3,4,table1);
    }

    private void printData(int satırSayısı, int sutunSayısı, WebElement table1) {
        WebElement  table= driver.findElement(By.id("table1"));
        System.out.println(table.findElement(By.xpath(".//tr[" + satırSayısı + "]//td[" + sutunSayısı + "]")).getText());
    }}
       //2.YOLL
     /*  @Test
        public void tableTask() {
    driver.get("https://the-internet.herokuapp.com/tables");
    WebElement table = driver.findElement(By.id("table1")).findElement(By.tagName("tbody"));
    System.out.println("table1.getText() = " + table.getText());

    WebElement row = table.findElement(By.xpath(".//tr"));
    System.out.println("rowtable1.getText() = " + row.getText());

    WebElement rowLast = table.findElement(By.xpath(".//tr[4]"));
    System.out.println("rowLastTable1.getText() = " + rowLast.getText());

    WebElement column5 = table.findElement(By.xpath(".//td[5]"));
    System.out.println("column5.getText() = " + column5.getText());
    method(3,4,table);
}
    public void method(int a , int b,WebElement table){
        WebElement tabledata = table.findElement(By.xpath(".//tr["+ a +"]//td["+ b +"]"));
        System.out.print("data.getText() = " + tabledata.getText());*/


