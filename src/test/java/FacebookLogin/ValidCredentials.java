package FacebookLogin;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExcelRead.ExcelManip;

import org.testng.annotations.Parameters;
//import com.beust.jcommander.Parameter;
//import com.beust.jcommander.Parameters;

import Setup.DriverSetup;
import Setup.ReadProperties;

public class ValidCredentials {
	WebDriver driver;
	String url;
	@BeforeTest
	@Parameters ({"browser"})
	void setDriver(String browser) {
		System.out.println(browser);
		driver = DriverSetup.blah(browser);
		System.out.println(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ReadProperties rp = new ReadProperties();
		url = rp.getUrl();
		System.out.println(url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	@Parameters({"time"})
	void titleVerify(String time) {
		
		TakesScreenshot scrsht= (TakesScreenshot)driver;
		File SrcFile=scrsht.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\admin\\eclipse-workspace\\practice\\Screenshots\\"+time+"img.jpeg");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

	}

	
	@Test(priority = 2)
	@Parameters ({"email" , "pass"})
	void enterValues(String email , String pass) {
		ExcelManip ex=new ExcelManip();
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(ex.getExcel(driver.getTitle()));
		
		
	}

	@AfterTest(alwaysRun=true)
	void driverQuit() {
		DriverSetup.driverQuit();
	}

}
