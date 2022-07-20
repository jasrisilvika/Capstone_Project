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

public class ManageMembershipPage extends PageObject {
    private String username;
    private By manageMembershipMenu(){
        return By.xpath("//div[text()='Manage Membership']//parent::li");
    }

    private By vd_button(int row, String vd_button){
        return By.xpath("//tr[" + row + "]//button[@id=\"btn-" + vd_button + "-membership\"]");
    }

    private By cancelButtonView(){return By.xpath("//div[@class=\"ant-modal-confirm-btns\"]//button");

    }

    private By cancelButtonDelete(){
        return By.xpath("//div[@class=\"ant-modal-body\"]//button[2]");
    }

    private By confirmDelete(){
        return By.xpath("//div[@class=\"ant-modal-body\"]//button[1]");
    }

    private By membershipText(){
        return By.xpath("//h1[text()=\"Manage Membership\"]");
    }

    private By viewMembershipText(){
        return By.xpath("//h1[text()=\"View Membership\"]");
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
    public void clickVDButton(int row, String vd_button) {
        $(vd_button(row, vd_button)).click();
    }

    @Step
    public void clickCancelButton(String vd_button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (vd_button.equals("view")){
            modal.findElement(cancelButtonView()).click();
        } else if (vd_button.equals("delete")){
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
    public boolean validateOnMembershipPage(){
        return $(membershipText()).isDisplayed();
    }


    @Step
    public boolean validatePopUpShow(String button){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("ant-modal-body")));
        WebElement modal = getDriver().findElement(By.className("ant-modal-body"));
        if (button.equals("view")){
            return modal.findElement(viewMembershipText()).isDisplayed();
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
    public void clickMembershipMenu(){
        $(manageMembershipMenu()).click();
    }
}
