package com.visual.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CreateMobileDriver {

    public static AppiumDriver<MobileElement> driver;
    static DesiredCapabilities desiredCapabilities;
    static URL appiumHostURL;


    public static AppiumDriver launchApp(String appiumHost, DesiredCapabilities caps)  {
        try {appiumHostURL = new URL(appiumHost);}
        catch (MalformedURLException e) { e.printStackTrace(); }

        driver = new AppiumDriver<MobileElement>(appiumHostURL, caps);
        return driver;
    }

    public static AppiumDriver launchAndroid(String appiumHost, DesiredCapabilities androidCaps){
       return launchApp(appiumHost,androidCaps);
    }

    public static AppiumDriver launciOS(String appiumHost, DesiredCapabilities iosCaps){
        return launchApp(appiumHost,iosCaps);
    }


    public static DesiredCapabilities androidCapabilities(){
        DesiredCapabilities desiredCapabilities =  new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel_XL_API_29");
        desiredCapabilities.setCapability("uuid","emulator-5554");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("appPackage", "com.rapp");
        desiredCapabilities.setCapability("appActivity", "com.rapp.MainActivity");
        desiredCapabilities.setCapability("app","./AppFiles/Rappv1.apk");
        return desiredCapabilities;
    }





}
