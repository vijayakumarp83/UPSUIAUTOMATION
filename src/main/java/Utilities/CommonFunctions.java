package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonFunctions {

    WebDriver driver;
    WebDriverWait wait;

    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default timeout
    }

    // Wait for element to be visible
    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Click an element
    public void clickElement(WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    // Enter text into an input field
    public void enterText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    // Verify if an element is displayed
    public boolean isElementDisplayed(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Get the current page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Validate if the current URL matches the expected URL
    public boolean validateUrl(String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }
    
    public static void takeScreenshot(WebDriver driver, Scenario scenario) {
    	
    	
    	 
    	try {
    	
    	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(screenshotBytes, "image/png", "Failed Step Screenshot");
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String path = "C:\\Users\\DELL\\eclipse-workspace\\UPSUIAUTOMATION\\screenshot\\screenshot_" + timestamp + ".png";
       FileUtils.copyFile(screenshot, new File(path));
        
            
        } catch (IOException e) {
            e.printStackTrace();
        
    }
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
    
    public static void jsScrollintoview(WebDriver driver,WebElement element) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    

    
}
