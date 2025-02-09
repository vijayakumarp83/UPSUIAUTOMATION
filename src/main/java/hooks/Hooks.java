package hooks;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.CommonFunctions;
import Utilities.ScreenshotUtils;
import base.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setup() throws InterruptedException {
    	//if (driver == null) {
    	DriverManager.getDriver(); 
    	
    	//}
    }
    


    @After
    public void teardown(Scenario scenario) throws IOException, InterruptedException {
    	WebDriver driver = DriverManager.getDriver();
	 try {
    	if (scenario.isFailed()) {
		  
			  CommonFunctions.takeScreenshot(driver,scenario);
	            
	        }
    	else {
    		CommonFunctions.takeScreenshot(driver,scenario);
    	}
    	}
	 finally {
		DriverManager.quitDriver();
	    }
          
    } 
   // public static WebDriver getDriver() {
  //      return driver.get();
    //}
//    }
    	//DriverManager.quitDriver();
    }

   

