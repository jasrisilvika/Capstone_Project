package Utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class General {
    Random rand = new Random();

    public String randomEmail(){
        return "automationTest" + rand.nextInt(1000) + "@email.com";
    }

    public String randomUsername(){
        return "automationTest" + rand.nextInt(1000);
    }

    public String randomName(){
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public String dateNow(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        return formattedDate +"T21:31:10+07:00";
    }
}
