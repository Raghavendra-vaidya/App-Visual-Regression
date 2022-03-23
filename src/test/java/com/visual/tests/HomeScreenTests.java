package com.visual.tests;

import com.visual.utilities.CreateMobileDriver;
import com.visual.utilities.GetData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.visual.utilities.GetData.fromProperties;

public class HomeScreenTests {
    AppiumDriver<MobileElement> driver;

    String host = fromProperties("HOST", "configFile");


    @BeforeMethod
    public void setup(){
        driver = CreateMobileDriver.launchAndroid(host, CreateMobileDriver.androidCapabilities());
    }

    @Test
    public void verifyHomeScreen(){
        Assert.assertTrue(true);


    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
