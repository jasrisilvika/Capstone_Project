package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class General {
    Random rand = new Random();

    public String randomEmail(){
        return "admin" + rand.nextInt(1000) + "@email.com";
    }

    public String randomUsername(){
        return "admin" + rand.nextInt(1000);
    }

    public String randomName(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}
