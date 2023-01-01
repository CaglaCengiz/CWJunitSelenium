package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExelMethods {
    public static void main(String[] args) throws IOException {


       String path="src\\test\\java\\resources\\excelfile.xlsx";
       FileInputStream fileInputStream=new FileInputStream(path);

       //actıgımız dosyayı excel workbook una cevirdik
       Workbook workbook= WorkbookFactory.create(fileInputStream);

       //workbook umuzdan sheetimize geciş yaptık
       Sheet sheet1=workbook.getSheetAt(0);

       //sheetimizden istediğimiz satırı aldık. index 0 dan baslar
        Row row1=sheet1.getRow(0);

        //satırdan istediğimiz hucreyi aldık index 0 dan baslar
        Cell cell1= row1.getCell(0);

        System.out.println("Cell 1= "+cell1.toString().toLowerCase());

    }
}
