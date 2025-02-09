package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;

public class SignupPages {
	WebDriver driver;
	
	public SignupPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		/*if(!driver.getTitle().equals("TestProjectDemo")){
			throw new IllegalStateException("This is not the login page " + driver.getCurrentUrl());
		}*/
	}
	
	@FindBy(xpath="//input[@name='signUpName']")
	private WebElement signUpNameField;
	
	@FindBy(id="signUpEmail")
	private WebElement signUpEmailField;
	
	@FindBy(id="CountryCode_dropdown")
	private WebElement signUpCountrydropdown;
	
	@FindBy(name="phoneInput")
	private WebElement signUpPhoneField;
	
	@FindBy(id="signUpUserId")
	private WebElement signUpUserIDField;
	
	@FindBy(id="signUpPassword")
	private WebElement signUpPasswordField;
	
	//@FindBy(xpath="//div/input[@id='signUpAgreement']")
	@FindBy(xpath="//input[@id='signUpAgreement']")
	private WebElement signUpAgreementCheckbox;
	
	@FindBy(xpath="//label[contains(text(), 'which contain important terms about')]")
	private WebElement signUpAgreementunCheckbox;
	
	@FindBy(xpath="//button[contains(@class, 'ups-cta ups-cta_primary')]")
	private WebElement signUpSubmitbutton;
	
	@FindBy(xpath="//div[@id='signUpName_error']/p[@class='ups-formError']")
	private WebElement signUpName_Error;
	
	@FindBy(xpath="//div[@id='signUpName_error']/p/span[2]")
	private WebElement signUpName_Error_required;
	
	@FindBy(xpath="//div[@id='__tealiumImplicitmodal']/div/button/span")
	private WebElement cookies_Confirmation_Close;
	
	@FindBy(xpath="//div[@id='signUpEmail_error']/p[@class='ups-formError']")
	private WebElement signUpEmail_Error;
	
	// Error: Email is required.
	// Error: Username is required.
	@FindBy(xpath="//div[@id='signUpUserId_error']/p[@class='ups-formError']")
	private WebElement signUpUserID_Error;
	
	@FindBy(xpath="//div[@id=\"signUpPassword_error\"]/div/div/span")
	private WebElement signUpassword_Error;
	
	@FindBy(xpath="//div[@id=\"signUpAgreement_error\"]/div/div/span")
	private WebElement signUAgreement_Error;
	
	
	
	public void signupName(String name) {
		cookies_Confirmation_Close.click();	    
	    signUpNameField.sendKeys(name);
		
	}
	
	public void signupEmail(String emailID) {
		signUpEmailField.sendKeys(emailID);
		
	}
	
	public void signupPhone(String phone) {
		signUpPhoneField.sendKeys(phone);
	}
	
	public void signupUserId(String userId) {
		signUpUserIDField.sendKeys(userId);
	}
	
	public void signupPassword(String password) {
		signUpPasswordField.sendKeys(password);
	}
	
	public void signupCheckbox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
	    // Select the checkbox (if not already selected)
	    if (!signUpAgreementCheckbox.isSelected()) {
	    	//CommonFunctions.jsScrollintoview(driver, signUpSubmitbutton);
	        js.executeScript("arguments[0].checked = true;", signUpAgreementCheckbox);
	      
	    }
	}
	
	public void signupButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,10);");
		js.executeScript("arguments[0].removeAttribute('disabled');", signUpSubmitbutton);
	}
	
	public String signupNameError() {
		String signupNameError = signUpName_Error.getText();//+signUpName_Error_required.getText();
		//System.out.println(signupNameError);
		return signupNameError;
	}
	
	public String signupEmailError() {
		String signupEmailError = signUpEmail_Error.getText();//+signUpName_Error_required.getText();
		//System.out.println(signupNameError);
		return signupEmailError;
	}
	
	public String signupUseridError() {
		String signupUserIDError = signUpUserID_Error.getText();//+signUpName_Error_required.getText();
		//System.out.println(signupNameError);
		return signupUserIDError;
	}
	
	public String signupPasswordError() {
		String signupPasswordError = signUpassword_Error.getText();//+signUpName_Error_required.getText();
		//System.out.println(signupNameError);
		return signupPasswordError;
	}
	
	public String signupAgreementError() {
		String signupAgreementError = signUAgreement_Error.getText();//+signUpName_Error_required.getText();
		//System.out.println(signupNameError);
		return signupAgreementError;
	}
	
	public void editableName() {
		signUpNameField.click();
	}
	
	public void editableEmailID() {
		signUpEmailField.sendKeys("");
	}
	
	public void editablePassword() {
		signUpPasswordField.sendKeys("");
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,50);");
	}
	
	//*[@id="signUpAgreement_error"]/div/div/span
	
//	public String assertErrorMSG(WebElement web) {
//		String assertError = web.getText();//+signUpName_Error_required.getText();
//		//System.out.println(signupNameError);
//		return assertError;
//	}
	
	public void editableUserID() {
		signUpUserIDField.click();
	}
	
	public void scrollBy() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300);");
		
	}
	
	public void unSelectAgreement() {
		signUpAgreementunCheckbox.click();
        
//		js.executeScript("arguments[0].click();", signUpAgreementCheckbox);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].checked = false;", signUpAgreementCheckbox);
		
//		
//		js.executeScript("window.scrollBy(0,300);");
//	    // Select the checkbox (if not already selected)
//	    if (!signUpAgreementCheckbox.isSelected()) {
//	    	//CommonFunctions.jsScrollintoview(driver, signUpSubmitbutton);
//	        js.executeScript("arguments[0].checked = true;", signUpAgreementCheckbox);
//	        js.executeScript("arguments[0].checked = false;", signUpAgreementCheckbox);
//	      
//	    }
		
	}
	
//	
//	public String emailAssertErrorMSG = assertErrorMSG(signUpEmail_Error);
//	public String userIDAsserErrorMSG = assertErrorMSG(signUpUserID_Error);
//	public String passwordAssertErrorMSG = assertErrorMSG(signUpassword_Error);
	
	
	
	

}
