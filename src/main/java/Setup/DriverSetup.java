package Setup;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	public static RemoteWebDriver driver, driver1;

	public static WebDriver blah(String browser)
 {    
	 //System.out.println(browser);
	 
	
		if(browser.equals("Chrome"))
		{System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\eclipse-workspace\\practice\\src\\test\\resources\\drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  }
		else if(browser.equals("Edge")){
			System.setProperty("webdriver.edge.driver","C:\\Users\\admin\\eclipse-workspace\\practice\\src\\test\\resources\\drivers\\msedgedriver.exe");
			  driver = new EdgeDriver();
		}
		  System.out.println(driver);
		  return driver;
		
	
 }

	public static void driverClose() {
		driver.close();
	}

	public static void driverQuit() {
		driver.quit();
	}
}
