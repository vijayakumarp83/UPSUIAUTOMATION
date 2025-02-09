package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.virtualauthenticator.HasVirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticator;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
    	String browser = ConfigReader.getProperty("BROWSER");
        if (driver == null) {
        	
        	//System.setProperty("webdriver.http.factory", "jdk-http-client");

        	// Default to Chrome
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                //s	WebDriverManager.chromedriver().clearDriverCache();
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    VirtualAuthenticatorOptions authenticatorOptions = new VirtualAuthenticatorOptions()
                    	    .setTransport(VirtualAuthenticatorOptions.Transport.USB)
                    	    .setHasResidentKey(true)
                    	    .setHasUserVerification(true);

                    	VirtualAuthenticator authenticator = ((HasVirtualAuthenticator) driver).addVirtualAuthenticator(authenticatorOptions);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.manage().window().maximize();
           // driver.manage().deleteAllCookies();
           // driver.navigate().refresh();

        }
        return driver;
    }

    public static void quitDriver() {
    	
    	if (driver != null) {
            driver.quit();
            driver = null;
        }
        
    }
}
