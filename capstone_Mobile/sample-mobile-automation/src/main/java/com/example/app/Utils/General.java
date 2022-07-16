package com.example.app.Utils;

import org.assertj.core.internal.bytebuddy.utility.RandomString;


import java.util.Random;

public class General
{
    Random rand = new Random();

    public String randomEmail(){
        return "userstesting" + rand.nextInt(1000) + "@email.com";
    }

    public String randomUsername(){
        return "userstesting" + rand.nextInt(1000);
    }

    public String randomName(){
        return "user" + rand.toString();
    }

    public String randomPassword(){
        return "Pas12" + RandomString.make(3);
    }
}
