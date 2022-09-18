package mavenprojetdemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mdemo 
{
	public WebDriver driver;

	@Test
	public void openWebPage()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\Testing\\\\ChromeDriver103\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.get("https://www.google.com/");
	}
}
