package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LoginpageObjects extends Base {

	public WebDriver driver;

	private By dashboard = By.cssSelector("[class='MuiButton-label']");
	private By username = By.cssSelector("#username");
	private By password = By.cssSelector("#password");
	private By submit = By.cssSelector("[value='Sign In']");
	private By clickdashboard = By.xpath("(//span[@class='MuiButton-label'])[2]");
	
	
	
	public LoginpageObjects(WebDriver driver) 
	{
		this.driver=driver;
	}



	public WebElement dashboard() throws InterruptedException
	{
		return driver.findElement(dashboard);
	}
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement submit()
	{
		return driver.findElement(submit);
	}
	public WebElement clickdashboard()
	{
		return driver.findElement(clickdashboard);
	}
}
