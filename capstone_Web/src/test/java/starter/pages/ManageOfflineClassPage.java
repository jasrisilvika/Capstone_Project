package starter.pages;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class ManageOfflineClassPage extends PageObject {
    private String classOffline;

    private By manageOfflineClassMenu(){
        return By.xpath("//div[text()='Manage Offline Class']//parent::li");
    }
    private By crudButton(String crud_button, int row){
        return By.xpath("//tr[" + row + "]//button[@id='btn-" + crud_button + "-offline-class']");
    }

    private By addButton(){
        return By.id("btn-add-offline-class");
    }

    private By cancelButton(String cancel_button){
        return By.id("btn-cancel-" + cancel_button + "-offline-class");
    }

    private By saveButton(String save_button){
        return By.id("btn-save-" + save_button + "-offline-class");
    }

    private By cancelView(){
        return By.xpath("//div[@class='ant-modal-confirm-btns']//button");
    }

    private By manageOfflineClassText(){
        return By.xpath("//h1[text()='Manage Offline Class']");
    }

    private By fldNameClass(String crud_button){
        return By.id("fld-" + crud_button + "-name-class-offline-class");
    }

    private By fldTrainer(String crud_button){
        return By.id("fld-" + crud_button + "-trainer-offline-class");
    }

    private By fldDate(String crud_button){
        return By.id("fld-" + crud_button + "-date-offline-class");
    }

    private By fldTime(String crud_button){
        return By.id("fld-" + crud_button + "-time-offline-class");
    }

    private By fldLocation(String crud_button){
        return By.id("fld-" + crud_button + "-location-offline-class");
    }

    private By fldPrice(String crud_button){
        return By.id("fld-" + crud_button + "-price-offline-class");
    }

    private By fldDesc(String crud_button){
        return By.id("fld-" + crud_button + "-description-offline-class");
    }

    private By nameClassText(int row){
        return By.xpath("//tbody[@class='ant-table-tbody']//tr[" + row + "]//td[1]");
    }

    private By confirmDelete(){
        return By.id("btn-confirm-delete-offline-class");
    }

    private By editClassText(){
        return By.xpath("//h1[text()='Edit Class']");
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
    public void clickManageOfflineClass(){
        $(manageOfflineClassMenu()).click();
    }

    @Step
    public boolean validateOnManageOfflineClassMenu(){
       return $(manageOfflineClassText()).isDisplayed();
    }

    @Step
    public boolean viewOfflineClassPopUpShow(){
        return $(cancelView()).isDisplayed();
    }

    @Step
    public void clickCRUDbutton(String crud_button, int row){
        $(crudButton(crud_button, row)).click();
    }

    @Step
    public void clickCancelOnView(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(cancelView()).click();
    }

    @Step
    public void clickAddOnOfflineClass(){
        $(addButton()).click();
    }

    @Step
    public boolean validateAddOfflineClassPopUpShow(String crud_button){
       return $(saveButton(crud_button)).isDisplayed();
    }

    @Step
    public void inputDataForAddOfflineClass(String name_class, String trainer, String date, int time, String location, int price, String desc, String result, String crud_button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (result.equals("success")){
            modal.findElement(fldNameClass(crud_button)).sendKeys(name_class);
            modal.findElement(fldTrainer(crud_button)).sendKeys(trainer);
            modal.findElement(fldDate(crud_button)).sendKeys(date);
            modal.findElement(fldTime(crud_button)).sendKeys(Integer.toString(time));
            modal.findElement(fldLocation(crud_button)).sendKeys(location);
            modal.findElement(fldPrice(crud_button)).sendKeys(Integer.toString(price));
            modal.findElement(fldDesc(crud_button)).sendKeys(desc);
        }
    }

    @Step
    public void clickSaveButton(String crud_button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(saveButton(crud_button)).click();
    }

    @Step
    public void inputDataForEditOfflineClass(String name_class, String trainer, String date, int time, String location, int price, String desc, String result, String crud_button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if(result.equals("success")){
            modal.findElement(fldNameClass(crud_button)).sendKeys(name_class, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldNameClass(crud_button)).sendKeys(name_class, Keys.ENTER);
            modal.findElement(fldTrainer(crud_button)).sendKeys(trainer, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldTrainer(crud_button)).sendKeys(trainer, Keys.ENTER);
            modal.findElement(fldDate(crud_button)).sendKeys(date, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldDate(crud_button)).sendKeys(date, Keys.ENTER);
            modal.findElement(fldTime(crud_button)).sendKeys(Integer.toString(time), Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldTime(crud_button)).sendKeys(Integer.toString(time), Keys.ENTER);
            modal.findElement(fldLocation(crud_button)).sendKeys(location, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldLocation(crud_button)).sendKeys(location, Keys.ENTER);
            modal.findElement(fldPrice(crud_button)).sendKeys(Integer.toString(price), Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldPrice(crud_button)).sendKeys(Integer.toString(price), Keys.ENTER);
            modal.findElement(fldDesc(crud_button)).sendKeys(desc, Keys.chord(Keys.CONTROL, "a"));
            modal.findElement(fldDesc(crud_button)).sendKeys(desc, Keys.ENTER);
        }
    }

    @Step
    public boolean validateResultAfterEditOfflineClass(String result, int row, String name_class){
//        if (result.equals("success")){
            return $(nameClassText(row)).getText().equals(name_class);
//        }
    }
    @Step
    public boolean validateConfirmDeletePopUpShow(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        return modal.findElement(confirmDelete()).isDisplayed();
    }

    @Step
    public void clickConfirmButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        modal.findElement(confirmDelete()).click();
    }

    @Step
    public String getNameOnListForDelete(int row){

        String classOffline = $(nameClassText(row+1)).getText();
        System.out.println(classOffline);
        try (FileWriter file = new FileWriter("src//test//resources//filejson//class.json")){
            file.write(classOffline);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        return classOffline;
    }

    @Step
    public boolean validateDataWasDeletedSuccessfully(int row) throws Exception{
        classOffline = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//resources//filejson//class.json"), StandardCharsets.UTF_8);
        return $(nameClassText(row)).getText().equals(classOffline);
    }

    @Step
    public void clickCancelButton(String crud_button){
         $(cancelButton(crud_button)).click();
    }

    @Step
    public boolean editPopUpShow(){
        return $(editClassText()).isDisplayed();
    }
}


