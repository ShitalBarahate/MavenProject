package mavenprojetdemos;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenDemoGuru 
{

	public WebDriver driver;
	  @Test
	  public void loginCheck()
	  {
		  System.out.println("Test....login check");
		  driver.findElement(By.name("userName")).sendKeys("QQQQ");
		  driver.findElement(By.name("password")).sendKeys("qqqq");
		  driver.findElement(By.name("submit")).click();
		  System.out.println("Login success...");
	  }
	  @BeforeMethod
	  public void getCookies() {
		  System.out.println("BeforeMethod...get cookies");
		  Set<Cookie> cookies= driver.manage().getCookies();
		  System.out.println("Total cookies present here:"+cookies.size());
		  for(Cookie cookie : cookies)
		  {
			  System.out.println("Cookie name:"+cookie.getName());
			  System.out.println("Is cookie secure:"+cookie.isSecure());
			  System.out.println("=====================");
		  }
	  }

	  @AfterMethod
	  public void captureScreenShot()throws IOException 
	  {
		  System.out.println("AfterMethod....capture screenshot");
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("D:\\Testing\\Screenshot\\mercury.png"));
		  
	  }

	  @BeforeClass
	  public void maximize() {
		  System.out.println("BeforeClass...maximize");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  }

	  @AfterClass
	  public void deleteCookies() {
		  System.out.println("AfterClass...delete cookies");
	  }

	  @BeforeTest
	  public void enterUrl() {
		  System.out.println("BeforeTest...enter url");
		  driver.get("https://demo.guru99.com/test/newtours/index.php");
	  }

	  @AfterTest
	  public void dbClose()
	  {
		  System.out.println("After test DB connection close");
	  }

	  @BeforeSuite
	  public void openBrowser() 
	  {
		System.out.println("BeforeSuite...openBrowser");
		System.setProperty("webdriver.chrome.driver", "D:\\\\Testing\\\\ChromeDriver103\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
	    driver= new ChromeDriver();
	  }

	  @AfterSuite
	  public void closeBrowser() {
		  driver.close();
		  System.out.println("Browser closed...");
	  }

}
