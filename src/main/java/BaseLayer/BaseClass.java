package BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	//declare the reference of WebDriver globally so we can access in other class
	protected static WebDriver driver;
	
	public static void initialization()
	{
		//1. connect to the actual browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\AllDrivers\\chromedriver.exe");
		
		//2.up casting
		driver= new ChromeDriver();
		
		//3 maximize browser
		driver.manage().window().maximize();
		
		//4. implicitlyWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//5. pageLoadTimeout
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		//6. delete all cookies
		driver.manage().deleteAllCookies();
		//7. open a url
		driver.get("https://portal2.passportindia.gov.in/AppOnlineProject/user/RegistrationBaseAction?request_locale=en");
	}
	
}
