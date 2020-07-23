package com.sap.app.testcases;

import com.sap.app.base.BaseClass;
import com.sap.app.pages.RegistrationPage;
import com.sap.app.pages.SignUpPage;
import com.sap.app.utility.Reporting;
import com.sap.app.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Hashtable;

@Listeners(Reporting.class)
public class TestPages extends BaseClass {

    String testcasename="RegistrationTest";
    String sheetName = "Registration";
    String actualText="Thank you for registering with SAP Conversational AI";

   @Test(dataProvider = "getTestData")
    public void ClickOnSignUpButton(Hashtable<String,String> data) throws InterruptedException {
        SignUpPage signUpPage= new SignUpPage();
        signUpPage.clickOnSignUpButton();
        Thread.sleep(5000);
        RegistrationPage registrationPage= new RegistrationPage();
        registrationPage.enterfirstName(data.get("FirstName"));
        Thread.sleep(1000);
        registrationPage.enterlastName(data.get("LastName"));
        Thread.sleep(1000);
        registrationPage.enterMail(data.get("Mail"));
        Thread.sleep(1000);
        registrationPage.enternewPassword(data.get("NewPassword"));
        Thread.sleep(1000);
        registrationPage.enterRetypePassword(data.get("RetypePassword"));
        Thread.sleep(1000);
        registrationPage.clickOnPrivacyStmntCheckBox();
        Thread.sleep(1000);
        registrationPage.clickOnTandCCheckBox();
        Thread.sleep(1000);
        registrationPage.clickOnregister();
       Thread.sleep(2000);
       String expectedtext=  driver.findElement(By.xpath("/html/body/main/div/div/h1")).getText();
       Assert.assertEquals(actualText,expectedtext);
       registrationPage.clickOnClose();

    }

    @DataProvider
    public Object[][] getTestData(){
        Object[][] data = Utility.getData(testcasename,sheetName);
        return data;
    }
}
