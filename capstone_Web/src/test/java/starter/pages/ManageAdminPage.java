package starter.pages;

import Utils.General;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.SerenityActions;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ManageAdminPage extends PageObject {
    General general = new General();
    private String name, nama, username, email;
//    ScrollToBy scroll = new ScrollToBy();

    private By manageAdminMenu(){
        return By.xpath("//div[text()='Manage Admin']//parent::li");
    }

    private By manageAdminText(){
        return By.xpath("//h1[text()='Manage Admin']");
    }

    private By viewButton(int row){
        return By.xpath("//tbody//tr[" + row + "]//button[@id='btn-view-admin']");
    }

    private By editButton(int row){
        return By.xpath("//tbody//tr[" + row + "]//button[@id='btn-edit-admin']");
    }

    private By deleteButton(int row){ return By.xpath("//tbody//tr[" + row + "]//button[@id='btn-delete-admin']");
    }

    private By cancelButtonOnModal(String button){
        return By.id("btn-cancel-" + button + "-admin");
    }

    private By viewAdminText(){
        return By.xpath("//h1[text()='View Admin']");
    }

    private By newButton(){
        return By.xpath("//*[contains(text(),'+ NEW')]//parent::button");
    }

    private By cancelButtonOnAddAdmin(){
        return By.id("btn-cancel-add-admin");
    }

    private By addAdminText(){
        return By.xpath("//div[@class='ant-modal-body']//h1");
    }

    private By saveButtonOnAddAdmin(String feature){ return By.id("btn-save-" + feature + "-admin");}

    private By nameText(){
        return By.xpath("//div[text()='Name Admin']");
    }

    private By fldNameAddAdmin(String feature){
        return By.id("fld-name-" + feature + "-admin");
    }

    private By fldUsernameAddAdmin(String feature){
        return By.id("fld-username-" + feature + "-admin");
    }

    private By fldPasswordAddAdmin(String feature){
        return By.id("fld-password-" + feature + "-admin");
    }

    private By fldEmailEmailAddAdmin(String feature){
        return By.id("fld-email-" + feature + "-admin");
    }

    private By fldPhoneNumberAddAdmin(String feature){
        return By.id("fld-phone-number-" + feature + "-admin");
    }

    private By editText(){
        return By.xpath("//h1[text()='Edit Admin']");
    }


    private By confirmDelete(){
        return By.id("btn-confirm-delete-admin");
    }

    private By cancelConfirmDelete(){
        return By.id("btn-cancel-delete-admin");
    }

    private By nameAdmin(int row){
        return By.xpath("//tr[" + row + "]//td[1]");
    }

    private By errorState(String result){
        return By.xpath("//div[text()=\"" +
                result +
                "\"]");
    }

    private By falsePass(String falsePass){
        return By.xpath("//li[text()=\"" +
                falsePass +
                "\"]");
    }

    @Step
    public static OpenUrl url(String targeturl){
        return new OpenUrl(targeturl);
    }

    @Step
    public void clickManageAdminMenu(){
        $(manageAdminMenu()).click();
    }

    @Step
    public boolean validateOnManageAdminMenu(){
        return $(manageAdminText()).getText().equals("Manage Admin");
    }

    @Step
    public void clickViewButton(int row){
        $(viewButton(row)).click();
    }

    @Step
    public void validatePopUpViewAdmin(){
        $(viewAdminText()).getText().equals("View Admin");
    }

    @Step
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

//    public void scrollTo(){
//        SerenityActions actions = new SerenityActions(getDriver());
//        actions.moveToElement($(cancelButtonOnAddAdmin()),0,500).perform();
////        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//    }


//    public static ScrollToWebElement to(WebElement element) {
//        return new ScrollToWebElement(element);
//    }

    @Step
    public void clickNewButton(){
        $(newButton()).click();
    }

    @Step
    public boolean validatePopUpAddAdmin(){
       return $(addAdminText()).getText().equals("Add Admin");
    }

    @Step
    public void clickCancelOnView(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
//        getDriver().switchTo().frame(modal);
        WebElement el = modal.findElement(cancelButtonOnAddAdmin());
        el.click();

    }

    @Step
    public void inputData(String name, String username, String password, String email, String phone_number, String feature){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (name.equals("new")){
            this.nama = general.randomName();
        }  else {
            this.nama = name;
        }
        modal.findElement(fldNameAddAdmin(feature)).sendKeys(this.nama);
        if (username.equals("new")){
            this.username = general.randomUsername();
        } else {
            this.username = username;
        }
        modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(this.username);
        modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(password);
        if (email.equals("new")){
            this.email = general.randomEmail();
        } else if (email.equals("same")){
            this.email = "jasrivika1307@gmail.com";
        } else if (email.equals("wrong")){
            this.email = "adminemail.com";
        } else {
            this.email = email;
        }
        modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email);
        modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(phone_number);
        modal.findElement(saveButtonOnAddAdmin(feature)).click();
    }


    @Step
    public void validateAfterAddAdmin(String result){
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
      if (result.equals("success")){
        validateOnManageAdminMenu();
      } else if(result.equals("falsePass")){
          modal.findElement(falsePass("- At least 6 characters")).isDisplayed();
          modal.findElement(falsePass("- At least 1 numeric character")).isDisplayed();
          modal.findElement(falsePass("- At least 1 lowercase character")).isDisplayed();
          modal.findElement(falsePass("- At least 1 uppercase character")).isDisplayed();
          modal.findElement(falsePass("- At the end must be a string")).isDisplayed();
      } else {
          modal.findElement(errorState(result)).isDisplayed();
      }
    }

