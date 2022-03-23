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

    public static DesiredCapabilities setCaps(Map capabilities){
        desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceName", capabilities.get("deviceName"));
        desiredCapabilities.setCapability("uuid",capabilities.get("uuid"));
        desiredCapabilities.setCapability("automationName", capabilities.get("automationName"));
        desiredCapabilities.setCapability("platformName", capabilities.get("platformName"));
        desiredCapabilities.setCapability("platformVersion", capabilities.get("platformVersion"));
        desiredCapabilities.setCapability("appPackage", capabilities.get("appPackage"));
        desiredCapabilities.setCapability("appActivity", capabilities.get("appActivity"));
        desiredCapabilities.setCapability("app","AppFiles/Rapp-V1.apk");

        return desiredCapabilities;
    }

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
        desiredCapabilities.setCapability("deviceName", "");
        desiredCapabilities.setCapability("uuid","");
        desiredCapabilities.setCapability("automationName", "");
        desiredCapabilities.setCapability("platformName", "");
        desiredCapabilities.setCapability("platformVersion", "");
        desiredCapabilities.setCapability("appPackage", "");
        desiredCapabilities.setCapability("appActivity", "");
        desiredCapabilities.setCapability("app","AppFiles/Rapp-V1.apk");
        return desiredCapabilities;
    }





}
