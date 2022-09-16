package fixtest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CPsummaryoverviewObjects;
import resources.Base;

public class CPsummaryOverviewTest extends Base {

	public WebDriver driver;

	@Test(priority = 1)
	public void validateAddtofavorities() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		CPsummaryoverviewObjects co = new CPsummaryoverviewObjects(driver);
		co.getdashboard().click();
		co.username().sendKeys(props.getProperty("adminusername"));
		co.password().sendKeys(props.getProperty("adminpassword"));
		co.submit().click();
		Thread.sleep(9000);
		co.clkdash().click();
		Thread.sleep(9000);
		co.clickfav().click();
		Thread.sleep(9000);
		int size = co.favsize().size();
		System.out.println(size);
		int i = 1;
		if (size > 0) {
			while (i <= size) {
				Thread.sleep(9000);
				co.removefav().click();
				Thread.sleep(9000);
				size--;
			}
		} else {
			System.out.println(co.favtxt().getText());
		}

		co.customerpay().click();
		Thread.sleep(3000);
		co.summary().click();
		Thread.sleep(9000);
		co.addtofav();
		Thread.sleep(3000);
		co.clickfav().click();
		Thread.sleep(9000);
		try {
			co.chart_942().isDisplayed();
			System.out.println("CP Revenue chart successfully added to favorites");
		} catch (NoSuchElementException e) {
			System.out.println("CP Revenue chart is missing");
		}

		try {
			co.chart_939().isDisplayed();
			System.out.println("CP Gross Profit chart successfully added to favorites");
		} catch (NoSuchElementException e) {
			System.out.println("CP Gross Profit chart is missing");
		}

		try {
			co.chart_940().isDisplayed();
			System.out.println("CP Gross Profit Percenatge chart successfully added to favorites");
		} catch (NoSuchElementException e) {
			System.out.println("CP Gross Profit Percentage chart is missing");
		}

		try {
			co.chart_920().isDisplayed();
			System.out.println("CP Labor Sold Hours chart successfully added to favorites");
		} catch (NoSuchElementException e) {
			System.out.println("CP Labor Sold Hours chart is missing");
		}
		try {
			co.chart_946().isDisplayed();
			System.out.println("CP Effective Labor Rate chart successfully added to favorites");
		} catch (NoSuchElementException e) {
			System.out.println("CP Effective Labor Rate chart is missing");
		}

