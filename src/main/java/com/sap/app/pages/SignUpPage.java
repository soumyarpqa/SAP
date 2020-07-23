package com.sap.app.pages;

import com.sap.app.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

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
        /*String parent=  driver.getWindowHandle();
        System.out.println("parent window id is"+parent);*/
        signUpButton.click();
       /* Set<String> allwindows=driver.getWindowHandles();
        Iterator<String> it= allwindows.iterator();
        String parentid= it.next();
        System.out.println("Parent windowid::"+parentid);
        String childid=it.next();
        System.out.println("childwindowid is ::"+childid);
        driver.switchTo().window(childid);
        System.out.println("child window title"+driver.getTitle());

*/
      driver.switchTo().frame("IDS_UI_Window");


        }


    }




