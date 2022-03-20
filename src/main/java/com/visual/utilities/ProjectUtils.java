package com.visual.utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ProjectUtils {



    public void captureScreen(AppiumDriver driver, ITestResult result){

        TakesScreenshot ts =(TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String mName  = result.getName();//name of the screenshot
        String cName = result.getInstanceName();
        File destinationName = new File("./images/"+cName+"/"+mName+".png");

        try {
            Files.copy(source.toPath(), destinationName.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
