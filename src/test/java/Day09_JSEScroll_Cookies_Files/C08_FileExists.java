package Day09_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
//C:\Users\ZK\Desktop\fileExist (1).rar
import java.io.File;

public class C08_FileExists {
    @Test
    public void fileExists() throws InterruptedException {


        System.out.println(System.getProperty("user.home"));// Home yolunu yazdirdik

        String homePath=System.getProperty("user.home"); // Home yolunu atadik

        String filePath="C:\\Users\\ZK\\Desktop\\fileExist (1).png "; // Dosyanin kalan yolunu atadik

        String fullPath=homePath+filePath;// home ve dosya yollarini birlestirip full path i elde ettik

        File image=new File(fullPath);// Path imizi file a cevirdik

        Assert.assertTrue(image.exists());// exists metoduyla varolup olmadigini kontrol ettik
    }
}
