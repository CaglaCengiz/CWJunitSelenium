package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExample {
  // Store the path of the file as string and open the file.
  // Open the workbook.
  // Open the first worksheet.
  // Go to the first row.
  // Create a cell on the 3rd column (2nd index) on the first row.
  // Write “POPULATION” on that cell.
  // Create a cell on the 2nd row 3rd cell(index2), and write data.
  // Create a cell on the 3rd row 3rd cell(index2), and write data.
  // Create a cell on the 4th row 3rd cell(index2), and write data.
  // Write and save the workbook.
  // Close the file.
  // Close the workbook.

  // Dosyanın yolunu string olarak saklayın ve dosyayı açın.
  // Çalışma kitabını açın.
  // İlk çalışma sayfasını açın.
  // İlk satıra git.
  // İlk satırda 3. sütunda (2. dizin) bir hücre oluşturun.
  // O hücreye “Nüfus” yazın.
  // 2. sıra 3. hücreye(index2) bir hücre oluştur ve veriyi yaz.
  // 3. sıra 3. hücre(index2) üzerine bir hücre oluştur ve veri yaz.
  // 4. sıra 3. hücreye(index2) bir hücre oluştur ve veriyi yaz.
  // Çalışma kitabını yazın ve kaydedin.
  // Dosyayı kapatın.
  // Çalışma kitabını kapatın.
    @Test
    public void writeExcel() throws IOException {
        //dosyanın pathını belirttik
        String path="src/test/java/resources/excelfile.xlsx";

        //dosyayı actık
        FileInputStream fis=new FileInputStream(path);

        //dosyamızı bır workbook halıne getiriyoruz
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheetimizi olusturduk 2.sayfayı actık
        Sheet sheet2=workbook.getSheetAt(1);

        //ilk satıra gittik row =satır
        Row row1= sheet2.getRow(0);

        //ilk satırın 3. hucresini olusturduk
        Cell row1cell3=row1.createCell(2);

        //Hucremize deger atadık
        row1cell3.setCellValue("POPULATION");

        //Method chain ile data ekleme/degiştirme methodu
        sheet2.getRow(1).createCell(2).setCellValue("Rusya`nın populasyonu");
        sheet2.getRow(2).createCell(2).setCellValue("Cın`nın populasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("ABD`nın populasyonu");

        //Excel dosyamıza yazma işlemini yapıyoruz
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);

        //dosyalarımızı kapattık
        fis.close();
        fos.close();
       workbook.close();
    }
}
