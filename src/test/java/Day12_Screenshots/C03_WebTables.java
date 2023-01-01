package Day12_Screenshots;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {
    @Test
    public void webTableExample(){

        driver.get("http://demo.guru99.com/test/web-table-element.php");

        //Tablomuzu locate ettik
        WebElement table = driver.findElement(By.className("dataTable")).findElement(By.tagName("tbody"));

        // 3. satir locate edildi
        WebElement row3 = table.findElement(By.xpath(".//tr[3]"));

        // 3. satir 3. sutun (hucre) locate edildi
        WebElement row3cell3 = row3.findElement(By.xpath(".//td[3]"));

        // Satir sayimizi bulduk
        int satirSayisi = table.findElements(By.xpath(".//tr")).size();
        System.out.println(satirSayisi);

        //sutun sayimizi bulduk
        int sutunSayisi = row3.findElements(By.xpath(".//td")).size();
        System.out.println(sutunSayisi);

        // For donguleri ile tum hucreleri geziyoruz
        for (int i = 1; i<=satirSayisi; i++){
            //her bir satir


            for (int j = 1; j<=sutunSayisi; j++){
                // her satirin sutunu
                By locator = By.xpath(".//tr["+ i +"]//td[" + j + "]");
                WebElement tableData = table.findElement(locator);

                System.out.print(tableData.getText() + " ");
            }

            System.out.println();

        }

    }
}
