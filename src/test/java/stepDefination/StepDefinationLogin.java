package stepDefination;

import java.awt.Window;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginpageObjects;
import resources.Base;

public class StepDefinationLogin extends Base {
	public WebDriver driver;
	
	@Given("^admin is on fixedops landing page$")
	public void admin_is_on_fixedops_landing_page() throws IOException, InterruptedException 
	{
		
		driver=initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		LoginpageObjects lo=new LoginpageObjects(driver);
		lo.dashboard().click();
	}

	@When("^admin login in to application with admin username and admin password$")
	public void admin_login_in_to_application_with_admin_username_and_admin_password() throws InterruptedException {
		LoginpageObjects lo=new LoginpageObjects(driver);
		lo.username().sendKeys(props.getProperty("adminusername"));
		lo.password().sendKeys(props.getProperty("adminpassword"));
		lo.submit().click();
		Thread.sleep(9000);
		lo.clickdashboard().click();
	}

	@Then("^home page is prepopulated$")
	public void home_page_is_prepopulated() {
		System.out.println("validate homepage");
	}

	@And("^all the graphs are displayed$")
	public void all_the_graphs_are_displayed() 
	{
		System.out.println("validate graphs");
	}

	 @When("^user login in to application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	    public void user_login_in_to_application_with_username_something_and_password_something(String username, String password) throws InterruptedException 
	 {
		 LoginpageObjects lo=new LoginpageObjects(driver);
			lo.username().sendKeys(username);
			lo.password().sendKeys(password);
			lo.submit().click();
			Thread.sleep(9000);
			lo.clickdashboard().click();
	   
	 }
}




