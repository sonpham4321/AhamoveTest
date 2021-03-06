package TestCases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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

public class RegistrationAndLogin extends base{

	static String phone;
	@Test (dataProvider = "data-provider")
	public void Registration_Test(String name, String phoneNumber, String email, String code) throws IOException
	{
		phone = phoneNumber;
		AndroidDriver<AndroidElement> driver=capabilities("AhaMoveApp");
		LandingPage landingPage = new LandingPage(driver);
		SignUpPage signUpPage = new SignUpPage(driver);
		BussinessTypePage bussinessTypePage = new BussinessTypePage(driver);
		InvidialPage invidialPage = new InvidialPage(driver);
		
		// go to sign up page
		landingPage.RegisterButton.click();
		
		// fill out account information
		signUpPage.NameTextBox.sendKeys(name);
		signUpPage.PhoneTextBox.sendKeys(phoneNumber);
		signUpPage.EmailTextBox.sendKeys(email);
		signUpPage.Categories.click();
		bussinessTypePage.Types.get(0).click();
		invidialPage.OtherIndival.click();
		invidialPage.SaveButton.click();
		signUpPage.CodeTextBox.sendKeys(code);
		
		// complete register
		signUpPage.SignUpButton.click();
	}
	
	@Test
	public void Login_Test() throws IOException
	{
		AndroidDriver<AndroidElement> driver=capabilities("AhaMoveApp");
		
		LandingPage landingPage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		// Go to login page
		landingPage.LoginButton.click();
		
		// login with phone name that already register
		loginPage.PhoneNumber.sendKeys(phone);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"Pham Vu Lam Truong Son"}, {"0973591723"}, {"sonphamlearning221@gmail.com"},
			{"700000"}};
	 }
}
