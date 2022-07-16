package com.example.app.base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.app.drivers.AndroidDriverInit.driver;

public class BasePageObject {
    public AndroidDriver<AndroidElement> getDriver(){
        return driver;
    }

    public WebDriverWait onWait(){
        return new WebDriverWait(getDriver(), 30, 1000);
    }

    public AndroidElement find(By locator){
        return (AndroidElement) onWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
        find(locator).click();
    }

    public void sendKeys(By locator, String input){
        find(locator).sendKeys(input);
    }

    public void clear(By locator){
        find(locator).clear();
    }

    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public String getText(By locator){
        return find(locator).getText();
    }

    public void swipeHorizontal(){
        TouchAction action = new TouchAction(driver);
        Dimension sizeDevice = driver.manage().window().getSize();
        action.press(PointOption.point((int) (sizeDevice.getWidth() * 0.8), sizeDevice.getHeight()))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point((int) (sizeDevice.getWidth()* 0.2), sizeDevice.getHeight()))
                .release().perform();
    }

    public void swipeVertical(){
        TouchAction action = new TouchAction(driver);
        Dimension sizeDevice = driver.manage().window().getSize();
        action.press(PointOption.point((sizeDevice.getWidth()), (int) (sizeDevice.getHeight() * 0.8)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(100)))
                .moveTo(PointOption.point((sizeDevice.getWidth()), (int) (sizeDevice.getHeight() * 0.2)))
                .release().perform();
    }

    public void scrollText(String text){

    }

    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 300; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

//    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
//            ".scrollIntoView(new UiSelector().textContains(\"Cardio\"))")
//    MobileElement element;
}
