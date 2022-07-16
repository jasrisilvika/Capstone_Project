package com.example.app.drivers;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverInit {
    public static AndroidDriver<AndroidElement> driver;

    public static void initialize(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("app", "E:\\Aveeka\\Capstone_Project\\capstone_Mobile\\sample-mobile-automation\\src\\test\\resources\\application\\app-debug.apk");
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }

//    public static void hideKeyboard(){
//        driver.hideKeyboard();
//    }

    public static void quit(){
        driver.quit();
    }

}
