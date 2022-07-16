package com.example.app.pages;


import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.example.app.drivers.AndroidDriverInit.driver;

public class HomePage extends BasePageObject {

    private String username;
    By helloText(){
        return By.xpath("//android.view.View[@content-desc=\"Hello,\"]");
    }

//    public void validateOnHomePage(){
//        try (FileReader file = new FileReader("src//test//resources//filejson//username.json")) {
//            file.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    By profileButton(){
        return By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]");
    }

    By homeButton(){
        return By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");
    }

    By scheduleButton(){
        return By.xpath("//android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");
    }

    By seeAllOnlineClass(){
        return By.xpath("(//android.view.View[@content-desc=\"See All\"])[1]");
    }

    By seeAllOfflineClass(){
        return By.xpath("(//android.view.View[@content-desc=\"See All\"])[2]");
    }

    By cardClassOption(String row){
        return By.xpath("//android.widget.ScrollView/android.view.View[5]/android.view.View[" +
                row +
                "]");
    }

    By seeAllText(String category){
        return By.xpath("//android.view.View[@content-desc=\"" +
                category +
                " Class\"]");
    }

    By classesCard(String num){
        return By.xpath("//android.widget.ScrollView/android.view.View/android.view.View/android.view.View[" +
                num +
                "]");
    }

    By detailClassText(){
        return By.xpath("//android.view.View[@content-desc=\"Detail Class\"]");
    }

    By classText(String classes){
        return By.xpath("//android.view.View[@content-desc=\"" +
                classes +
                "\"]");
    }

    By bookNowButton(){
        return By.xpath("(//android.widget.Button[@content-desc=\"Book now\"])");
    }
    By bookNowButtonOnList(){
        return By.xpath("(//android.widget.Button[@content-desc=\"Book now\"])[1]");
    }

    By seeAllAvailableClass(){
        return By.xpath("//android.widget.Button[@content-desc=\"See Available Classes\"]");
    }

    By bookingText(){
        return By.xpath("//android.view.View[@content-desc=\"Booking Class\"]");
    }

    By paymentInstructionButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Payment Instruction\"]");
    }

    By popUpSuccessBooking(){
        return By.xpath("//android.view.View[@content-desc=\"Return to Schedule page to see your schedule\"]");
    }

    By validateEmailOnBookingPage(String email){
        return By.xpath("//android.view.View[@content-desc=\"" +
                email +
                "\"]");
    }

    By paymentInstructionText(){
        return By.xpath("//android.view.View[@content-desc=\"Payment Instruction\"]");
    }

    By bookingPage(String category, String classes){
        return By.xpath("//android.view.View[@content-desc=\"" +
                category + " " + classes + " Class\"]");
    }

    By tips1(){
        return By.xpath("//android.view.View[@content-desc=\"101 Fitness Tips That Rock (From a Personal Trainer!)\"]");
    }

    By tips2(){
       return By.xpath("//android.view.View[@content-desc=\"25 Expert Fitness Tips and Strategies Every Lifter Should Know\"]");
    }

    By directedTips(){
        return By.xpath("//android.widget.FrameLayout/android.webkit.WebView");
    }

    By payNowButton(){
        return By.xpath("//android.widget.Button[@content-desc=\"Pay Now\"][1]");
    }

    By myScheduleText(){
        return By.xpath("//android.view.View[@content-desc=\"My Schedules\"]");
    }

    By directedToWA(){
        return By.xpath("//android.widget.FrameLayout/android.widget.EditText");
    }
    public void validateOnHomePage(){
        Assertions.assertTrue(isDisplayed(helloText()));
    }

    public void clickProfilButton(){
        click(profileButton());
    }

    public void clickSeeAll(String category){
        if (category.equals("Online")){
            click(seeAllOnlineClass());
        } else if (category.equals("Offline")){
            click(seeAllOfflineClass());
        }
    }

    public void allClassesWillShow(String category){
        Assertions.assertTrue(isDisplayed(seeAllText(category)));
    }
    public void clickCardClassOption(String row){
        click(cardClassOption(row));
    }

    public void iChooseAClass(String classes, String category){
        if (category.equals("Online")){
            if (classes.equals("Weight Lifting")){
                click(classesCard("1"));
            } else if (classes.equals("Body Building")){
                click(classesCard("2"));
            } else if (classes.equals("Yoga")){
                click(classesCard("3"));
            } else if (classes.equals("Weight Loss")){
                click(classesCard("4"));
            }
            else if (classes.equals("Zumba")){
                MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                                ".scrollIntoView(new UiSelector().text(\"Cardio Class\"))"));
                click(classesCard("5"));
            } else if (classes.equals("Cardio")){
                MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                                ".scrollIntoView(new UiSelector().text(\"Cardio Class\"))"));
                click(classesCard("6"));
            }
        } else if (category.equals("Offline")){
            if (classes.equals("Yoga")){
                click(classesCard("4"));
            } else if (classes.equals("Weight Loss")){
                click(classesCard("3"));
            } else if (classes.equals("Zumba")){
                click(classesCard("2"));
            } else if (classes.equals("Cardio")){
                click(classesCard("1"));
            } else if (classes.equals("Weight Lifting")){
                MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                                ".scrollIntoView(new UiSelector().text(\"Body Building Class\"))"));
                click(classesCard("6"));
            } else if (classes.equals("Body Building")){
                MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                                ".scrollIntoView(new UiSelector().text(\"Body Building Class\"))"));
                click(classesCard("5"));
            }
        }

    }

    public void iValidateResultAfterViewDetail(String classes){
        Assertions.assertTrue(isDisplayed(detailClassText()));
        Assertions.assertTrue(isDisplayed(classText(classes)));
    }

    public void iClickBookNowButton(){
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().text(\"Book Now\"))"));
        click(bookNowButtonOnList());
    }

    public void clickSeeAvailableClass(String category, String classes){
        click(seeAllAvailableClass());
        Assertions.assertTrue(isDisplayed(bookingPage(category, classes)));
    }

    public void clickPaymentInstructionButton(String email){
        Assertions.assertTrue(isDisplayed(validateEmailOnBookingPage(email)));
        click(paymentInstructionButton());
    }

    public void validateResultAfterBookingClass(){
        Assertions.assertTrue(isDisplayed(paymentInstructionText()));
        click(bookNowButton());
        Assertions.assertTrue(isDisplayed(popUpSuccessBooking()));
    }

    public void iClickTheTips(String tips){
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().text(\"Tips for you\"))"));
        if (tips.equals("1")){
            click(tips1());
        } else {
            click(tips2());
        }
    }

    public void iValidateTheResultAfterClickTips() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertTrue(isDisplayed(directedTips()));
    }

    public void iClickScheduleMenu(){
        click(scheduleButton());
        Assertions.assertTrue(isDisplayed(myScheduleText()));
    }

    public void clickPayNowButton(){
        click(payNowButton());
    }

    public void iValidateTheResultAfterPayTheBooking() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertTrue(isDisplayed(directedToWA()));
    }

}
