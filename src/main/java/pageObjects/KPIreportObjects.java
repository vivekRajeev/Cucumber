package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KPIreportObjects 
{

	public WebDriver driver;
	
	private By customer=By.xpath("(//span[@class='MuiButton-label'])[11]");
	private By kpi=By.xpath("(//span[@class='MuiButton-label'])[13]");
	private By durations=By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']//li");
	private By seldate=By.xpath("(//tr//td//span)[3]");
	private By dashboard = By.cssSelector("[class='MuiButton-label']");
	private By username = By.cssSelector("#username");
	private By password = By.cssSelector("#password");
	private By submit = By.cssSelector("[value='Sign In']");
	private By clickdashboard = By.xpath("(//span[@class='MuiButton-label'])[2]");
	private By duraclk=By.xpath("//div[@class='MuiFormControl-root MuiFormControl-marginDense']");
	
	public KPIreportObjects(WebDriver driver) 
	{
	  this.driver=driver;
	}

	public WebElement clickcustomer()
	{
		return driver.findElement(customer);
	}
	
	public WebElement kpi()
	{
		return driver.findElement(kpi);
	}
	
	public List<WebElement> durations()
	{
		return driver.findElements(durations);
	}
	
	public WebElement seldate()
	{
		return driver.findElement(seldate);
	}
	public WebElement getdashboard() 
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

	public WebElement clkdash() 
	{
		return driver.findElement(clickdashboard);
	}
	public WebElement duraclk() 
	{
		return driver.findElement(duraclk);
	}
	
	
	
}
