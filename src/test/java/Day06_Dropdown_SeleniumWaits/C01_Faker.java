package Day06_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C01_Faker {
    //faker değerler üretmek içinFaker Classından biı obj üretir
    //ve var olan methodları kullanırız

    @Test
    public void fakerExample(){
        //faker obj olusturuyoruz
        Faker faker=new Faker();
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());


    }
}
