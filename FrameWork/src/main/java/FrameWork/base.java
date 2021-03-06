package FrameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException
	{
		AndroidDriver<AndroidElement> driver;
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\FrameWork\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		File appDir = new File("src\\main\\java\\Resources");
	    File app = new File(appDir, (String) prop.get(appName));
	    DesiredCapabilities capabilities = new DesiredCapabilities();
		
	    String device= System.getProperty("deviceName");
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
	    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	    
		return driver;
	}
}
