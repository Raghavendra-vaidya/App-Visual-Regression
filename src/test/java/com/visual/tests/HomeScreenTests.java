package com.visual.tests;

import com.visual.ui.HomeScreen;
import com.visual.utilities.CreateMobileDriver;
import com.visual.utilities.GetData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.visual.utilities.GetData.fromProperties;

public class HomeScreenTests {
    AppiumDriver<MobileElement> driver;
    HomeScreen home;

    String host = fromProperties("HOST", "configFile");


    @BeforeMethod
    public void setup(){
        driver = CreateMobileDriver.launchAndroid(host, CreateMobileDriver.androidCapabilities());
        home = new HomeScreen(driver);
    }

    @Test
    public void verifyHomeScreen(){

        home.waitForAllElementsToLoad();
        Assert.assertTrue(home.getListButton().isDisplayed());
        Assert.assertTrue(home.getLoginButton().isDisplayed());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
