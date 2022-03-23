package com.visual.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen {
    AppiumDriver driver;

    public HomeScreen(AppiumDriver driver){
        this.driver = driver;
    }

    public void  waitForAllElementsToLoad(){
        WebDriverWait wait =  new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.AccessibilityId("listScreenID")));
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MobileElement getListButton(){
        return (MobileElement)driver.findElement(MobileBy.AccessibilityId("listScreenID"));
    }

    public MobileElement getLoginButton(){
        return (MobileElement)driver.findElement(MobileBy.AccessibilityId("loginButtonID"));
    }
    public MobileElement getSearchButton(){
        return (MobileElement)driver.findElement(MobileBy.AccessibilityId("searchScreenID"));
    }

}
