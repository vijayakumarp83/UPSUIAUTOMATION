package Utilities;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Method to capture and save screenshot
    public String captureScreenshot(String scenarioName) {
        // Generate timestamp for unique filenames
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        // Define file path
        String filePath = "screenshots/" + scenarioName + "_" + timestamp + ".png";

        // Capture screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(filePath);

        try {
            // Save screenshot to the specified location
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }

        return filePath; // Return file path for reference
    }
}