//    public void clear(String feature){
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.className("ant-modal-body")));
//        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
//        modal.findElement(fldNameAddAdmin(feature)).clear();
//        modal.findElement(fldUsernameAddAdmin(feature)).clear();
//        modal.findElement(fldPasswordAddAdmin(feature)).clear();
//        modal.findElement(fldEmailEmailAddAdmin(feature)).clear();
//        modal.findElement(fldPhoneNumberAddAdmin(feature)).clear();
//    }

    @Step
    public void inputForEditAllValidData(String name, String username, String password, String email, String phone_number, String feature){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(fldNameAddAdmin(feature)).sendKeys(name, Keys.chord(Keys.CONTROL, "a"));
        modal.findElement(fldNameAddAdmin(feature)).sendKeys(name, Keys.ENTER);
        modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(username, Keys.chord(Keys.CONTROL, "a"));
        modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(username, Keys.ENTER);
        modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(password, Keys.chord(Keys.CONTROL, "a"));
        modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(password, Keys.ENTER);
        modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(email, Keys.chord(Keys.CONTROL, "a"));
        modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(email, Keys.ENTER);
        modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(phone_number, Keys.chord(Keys.CONTROL, "a"));
        modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(phone_number, Keys.ENTER);
    }

    @Step
    public void inputForEditAdmin(String name, String username, String password, String email, String phone_number, String feature){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));

        if (name.equals("new")){
            this.nama = general.randomName();
            modal.findElement(fldNameAddAdmin(feature)).sendKeys(this.nama, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldNameAddAdmin(feature)).sendKeys(this.nama, Keys.ENTER);
        }  else {
            this.nama = name;
            modal.findElement(fldNameAddAdmin(feature)).sendKeys(this.nama, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldNameAddAdmin(feature)).sendKeys(Keys.chord(Keys.BACK_SPACE));
        }

        if (username.equals("new")){
            this.username = general.randomUsername();
            modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(this.username, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(this.username, Keys.ENTER);
        } else {
            this.username = username;
            modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(this.username, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldUsernameAddAdmin(feature)).sendKeys(Keys.chord(Keys.BACK_SPACE));
        }
        if (password.equals("null")){
            modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(password, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(Keys.chord(Keys.BACK_SPACE));
        } else {
            modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(password, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldPasswordAddAdmin(feature)).sendKeys(password, Keys.ENTER);
        }

        if (email.equals("new")){
            this.email = general.randomEmail();
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.ENTER);
        } else if (email.equals("same")){
            this.email = "jasrivika1307@gmail.com";
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.ENTER);
        } else if (email.equals("wrong")){
            this.email = "adminemail.com";
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.ENTER);
        } else {
            this.email = email;
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(this.email, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldEmailEmailAddAdmin(feature)).sendKeys(Keys.BACK_SPACE);
        }
        if (phone_number.equals("null")){
            modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(phone_number, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(Keys.BACK_SPACE);
        } else {
            modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(phone_number, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldPhoneNumberAddAdmin(feature)).sendKeys(phone_number, Keys.ENTER);
        }

        modal.findElement(saveButtonOnAddAdmin(feature)).click();
    }

    @Step
    public void clearSomeData(String name, String feature){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (name != null) {
            modal.findElement(fldNameAddAdmin(feature)).clear();
        }
    }

    @Step
    public void inputName(String name, String feature){

      WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (name != null){
            modal.findElement(fldNameAddAdmin(feature)).sendKeys(name, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldNameAddAdmin(feature)).sendKeys(name, Keys.ENTER);
//            modal.findElement(fldNameAddAdmin(feature)).sendKeys(name, Keys.BACK_SPACE);
//            modal.findElement(fldNameAddAdmin(feature)).sendKeys(name);
        }
    }

    @Step
    public void clickSaveButton(String feature){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(saveButtonOnAddAdmin(feature)).click();
    }

    @Step
    public void clickEdit(int row){
        $(editButton(row)).click();
    }

    @Step
    public boolean validateEditModal(){
        return $(editText()).getText().equals("Edit Admin");
    }

    @Step
    public void clickDelete(int row){
        $(deleteButton(row)).click();
    }

    @Step
    public boolean validateConfirmDeleteModal(int row){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        return modal.findElement(editButton(row)).isDisplayed();
    }

    @Step
    public void clickConfirmDelete(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(confirmDelete()).click();
    }

    @Step
    public boolean validateDataWasDeleteSuccessfully(int row) throws Exception{
        name = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//name.json"), StandardCharsets.UTF_8);
        return $(nameAdmin(row)).getText().equals(name);
    }

    @Step
    public String getNameOnListForDelete(int row){
        String name = $(nameAdmin(row+1)).getText();
        System.out.println(name);
        try (FileWriter file = new FileWriter("src//test//resources//filejson//name.json")){
            file.write(name);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        return name;
    }

    @Step
    public void clickCancelButtonOnConfirmDelete(){
        $(cancelConfirmDelete()).click();
    }

    @Step
    public void clickButton(int row, String button){
        if (button.equals("view")){
            $(viewButton(row)).click();
        } else if(button.equals("edit")){
            $(editButton(row)).click();
        } else{
            $(deleteButton(row)).click();
        }
    }

    @Step
    public boolean validatePopUpShow(String button){
        if (button.equals("view")){
           return  $(viewAdminText()).isDisplayed();
        } else if (button.equals("delete")){
            return $(confirmDelete()).isDisplayed();
        } else {
          return   $(editText()).isDisplayed();
        }
    }

    @Step
    public void clickCancel(String button){
        $(cancelButtonOnModal(button)).click();
    }

    @Step
    public boolean validateResultAfterEditAdmin(int row){
        return $(nameAdmin(row)).getText().equals("Edit Admin");
    }

    @Step
    public void validateTheResultAfterEditAdminNotValid(String result){
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (result.equals("success")){
            validateOnManageAdminMenu();
        } else if(result.equals("falsePass")){
            modal.findElement(falsePass("- At least 6 characters")).isDisplayed();
            modal.findElement(falsePass("- At least 1 numeric character")).isDisplayed();
            modal.findElement(falsePass("- At least 1 lowercase character")).isDisplayed();
            modal.findElement(falsePass("- At least 1 uppercase character")).isDisplayed();
            modal.findElement(falsePass("- At the end must be a string")).isDisplayed();
        } else {
            modal.findElement(errorState(result)).isDisplayed();
        }
    }

}


