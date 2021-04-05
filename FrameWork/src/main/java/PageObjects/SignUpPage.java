package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {
	
	public SignUpPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//*[@text='Full name']")
	public WebElement NameTextBox;
	
	@AndroidFindBy(xpath="//*[@text='Phone number']")
	public WebElement PhoneTextBox;
	
	@AndroidFindBy(xpath="//*[@text='Email")
	public WebElement EmailTextBox;
	
	@AndroidFindBy(id="com.ahamove.user:id/imvEndIcon")
	public WebElement Categories;
	
	@AndroidFindBy(xpath="//*[@text='Referral code (Not required)']")
	public WebElement CodeTextBox;
	
	@AndroidFindBy(id="com.ahamove.user:id/submitBtn")
	public WebElement SignUpButton;

}
