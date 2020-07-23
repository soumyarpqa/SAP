package com.sap.app.pages;

import com.sap.app.base.BaseClass;
import com.sap.app.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseClass {

    @FindBy(xpath="//div[contains(text(),'Sign up')]")
    WebElement signUpButton;

    @FindBy(xpath="//div[@class='ml3 sc-bZQynM cCLMsV sc-EHOje dXZRce']/div")
    WebElement acceptCookies;

    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignUpButton() throws InterruptedException {
        acceptCookies.click();
        Thread.sleep(2000);
        signUpButton.click();
        driver.switchTo().frame("IDS_UI_Window");
        }
    }




