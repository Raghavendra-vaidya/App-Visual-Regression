package com.visual.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;

import java.io.File;


public class ProjectUtils {

    static String BASELINE = "BASEIMAGE_";
    static String VALIDATION_PATH = "./VisualImages";
    static double MATCH_THRESHOLD = 0.97;


    public static void doVisualValidation(AppiumDriver driver ,String checkName, boolean updateBaseImages) throws Exception {

            String baselineFilename = VALIDATION_PATH + "/" + BASELINE + checkName + ".png";
            File baselineImg = new File(baselineFilename);

            /** If no baseline image exists for this check, we should create a baseline image **/

            if (!baselineImg.exists() ) {
                System.out.println(String.format("No baseline found for '%s' check; capturing baseline instead of checking", checkName));
                File newBaseline = driver.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(newBaseline, new File(baselineFilename));
                Assert.assertTrue(true, "Updated the base images");
                return;
            }
            else if(updateBaseImages){
                deleteImagesOptimised();
                File newBaseline = driver.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(newBaseline, new File(baselineFilename));
                Assert.assertTrue(true, "Updated the base images");
                return;
            }

            /** Otherwise, if we found a baseline, get the image similarity from Appium. In getting the similarity,
             we also turn on visualization so we can see what went wrong if something did. **/

            SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
            opts.withEnabledVisualization();
            SimilarityMatchingResult res = driver.getImagesSimilarity(baselineImg, driver.getScreenshotAs(OutputType.FILE), opts);

            /** If the similarity is not high enough, consider the check to have failed **/
            if (res.getScore() < MATCH_THRESHOLD) {
                File failViz = new File(VALIDATION_PATH + "/FAIL_" + checkName + ".png");
                res.storeVisualization(failViz);

                Assert.assertTrue(false, "Visual regression failed with score of "+res.getScore());
            }

            /**  Otherwise, it passed!  **/
            Assert.assertTrue(true, "Visual validation passed with score of "+res.getScore());
            System.out.println(String.format("Visual check of '%s' passed; similarity match was %f",
                    checkName, res.getScore()));
        }


    public static void deleteImagesOptimised()
    {
        File parentFolder = new File("VisualImages/");
        if(parentFolder.exists() && parentFolder.list().length > 0)
        {
            String []names = parentFolder.list();
            for(String name: names)
            {
                FileUtils.deleteQuietly(new File("./screenshots/"+name));
            }

            //cleanDirectory method deletes folder contents
        }
        else
        {
            return;
        }
    }

}
