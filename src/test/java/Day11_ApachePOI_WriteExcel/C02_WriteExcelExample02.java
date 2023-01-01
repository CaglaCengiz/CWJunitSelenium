package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.*;

public class C02_WriteExcelExample02 {
    //    Create an object of File class to open xlsx file.
//    Create an object of FileInputStream class to read excel file.
//    Creating workbook instance that refers to .xlsx file.
//    Creating a Sheet object.
//    Get all rows in the sheet.
//    Create a row object to retrieve row at index 3.
//    Create a cell object to enter value in it using cell Index.
//    Write the data in excel using output stream.

// xlsx dosyasını açmak için File sınıfından bir nesne oluşturun.
// Excel dosyasını okumak için FileInputStream sınıfından bir nesne oluşturun.
// .xlsx dosyasına başvuran çalışma kitabı örneği oluşturuluyor.
// Sayfa nesnesi oluşturma.
// Sayfadaki tüm satırları al.
// Dizin 3'teki satırı almak için bir satır nesnesi oluşturun.
// Hücre Dizini'ni kullanarak değer girmek için bir hücre nesnesi oluşturun.
// Çıktı akışını kullanarak verileri excel'e yazın.

    @Test
    public void changeExcelData() throws IOException {
        //Dosyamizin path ini aldik
        String filePath = "src/test/java/resources/excelData.xlsx";

        // Pathimizden file olusturduk
        File file = new File(filePath);

        //File imizi actik
        FileInputStream fis = new FileInputStream(file);

        //Workbook umuzu olusturduk
        Workbook wb = WorkbookFactory.create(fis);

        //Sheetimizi olusturduk
        Sheet informationData = wb.getSheet("informationData");

        // total row sayisini bulduk ve yazdirdik tum satırları bulduk
        int totalRowsUsed = informationData.getLastRowNum() - informationData.getFirstRowNum();
        System.out.println("Total rows = " + totalRowsUsed);

        // Yeni bir row olusturup row icerisindeki celleri de olusturarak degerlerini atadik
        Row row5 = informationData.createRow(4);

        row5.createCell(0).setCellValue("Karl");
        row5.createCell(1).setCellValue("Ortis");
        row5.createCell(2).setCellValue("karl@cw.com");
        row5.createCell(3).setCellValue("Male");
        row5.createCell(4).setCellValue("012345678");
        row5.createCell(5).setCellValue("Address");
        // Dosyamiza yazma islemini gerceklestirdik
        FileOutputStream fos = new FileOutputStream(file);
        wb.write(fos);
        // Oblejelerimizi kapattik
        fis.close();
        fos.close();
        wb.close();




    }
}
