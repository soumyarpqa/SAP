package com.sap.app.pages;

import com.sap.app.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {

    @FindBy(xpath="//*[@id='firstName']")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="mail")
    WebElement mail;

    @FindBy(id="newPasswordInput")
    WebElement newPasswordInput;

    @FindBy(id="retypeNewPasswordInput")
    WebElement retypeNewPasswordInput;

    @FindBy(id="pdAccept")
    WebElement pdAccept;

    @FindBy(id="touAccept")
    WebElement touAccept;

    @FindBy(id="sapStoreRegisterFormSubmit")
    WebElement register;

    @FindBy(xpath="//a[@title='Close']")
    WebElement close;

    public RegistrationPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterfirstName(String fname){
        firstName.clear();
        firstName.sendKeys(fname);
    }

    public void enterlastName(String lname){
        lastName.sendKeys(lname);
    }

    public void enterMail(String emailid){
        mail.sendKeys(emailid);
    }

    public void enternewPassword(String nPassword){
        newPasswordInput.sendKeys(nPassword);
    }

    public void enterRetypePassword(String rPassword){
        retypeNewPasswordInput.sendKeys(rPassword);
    }

    public void clickOnPrivacyStmntCheckBox(){
        pdAccept.click();
    }

    public void clickOnTandCCheckBox(){
        touAccept.click();
    }

    public void clickOnregister(){
        register.click();
    }

    public void clickOnClose(){
        close.click();
    }




}
