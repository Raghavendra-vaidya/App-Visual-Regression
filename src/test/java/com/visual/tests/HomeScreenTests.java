package com.visual.tests;

import com.visual.ui.HomeScreen;
import com.visual.utilities.CreateMobileDriver;
import com.visual.utilities.ProjectUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.visual.utilities.GetData.fromProperties;

public class HomeScreenTests {

    AppiumDriver<MobileElement> driver;
    HomeScreen home;
    static final String CHECK_HOME ="Home_Screen";
    String host = fromProperties("HOST", "configFile");


    @BeforeMethod
    public void setup(){
        driver = CreateMobileDriver.launchAndroid(host, CreateMobileDriver.androidCapabilities());
        home = new HomeScreen(driver);
    }

    @Test
    public void verifyHomeScreen(){

        home.waitForAllElementsToLoad();

        try
        {
            ProjectUtils.doVisualValidation(driver,CHECK_HOME,false);
        }
        catch (Exception e) {e.printStackTrace();}
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
