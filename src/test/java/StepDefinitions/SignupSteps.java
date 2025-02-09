package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonFunctions;
import Utilities.ConfigReader;
import base.DriverManager;
import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import io.cucumber.plugin.event.HookTestStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageobjects.SignupPages;

public class SignupSteps {
//	 WebDriver driver;
//	WebElement element;
//	public SignupPages signuppages;
	
	WebDriver driver = DriverManager.getDriver();
	SignupPages signupPages = new SignupPages(driver);
	String baseUrl = ConfigReader.getProperty("BASEURL");
	CommonFunctions commonFunctions = new CommonFunctions(driver);
	
	@Given("Open the Signup Page")
	public void navigate() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//System.out.println(url1);
	
		//sedriver.get(baseUrl);
		driver.get(baseUrl);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
		Thread.sleep(2000);
	}
	
	@When("Enter the name")
	public void enterTheSignupName() {
		signupPages.signupName("Keerthana");
	}
	
	@And("Enter the email")
	public void enterTheSignupEmailID() {
		signupPages.signupEmail("Keerthana@ups.com");
	}
	
	@And("Enter the Phone")
	public void enterTheSignupPhone() {
		signupPages.signupPhone("9985855658");
	}
	
	@And("Enter the UserID")
	public void enterTheSignupUserID() {
		signupPages.signupUserId("Keerthan123");
	}
	
	@And("Enter the Password")
	public void enterTheSignupPassword() {
		signupPages.signupPassword("Admin@1234");
	}
	
	@And("Select the Agreement Checkbox")
	public void selecttheAgreementCheckbox() {
		signupPages.signupCheckbox();
	}
	
	@And("Submit the Button")
	public void completetheRegistration() {
		signupPages.signupButton();
	}
	
	@And("User should see an error message")
	public void userShouldSeeErrorMessage(Scenario scenario) {
	    // Take a screenshot if needed
	    CommonFunctions.takeScreenshot(driver, scenario);
	}
	
	@Then("the result")
    public void the_result_should_be() {
    	Assert.assertEquals("Success", "Welcome, User!");
    }
	
	@And("Edit the name field")
	public void editName() {
		signupPages.editableName();
	}
	
	@And("Edit the email field")
	public void editEmail() {
		signupPages.editableEmailID();
	}
	
	@And("Edit the UserID field")
	public void editUserID() {
		signupPages.editableUserID();
	}
//	
	@And("Edit the Password field")
	public void editPassword() {
		signupPages.editablePassword();
	}
	
	@And("Deselect the Agreement Checkbox")
	public void deselectAgreement() {
		signupPages.unSelectAgreement();
	}
	
//	
//	@And("Take Screenshot")
//	public void takeScreenshot(Scenario scenario) {
//		CommonFunctions.takeScreenshot(driver, scenario);
//	}
//	@Then("Close the driver")
//	public void tearDown() {
//		driver.quit();
//	}
	
	@And("Scroll the page")
	public void scrollBY() {
		signupPages.scrollBy();
	}
		@Then("Assert the name error")
		public void assertName() {
		String errorName=signupPages.signupNameError();
		String expecterrorName ="Error: First and Last Name is required.";
		Assert.assertEquals(errorName, expecterrorName);
		}
//	
@Then("Assert the email error")
public void assertEmail() {
	String expecterrorEmail = "Error: Email is required.";
	Assert.assertEquals(expecterrorEmail, signupPages.signupEmailError());
}
//
@Then("Assert the UserID error")
public void assertUserID() {
	String expecterrorUserID = "Error: Username is required.";
	Assert.assertEquals(expecterrorUserID, signupPages.signupUseridError());
}
@Then("Assert the Password error")
public void assertPassword() {
	String expecterrorPassword = "Error: Password is required.";
	Assert.assertEquals(expecterrorPassword, signupPages.signupPasswordError());
}

@Then("Assert the AgreementCheckbox error")
public void assertAgreementcheckbox() {
	String expecterrorAgreementcheckbox = "Error: Please Accept UPS Agreement.";
	Assert.assertEquals(expecterrorAgreementcheckbox, signupPages.signupAgreementError());
}
}
