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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(mavenprojetdemos.ProjectListeners.class)
public class ProjectDemoWebShop
{

	public WebDriver driver;
	  @Test(priority = 1, dataProvider = "getData")
	  public void aRegister(String firstname, String lastname, String email, String password, String cpassword)
	  {
		  System.out.println("Test....registration check");
		  driver.findElement(By.id("gender-female")).click();//gender
		  driver.findElement(By.name("FirstName")).sendKeys(firstname);
		  driver.findElement(By.name("LastName")).sendKeys(lastname);
		  driver.findElement(By.name("Email")).sendKeys(email);
		  driver.findElement(By.name("Password")).sendKeys(password);
		  String currentpassword = driver.findElement(By.name("Password")).getAttribute("value");
		  String expectedpassword= "cjc@54321";
		  Assert.assertEquals(currentpassword, expectedpassword);
		  
		  driver.findElement(By.name("ConfirmPassword")).sendKeys(cpassword);
		  driver.findElement(By.id("register-button")).click();
		  
		  System.out.println("Registration success...");
	  }
	  
	  @Test(priority = 2)
	  public void bContinue() throws InterruptedException
	  {
		  System.out.println("Continue...");
		  driver.findElement(By.xpath("//input[@class='button-1 register-continue-button']")).click();//gender
		  System.out.println("add to cart");
		  driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[7]/div/div[2]/div[3]/div[2]/input")).click();
		  //driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();
		  driver.findElement(By.xpath("//*[@id=\"product_attribute_75_5_31_96\"]")).click();//processor radio button
		  driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']")).click();//add to cart
		 
		 String text = driver.findElement(By.linkText("Shopping cart")).getText();
		 SoftAssert sa= new SoftAssert();
		 String etext= "Shopping cart";
		 sa.assertEquals(text, etext);
		  
		  driver.findElement(By.linkText("Shopping cart")).click();//add to cart link
		  Thread.sleep(1000);
		
	  }
	  @Test(priority = 3)
	  public void shoppingCart() throws InterruptedException
	  {
		 System.out.println("Inside Shopping cart...");
		  WebElement dd= driver.findElement(By.xpath("//select[@id='CountryId']"));//select destination country
		  Select s= new Select(dd);
		  s.selectByVisibleText("India");
		  
		  driver.findElement(By.xpath("//input[@id='termsofservice']")).click();//i agree check box
		  driver.findElement(By.xpath("//button[@class='button-1 checkout-button']")).click();//checkout
		 
		  Thread.sleep(1000);
		
	  }
	  @Test(priority = 4)
	  public void billingAddress() throws InterruptedException
	  {
		 System.out.println("Billing...");
		  WebElement dd1= driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));//select destination country
		  Select s1= new Select(dd1);
		  s1.selectByVisibleText("India");
		  
		  driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Pune");//city
		  driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Karvenagar");//address
		  driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("51");//postal code
		  driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("543210");//phone number
		  driver.findElement(By.xpath("//input[@onclick='Billing.save()']")).click();//continue
		  Thread.sleep(1000);
		
	  }
	  
	  @Test(priority = 5)
	  public void shippingAddress() throws InterruptedException
	  {
		 System.out.println("Shipping...");
		 
		  
		  driver.findElement(By.xpath("//input[@id='PickUpInStore']")).click();//in store pickup
		  
		  driver.findElement(By.xpath("//input[@onClick='Shipping.save()']")).click();//continue
		  Thread.sleep(1000);
		
	  }
	  
	  @Test(priority = 6)
	  public void payment() throws InterruptedException
	  {
		 System.out.println("Payment Method...");
		 
		  
		  driver.findElement(By.xpath("//input[@id='paymentmethod_0']")).click();//COD
		  
		  driver.findElement(By.xpath("//input[@onClick='PaymentMethod.save()']")).click();//continue
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@onClick='PaymentInfo.save()']")).click();
		
	  }
	  
	  @Test(priority = 7)
	  public void confirmOrder()
	  {
		 System.out.println("Confirm Order...");
		 
		  
		  driver.findElement(By.xpath("//input[@onClick='ConfirmOrder.save()']")).click();//confirm
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
		  }
	  }

	  @AfterMethod
	  public void captureScreenShot()throws IOException 
	  {
		  System.out.println("AfterMethod....capture screenshot");
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFileToDirectory(src, new File("D:\\Testing\\Screenshot"));
		  
	  }

	  @BeforeClass
	  public void maximize() {
		  System.out.println("BeforeClass...maximize");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  }

	  @AfterClass
	  public void deleteCookies() {
		  System.out.println("AfterClass...delete cookies");
	  }

	  @BeforeTest
	  public void enterUrl() {
		  System.out.println("BeforeTest...enter url");
		  driver.get("http://demowebshop.tricentis.com/register");
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
	  public void closeBrowser() throws InterruptedException
	  {
		  
		  Thread.sleep(2000);
		  driver.close();
		  
		  System.out.println("Browser closed...");
	  }
	  
	  @DataProvider
	  public Object getData()
	  {
		  return new Object[][]
				  {
			  
			  new Object[] {"cjc","classes","cjc.classes141@gmail.com","cjc@54321","cjc@54321"}
				  };
	  }


}
