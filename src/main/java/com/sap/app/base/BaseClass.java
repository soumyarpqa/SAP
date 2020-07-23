package com.sap.app.base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static RemoteWebDriver driver;
    DesiredCapabilities desiredCapabilities;
    public static Properties property;
    FileInputStream fileInputStream;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String br) throws MalformedURLException {
        try {
            property=new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/sap/app/config/config.properties");
            property.load(fileInputStream);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        desiredCapabilities = new DesiredCapabilities();
        if(br.equalsIgnoreCase("chrome")){
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        }
        else if(br.equalsIgnoreCase("chrome")){
            desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        }
        URL url= new URL("http://localhost:4444/wd/hub");
        driver= new RemoteWebDriver(url,desiredCapabilities);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(property.getProperty("url"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
