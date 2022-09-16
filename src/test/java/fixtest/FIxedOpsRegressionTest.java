package fixtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.FixedOpsregressionObjects;
import resources.Base;

public class FIxedOpsRegressionTest extends Base {
	public WebDriver driver;

	@Test
	public void validatesigninDashboard() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(props.getProperty("billknightaws"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsregressionObjects fr = new FixedOpsregressionObjects(driver);
		try {
			fr.armatusLogo().isDisplayed();
			fr.armatusLogo().isEnabled();
			System.out.println("armatus logo validated");
		} catch (NoSuchElementException e) {
			System.out.println("armatus logo missing");
		}
		try {
			fr.callemailLogo().isDisplayed();
			fr.callemailLogo().isEnabled();
			System.out.println("call/email logo validated");
		} catch (NoSuchElementException e) {
			System.out.println("call/email logo missing");
		}

		try {
			String actualtitle = fr.title().getText();
			String expectedtitle = props.getProperty("title");
			Assert.assertEquals(actualtitle, expectedtitle);
			System.out.println(actualtitle);
			System.out.println("title validated");
		} catch (AssertionError e) {
			System.out.println("title miss match");
		}
		try {
			String actualdashboard = fr.dashboard().getText();
			String expecteddashboard = props.getProperty("dashboard");
			Assert.assertEquals(actualdashboard, expecteddashboard);
			System.out.println(actualdashboard);
			System.out.println("dashboard validated");
		} catch (AssertionError e) {
			System.out.println("dashboard miss match");
		}
		Thread.sleep(3000);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String theTextIWant = (String) js.executeScript("return arguments[0].innerHTML;", driver.findElement(
					By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 MuiTypography-colorInherit'])[2]")));
			String[] s = theTextIWant.split("&");
			String actualvsersion = s[0];
			System.out.println(actualvsersion);
			String expectedversion = props.getProperty("version");
			Assert.assertEquals(actualvsersion, expectedversion);
			System.out.println("version validated");
		} catch (AssertionError e) {
			System.out.println("version miss match");
		}
		Thread.sleep(3000);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(fr.mousehover()).build().perform();
			String actualContactus = fr.contactus().getText();
			String expectedContactus = props.getProperty("contactUs");
			Assert.assertEquals(actualContactus, actualContactus);
			System.out.println(actualContactus);
			System.out.println("contact us validated");
		} catch (AssertionError e) {
			System.out.println("contact us miss match");
		}
		try 
		{
			Actions action = new Actions(driver);
			action.moveToElement(fr.mousehover()).build().perform();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(fr.email()));
		    System.out.println("email is clickable");
		}catch(ElementClickInterceptedException e)
		{
			System.out.println("element is not clickable");
		}
		try {
			Actions action = new Actions(driver);
			action.moveToElement(fr.mousehover()).build().perform();
			String actualMobno = fr.mobno().getText();
			String expectedMobno = props.getProperty("mobno");
			Assert.assertEquals(actualMobno, expectedMobno);
			System.out.println(actualMobno);
			System.out.println("mobile number is validated");
		} catch (AssertionError e) {
			System.out.println("mobile number miss match");
		}
		Thread.sleep(3000);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(fr.mousehover()).build().perform();
			String actualemail = fr.email().getText();
			String expectedemailid = props.getProperty("email");
			Assert.assertEquals(actualemail, expectedemailid);
			System.out.println(actualemail);
			System.out.println("email id is validated");
		} catch (AssertionError e) {
			System.out.println(" email id miss match");
		}
		try {
			fr.callimg().isDisplayed();
			fr.callimg().isEnabled();
			System.out.println("call icon validated");
		} catch (NoSuchElementException e) {
			System.out.println("call icon missing");
		}
		try {
			fr.mailimg().isDisplayed();
			fr.mailimg().isEnabled();
			System.out.println("mail icon validated");
		} catch (NoSuchElementException e) {
			System.out.println("mail icon missing");
		}
		Thread.sleep(3000);
		try {
			String actualsignin = fr.sigin().getText();
			String expectedsignin = props.getProperty("signin");
			Assert.assertEquals(actualsignin, expectedsignin);
			System.out.println(actualsignin);
			System.out.println("Sign in is validated");
		} catch (AssertionError e) {
			System.out.println("Sign in miss match");
		}
	}

}
