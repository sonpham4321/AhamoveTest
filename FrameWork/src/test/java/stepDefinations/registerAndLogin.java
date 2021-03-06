package stepDefinations;

import org.junit.runner.RunWith;
import FrameWork.base;
import PageObjects.BussinessTypePage;
import PageObjects.InvidialPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class registerAndLogin extends base{
	
	AndroidDriver<AndroidElement> driver;
	String codeNumber;
	
    @Given("^go to sign up page$")
    public void go_to_sign_up_page() throws Throwable {
        
    	driver=capabilities("AhaMoveApp");
    	LandingPage landingPage = new LandingPage(driver);
    	landingPage.RegisterButton.click();
    }

    @When("^fill out account information$")
    public void fill_out_account_information(String name, String phoneNumber, String email, String code) throws Throwable {
        
    	codeNumber = code;
    	SignUpPage signUpPage = new SignUpPage(driver);
		BussinessTypePage bussinessTypePage = new BussinessTypePage(driver);
		InvidialPage invidialPage = new InvidialPage(driver);
		
		signUpPage.NameTextBox.sendKeys(name);
		signUpPage.PhoneTextBox.sendKeys(phoneNumber);
		signUpPage.EmailTextBox.sendKeys(email);
		signUpPage.Categories.click();
		bussinessTypePage.Types.get(0).click();
		invidialPage.OtherIndival.click();
		invidialPage.SaveButton.click();
		signUpPage.CodeTextBox.sendKeys(code);
    }

    @Then("^complete register$")
    public void complete_register() throws Throwable {
    	
    	SignUpPage signUpPage = new SignUpPage(driver);
    	signUpPage.SignUpButton.click();
    }
    
    @Given("^Go to login page$")
    public void go_to_login_page() throws Throwable {
    	
    	driver=capabilities("AhaMoveApp");
    	LandingPage landingPage = new LandingPage(driver);
    	landingPage.LoginButton.click();
    }

    @Then("^login with phone name that already register$")
    public void login_with_phone_name_that_already_register() throws Throwable {
    	LoginPage loginPage = new LoginPage(driver);
    	loginPage.PhoneNumber.sendKeys(codeNumber);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
    }
}
