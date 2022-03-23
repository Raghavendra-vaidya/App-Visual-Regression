package com.visual.tests;

import com.visual.utilities.CreateMobileDriver;
import com.visual.utilities.ProjectUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.visual.utilities.GetData.fromProperties;

public class LoginScreenTests {

    AppiumDriver<MobileElement> driver;
    com.visual.ui.HomeScreen home;
    static final String CHECK_LOGIN ="Login_Screen";
    String host = fromProperties("HOST", "configFile");


    @BeforeMethod
    public void setup(){
        driver = CreateMobileDriver.launchAndroid(host, CreateMobileDriver.androidCapabilities());
        home = new com.visual.ui.HomeScreen(driver);
    }

    @Test
    public void verifyHomeScreen(){

        home.waitForAllElementsToLoad();
        home.getLoginButton().click();

        try {
            Thread.sleep(2000);
            ProjectUtils.doVisualValidation(driver,CHECK_LOGIN,false);
        } catch (Exception e) {e.printStackTrace();}
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
