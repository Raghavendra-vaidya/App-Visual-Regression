package com.visual.tests;

import com.visual.utilities.CreateMobileDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeScreenTests {
    AppiumDriver<MobileElement> driver;


    @BeforeMethod
    public void setup(){
        driver = CreateMobileDriver.launchAndroid("http://0.0.0.0:4723/wd/hub", CreateMobileDriver.setAndroidcapabilities());
    }

    @Test
    public void verifyHomeScreen(){

    }





    @AfterMethod
    public void tearDown(){

    }


}
