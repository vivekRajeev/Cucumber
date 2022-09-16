package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FixedOpsregressionObjects {

	public WebDriver driver;
	
	By armatusLogo=By.cssSelector("[src='/images/logos/armatus-new-logo.png']");
	By callemailLogo=By.cssSelector("[src='/images/call-email-icon.svg']");
	By title=By.cssSelector("[class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-colorInherit']");
	By dashboard=By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-colorInherit'])[1]");
	By version=By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-colorInherit'])[2]");
	By version1=By.cssSelector("p:nth-child(2)");
	By mousehover=By.xpath("//span[@class='MuiIconButton-label']");
	By contactus=By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5']");
	By callimg=By.xpath("(//*[name()='svg'])[3]");
	By mailimg=By.xpath("(//*[name()='svg'])[4]");
    By mobno=By.xpath("(//span[@class='MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock'])[1]");
    By emailid=By.xpath("(//span[@class='MuiTypography-root MuiListItemText-primary MuiTypography-body1 MuiTypography-displayBlock'])[2]");
    By sigin=By.cssSelector("[class='MuiTypography-root MuiTypography-h3 MuiTypography-gutterBottom']");
	
	
	public FixedOpsregressionObjects(WebDriver driver) 
	{
		this.driver=driver;
	}

	public WebElement armatusLogo()
	{
		return driver.findElement(armatusLogo);
	}
	public WebElement callemailLogo()
	{
		return driver.findElement(callemailLogo);
	}
	public WebElement title()
	{
		return driver.findElement(title);
	}
	public WebElement dashboard()
	{
		return driver.findElement(dashboard);
	}
	public WebElement version()
	{
		return driver.findElement(version);
	}
	public WebElement contactus()
	{
		return driver.findElement(contactus);
	}
	public WebElement mousehover()
	{
		return driver.findElement(mousehover);
	}
	public WebElement callimg()
	{
		return driver.findElement(callimg);
	}
	public WebElement mailimg()
	{
		return driver.findElement(mailimg);
	}
	public WebElement mobno()
	{
		return driver.findElement(mobno);
	}
	public WebElement email()
	{
		return driver.findElement(emailid);
	}
	public WebElement sigin()
	{
		return driver.findElement(sigin);
	}
	
}
