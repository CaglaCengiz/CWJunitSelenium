package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePoiTask {
  //    Add the excel file on the resources folder.
//    Open the file.
//    Open the workbook using file input stream.
//    Open the first worksheet.
//    Go to first row.
//    Go to first cell on that first row and print.
//    Go to second cell on that first row and print.
//    Go to 2nd row first cell and assert if the data equal to Russia.
//    Go to 3rd row 2nd cell-chain the row and cell.
//    Find the number of used row.
//    Print country, area key value pairs as map object.

// Excel dosyasını kaynaklar klasörüne ekleyin.
// Dosyayı aç.
// Dosya giriş akışını kullanarak çalışma kitabını açın.
// İlk çalışma sayfasını açın.
// İlk satıra git.
// İlk satırdaki ilk hücreye git ve yazdır.
// İlk satırdaki ikinci hücreye git ve yazdır.
// 2. sıradaki ilk hücreye gidin ve verilerin Rusya'ya eşit olup olmadığını onaylayın.
// 3. satıra git 2. hücre zinciri satır ve hücre.
// Kullanılan satır sayısını bulun.
// Ülke, alan anahtar değeri çiftlerini harita nesnesi olarak yazdırın.

    @Test
    public void apacheTask() throws IOException {

        //    Add the excel file on the resources folder.
        String path = "src\\test\\java\\resources\\excelfile.xlsx";

        //    Open the file.
        FileInputStream fileInputStream = new FileInputStream(path);

        //    Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //    Open the first worksheet.
        Sheet sheet1 = workbook.getSheetAt(0);

        //    Go to first row.
        Row row1 = sheet1.getRow(0);

        //    Go to first cell on that first row and print.
        Cell row1cell1 = row1.getCell(0);
        System.out.println("row1 cell1 = " + row1cell1);

        //    Go to second cell on that first row and print.
        Cell row1cell2 = row1.getCell(1);
        System.out.println("row1 cell2 = " + row1cell2);

        //    Go to 2nd row first cell and assert if the data equal to Russia.
        Row row2 = sheet1.getRow(1);
        Cell row2cell1 = row2.getCell(0);
        Assert.assertEquals("Rusya", row2cell1.toString());

        //    Go to 3rd row 2nd cell-chain the row and cell.
        Cell row3cell2 = sheet1.getRow(2).getCell(1);
        System.out.println("row3 cell2 = " + row3cell2);

        //    Find the number of used rows.
        System.out.println(sheet1.getPhysicalNumberOfRows()); // Satir sayisini direkt verir
        System.out.println(sheet1.getLastRowNum() + 1); // Son satirin indexini verir

        int totalRows = sheet1.getPhysicalNumberOfRows(); // Satir sayisini atadik
        //    Print country, area key value pairs as map object.

        Map<String,String> countryAreas = new HashMap<>();

        // Her bir satirdaki datalar map objesine for dongusuyle ekleniyor
        for (int row = 1;row<totalRows; row++){
            String country = sheet1.getRow(row).getCell(0).toString();

            // Her satirdaki ulkeyi yazdiriyoruz
            //System.out.println((row+1) + ". satir = " + country);

            String area = sheet1.getRow(row).getCell(1).toString();

            //System.out.println("Country = " + country + " - Area = " + area);

            // Her bir satirdaki ulke ve yuzolcumu degerlerini map imizin icerisine yerlestirdik.
            countryAreas.put(country,area);
        }

        // Map imizi yazdiriyoruz
        System.out.println(countryAreas);
    }

}
