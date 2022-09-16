package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CPsummaryoverviewObjects 
{

	public WebDriver driver;
	private By dashboard = By.cssSelector("[class='MuiButton-label']");
	private By username = By.cssSelector("#username");
	private By password = By.cssSelector("#password");
	private By submit = By.cssSelector("[value='Sign In']");
	private By clickdashboard = By.xpath("(//span[@class='MuiButton-label'])[2]");
	private By customerpay=By.xpath("(//span[@class='MuiButton-label'])[11]");
	private By summary=By.xpath("(//span[@class='MuiButton-label'])[12]");
	private By clickfav=By.xpath("(//span[@class='MuiButton-label'])[9]");
	private By favsize=By.xpath("//div[contains(@class,'react-grid-item jss')]");
	private By removfav=By.xpath("(//span[@class='MuiIconButton-label'])[5]");
	private By favtxt=By.xpath("//span[@class='MuiTab-wrapper']//div");
	private By cpsize=By.xpath("//canvas[contains(@id,'chart')]");
	private By addtofav=By.xpath("(//span[@class='MuiIconButton-label'])");
	private By chart_942=By.xpath("//canvas[@id='chart_942']");
	private By chart_939=By.xpath("//canvas[@id='chart_939']");
	private By chart_940=By.xpath("//canvas[@id='chart_940']");
	private By chart_920=By.xpath("//canvas[@id='chart_920']");
	private By chart_946=By.xpath("//canvas[@id='chart_946']");
	private By chart_1238=By.xpath("//canvas[@id='chart_1238']");
	
	private By zchart_942=By.xpath("(//span[@class='MuiIconButton-label'])[2]");
	private By zchart_939=By.xpath("(//span[@class='MuiIconButton-label'])[7]");
	private By zchart_940=By.xpath("(//span[@class='MuiIconButton-label'])[12]");
	private By zchart_920=By.xpath("(//span[@class='MuiIconButton-label'])[17]");
	private By zchart_946=By.xpath("(//span[@class='MuiIconButton-label'])[22]");
	private By zchart_1238=By.xpath("(//span[@class='MuiIconButton-label'])[27]");
	private By zoomgraph=By.xpath("//img[@src='/images/zoom-in.png']");
	private By dataasof=By.xpath("((//div[contains(@class,'MuiGrid-root jss')])[4]//p)[1]");
	private By source=By.xpath("((//div[@class='react-grid-item diagram-section react-draggable cssTransforms' and @style='width: 511px; height: 270px; position: absolute; transform: translate(10px, 10px);' ]//child::div)[5])//child::canvas[@id='chart_942']");
	private By target=By.xpath("((//div[@class='react-grid-item diagram-section react-draggable cssTransforms' and @style='width: 511px; height: 270px; position: absolute; transform: translate(531px, 10px);' ]//child::div)[5])//child::canvas[@id='chart_939']");
	private By newdragpos=By.xpath("((//div[@class='react-grid-item diagram-section react-draggable cssTransforms' and @style='width: 511px; height: 270px; position: absolute; transform: translate(531px, 10px);' ]//child::div)[5])//child::canvas[@id='chart_942']");
	private By resetbutton=By.xpath("(//span[@class='MuiButton-label'])[54]");
	private By cpsummaryoverview=By.xpath("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-6']//h4");
	
	
	//By favorities=By.xpath("(//*[name()='svg']//*[local-name()='path'])");
	
	public CPsummaryoverviewObjects(WebDriver driver) 
	{
		this.driver=driver;
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
	
	public WebElement customerpay() 
	{
		return driver.findElement(customerpay);
	}
	public WebElement summary() 
	{
		return driver.findElement(summary);
	}
	public WebElement clickfav() 
	{
	    return driver.findElement(clickfav);
	}
	public List<WebElement> favsize() 
	{
	    return driver.findElements(favsize);
	}
	public WebElement removefav() 
	{
	    return driver.findElement(removfav);
	}
	public WebElement favtxt() 
	{
	    return driver.findElement(favtxt);
	}
	public void addtofav() throws InterruptedException 
	{
		int cpsize=driver.findElements(By.xpath("//canvas[contains(@id,'chart')]")).size();
		int cpval=cpsize*5;
		int j=5;
		while(j<=cpval)
		{
			driver.findElement(By.xpath("(//span[@class='MuiIconButton-label'])["+j+"]")).click();
			Thread.sleep(2000);
			j=j+5;
			Thread.sleep(2000);
		}
	}
	public WebElement chart_942() 
	{
	    return driver.findElement(chart_942);
	}
	public WebElement chart_939() 
	{
	    return driver.findElement(chart_939);
	}
	public WebElement chart_940() 
	{
	    return driver.findElement(chart_940);
	}
	public WebElement chart_920() 
	{
	    return driver.findElement(chart_920);
	}
	public WebElement chart_946() 
	{
	    return driver.findElement(chart_946);
	}
	public WebElement chart_1238() 
	{
	    return driver.findElement(chart_1238);
	}
	
	public void valtooltip() throws InterruptedException
	{
		Actions action=new Actions(driver);
		try
		{
			Thread.sleep(3000);
			action.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root jss')])[3]"))).build().perform();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isDisplayed();
			System.out.println("CP Revenue tool tip is validated");
		}catch(NoSuchElementException e)
		{
			System.out.println("CP Revenue tool tip is missing");
		}
		Thread.sleep(3000);
		try
		{
			action.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root jss')])[8]"))).build().perform();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isDisplayed();
			System.out.println("CP Gross Profit tool tip is validated");
		}catch(NoSuchElementException e)
		{
			System.out.println("CP Gross Profit tool tip is missing");
		}
		Thread.sleep(3000);
		try
		{
			action.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root jss')])[13]"))).build().perform();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isDisplayed();
			System.out.println("CP Gross Profit Percentage tool tip is validated");
		}catch(NoSuchElementException e)
		{
			System.out.println("CP Gross Profit Percenatge tool tip is missing");
		}
		Thread.sleep(3000);
		try
		{
			action.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root jss')])[18]"))).build().perform();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isDisplayed();
			System.out.println("CP Labor Sold Hours tool tip is validated");
		}catch(NoSuchElementException e)
		{
			System.out.println("CP Labor Sold Hours tool tip is missing");
		}
		Thread.sleep(3000);
		try
		{
			action.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root jss')])[23]"))).build().perform();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isDisplayed();
			System.out.println("CP Effective Labor Rate tool tip is validated");
		}catch(NoSuchElementException e)
		{
			System.out.println("CP Effective Labor Rate tool tip is missing");
		}
		Thread.sleep(3000);
		try
		{
			action.moveToElement(driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root MuiIconButton-root jss')])[28]"))).build().perform();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isEnabled();
			driver.findElement(By.xpath("//button[contains(@aria-describedby,'mui')]")).isDisplayed();
			System.out.println("CP Parts Markup tool tip is validated");
		}catch(NoSuchElementException e)
		{
			System.out.println("CP Parts Markup tool tip is missing");
		}	
	}
	
	public WebElement zchart_942() 
	{
	    return driver.findElement(zchart_942);
	}
	public WebElement zchart_939() 
	{
	    return driver.findElement(zchart_939);
	}
	public WebElement zchart_940() 
	{
	    return driver.findElement(zchart_940);
	}
	public WebElement zchart_920() 
	{
	    return driver.findElement(zchart_920);
	}
	public WebElement zchart_946() 
	{
	    return driver.findElement(zchart_946);
	}
	public WebElement zchart_1238() 
	{
	    return driver.findElement(zchart_1238);
	}
	
	public WebElement zoomgraph() 
	{
	    return driver.findElement(zoomgraph);
	}
	public WebElement dataasof() 
	{
		return driver.findElement(dataasof);
	}
	public WebElement source() 
	{
		return driver.findElement(source);
	}
	public WebElement target() 
	{
		return driver.findElement(target);
	}
	public WebElement reset() 
	{
		return driver.findElement(resetbutton);
	}
	public WebElement newdragpos() 
	{
		return driver.findElement(newdragpos);
	}
	public WebElement cpsumoverview() 
	{
		return driver.findElement(cpsummaryoverview);
	}
	
	
	
	
}
