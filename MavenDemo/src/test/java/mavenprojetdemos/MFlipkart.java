package mavenprojetdemos;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class MFlipkart 
{

	public WebDriver driver;
	  @Test
	  public void buyProduct() throws InterruptedException
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\\\Testing\\\\ChromeDriver103\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
		    driver= new ChromeDriver();
		    driver.get("https://www.flipkart.com/");
		    driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			//Thread.sleep(1000);
		  System.out.println("Test....Search and add to cart");
		  driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("T-shirt");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
		  driver.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/child :: div[@class='_3OO5Xc']/following-sibling :: button[@type='submit']")).click();//search
		  driver.findElement(By.xpath(" //div[@data-id='TSHFZKGHYGHXZFM5']/child :: div[@class='_1xHGtK _373qXS']/child  :: a[@class='_2UzuFa']")).click();//shirt selection
		  driver.findElement(By.xpath("//*[@id=\"swatch-4-size\"]/a"));//size
		  
		  JavascriptExecutor js= (JavascriptExecutor)driver;
		 // js.executeScript("document.getElementById('swatch-4-size').click();");//L size
		  
		  
		  driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();//add to cart
	  }
	 
	 /* @BeforeMethod
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
		  FileUtils.copyFile(src, new File("D:\\Testing\\Screenshot\\flip.png"));
		  
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
		  driver.get("https://www.flipkart.com/");
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
	  }*/

}