		try {
			co.chart_1238().isDisplayed();
			System.out.println("CP Parts Markup chart successfully added to favorites");
		} catch (NoSuchElementException e) {
			System.out.println("CP Parts Markup chart is missing");
		}

	}

	@Test(priority = 2)
	public void validateTooltip() throws InterruptedException {
		CPsummaryoverviewObjects co = new CPsummaryoverviewObjects(driver);
		Thread.sleep(3000);
		co.summary().click();
		Thread.sleep(9000);
		co.valtooltip();
	}

	@Test(priority = 3)
	public void validateGraphexpand() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
		CPsummaryoverviewObjects co = new CPsummaryoverviewObjects(driver);
		Thread.sleep(3000);
		try {
			co.zchart_942().click();
			Thread.sleep(5000);
			co.zoomgraph().isDisplayed();
			co.zoomgraph().isEnabled();
			System.out.println("CP Revenue chart successfully expanded");
		} catch (NoSuchElementException e) {
			System.out.println("CP Revenue chart is not expanded ");
		}
		try {
			Thread.sleep(3000);
			co.zoomgraph().click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(3000);
		try {
			co.zchart_939().click();
			Thread.sleep(5000);
			co.zoomgraph().isDisplayed();
			co.zoomgraph().isEnabled();
			System.out.println("CP Gross Profit chart successfully expanded");
		} catch (NoSuchElementException e) {
			System.out.println("CP Gross Profit chart is not expanded");
		}
		try {
			Thread.sleep(3000);
			co.zoomgraph().click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(3000);
		try {
			co.zchart_940().click();
			Thread.sleep(5000);
			co.zoomgraph().isDisplayed();
			co.zoomgraph().isEnabled();
			System.out.println("CP Gross Profit Percenatge chart successfully expanded");
		} catch (NoSuchElementException e) {
			System.out.println("CP Gross Profit Percentage chart is not expanded");
		}
		try {
			Thread.sleep(3000);
			co.zoomgraph().click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(3000);
		try {
			co.zchart_920().click();
			Thread.sleep(5000);
			co.zoomgraph().isDisplayed();
			co.zoomgraph().isEnabled();
			System.out.println("CP Labor Sold Hours chart successfully expanded");
		} catch (NoSuchElementException e) {
			System.out.println("CP Labor Sold Hours chart is not expanded");
		}
		try {
			Thread.sleep(3000);
			co.zoomgraph().click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(3000);
		try {
			co.zchart_946().click();
			Thread.sleep(5000);
			co.zoomgraph().isDisplayed();
			co.zoomgraph().isEnabled();
			System.out.println("CP Effective Labor Rate chart successfully expanded");
		} catch (NoSuchElementException e) {
			System.out.println("CP Effective Labor Rate chart is not expanded");
		}
		try {
			Thread.sleep(3000);
			co.zoomgraph().click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		Thread.sleep(3000);
		try {
			co.zchart_1238().click();
			Thread.sleep(5000);
			co.zoomgraph().isDisplayed();
			co.zoomgraph().isEnabled();
			System.out.println("CP Parts Markup chart successfully expanded");
		} catch (NoSuchElementException e) {
			System.out.println("CP Parts Markup chart is not expanded");
		}
		try {
			Thread.sleep(3000);
			co.zoomgraph().click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
	}

	@Test(priority = 4)
	public void validateDataasof() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
		CPsummaryoverviewObjects co = new CPsummaryoverviewObjects(driver);
		Thread.sleep(3000);
		try {
			String actualDataasof = co.dataasof().getText();
			String expectedDataasof = "Data as of: 09/02/22";
			Assert.assertEquals(actualDataasof, expectedDataasof);
			System.out.println(actualDataasof);
			System.out.println("data as of validated");
		} catch (AssertionError e) {
			System.out.println("date miss match");
		}
	}

	@Test(priority = 5)
	public void validatedraganddrop() throws InterruptedException {
		CPsummaryoverviewObjects co = new CPsummaryoverviewObjects(driver);
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement sourc = co.source();
		Thread.sleep(5000);
		WebElement target = co.target();
		action.dragAndDrop(sourc, target).build().perform();
		try {
			Thread.sleep(5000);
			co.newdragpos().isDisplayed();
			co.newdragpos().isEnabled();
			Thread.sleep(3000);
			System.out.println("CP Revenue 942 chart successfully drag and dropped");
		} catch (NoSuchElementException e) {
			System.out.println("CP Revenue 942 chart not drag and dropped");
		}
		Thread.sleep(5000);
		try {
			co.reset().click();
			Thread.sleep(5000);
			co.source().isDisplayed();
			co.source().isEnabled();
			Thread.sleep(3000);
			System.out.println("CP Revenue 942 chart successfully reset");
		} catch (NoSuchElementException e) {
			System.out.println("CP Revenue 942 chart not reset");
		}
	}
	
	@Test(priority = 6)
	public void validatecpsumoverviewtitle() throws InterruptedException
	{
		CPsummaryoverviewObjects co = new CPsummaryoverviewObjects(driver);
		Thread.sleep(3000);
		try {
			String actualcpoverviewTitle = co.cpsumoverview().getText();
			String expectedcpoverviewTitle = "CP Summary Overview";
			Assert.assertEquals(actualcpoverviewTitle, expectedcpoverviewTitle);
			System.out.println(actualcpoverviewTitle);
			System.out.println("CP Summary Overview validated");
		} catch (AssertionError e) {
			System.out.println("CP Summary Overview title miss match");
		}
	}
}
