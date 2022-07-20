package starter.pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ManageOfflineBookingPage extends PageObject {

    private String username;
    private By manageOfflineBookingMenu(){
        return By.xpath("//li[text()='Manage Offline Class Booking']");
    }

    private By manageOnlineBookingMenu(){
        return By.xpath("//li[text()='Manage Online Class Booking']");
    }
    private By button(int row, String button){
        return By.xpath("//tr[" + row + "]//button[@id=\"btn-" + button + "-offline-booking\"]");
    }

    private By cancelButtonView(){return By.xpath("//div[@class=\"ant-modal-confirm-btns\"]//button");

    }

    private By cancelButtonDelete(){
        return By.xpath("//div[@class=\"ant-modal-body\"]//button[2]");
    }

    private By confirmDelete(){
        return By.xpath("//div[@class=\"ant-modal-body\"]//button[1]");
    }

    private By offlineBookingText(){
        return By.xpath("//h1[text()=\"Manage Offline Class Booking\"]");
    }

    private By onlineBookingText(){
        return By.xpath("//h1[text()=\"Manage Online Class Booking\"]");
    }

    private By viewBookingText(){
        return By.xpath("//h1[text()=\"View Booking Status\"]");
    }

    private By usernameText(int row){
        return By.xpath("//tr[" + row + "]//td[1]");
    }

    @Step
    public static OpenUrl url(String targeturl){
        return new OpenUrl(targeturl);
    }

    @Step
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    @Step
    public void clickButton(int row, String button){
        $(button(row, button)).click();
    }

    @Step
    public void clickCancelButton(String button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (button.equals("view")){
            modal.findElement(cancelButtonView()).click();
        } else if (button.equals("delete")){
            modal.findElement(cancelButtonDelete()).click();
        }
    }

    @Step
    public void clickConfirmDelete(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(confirmDelete()).click();

    }

    @Step
    public boolean validateOnOfflineBookingPage(){
        return $(offlineBookingText()).isDisplayed();
    }

    @Step
    public boolean validateOnOnlineBookingPage(){
        return $(onlineBookingText()).isDisplayed();
    }

    @Step
    public boolean validatePopUpShow(String button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (button.equals("view")){
            return modal.findElement(viewBookingText()).isDisplayed();
        } else {
           return  modal.findElement(confirmDelete()).isDisplayed();
        }
    }

    @Step
    public String getNameOnListForDelete(int row){
        String username = $(usernameText(row + 1)).getText();
        System.out.println(username);
        try (FileWriter file = new FileWriter("src//test//resources//filejson//username.json")){
            file.write(username);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        return username;
    }

    @Step
    public boolean validateDataWasDeleted(int row) throws Exception{
        username = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//username.json"), StandardCharsets.UTF_8);
        return $(usernameText(row)).getText().equals(username);
    }

    @Step
    public void clickOfflineBookingMenu(){
        $(manageOfflineBookingMenu()).click();
    }

    @Step
    public void clickOnlineBookingMenu(){
        $(manageOnlineBookingMenu()).click();
    }

}
