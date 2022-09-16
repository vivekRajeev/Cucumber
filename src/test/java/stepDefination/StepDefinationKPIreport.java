package stepDefination;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.KPIreportObjects;
import resources.Base;

public class StepDefinationKPIreport extends Base 
{
	public WebDriver driver;
	public String d;
	public KPIreportObjects ko = new KPIreportObjects(driver);
	@Given("I landed on fixedOps login page")
	public void I_landed_on_fixedOps_login_page() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		KPIreportObjects ko = new KPIreportObjects(driver);
		Thread.sleep(3000);
		ko.getdashboard().click();
	}
	
	@Given("^Login to application with username (.+) and password (.+)$")
	public void login_to_application(String username,String password) throws InterruptedException
	{
		KPIreportObjects ko = new KPIreportObjects(driver);
		ko.username().sendKeys(username);
		ko.password().sendKeys(password);
		ko.submit().click();
		Thread.sleep(9000);
		ko.clkdash().click();
		Thread.sleep(9000);
		ko.clickcustomer().click();
		ko.kpi().click();
		Thread.sleep(3000);
	}
	
	/*@And("go to KPI report page")
	public void go_to_KPI_report_page() throws InterruptedException
	{
		//KPIreportObjects ko = new KPIreportObjects(driver);
		ko.clickcustomer().click();
		ko.kpi().click();
		Thread.sleep(3000);
	}*/
	@When("^Select any duration from the dropdown (.+)$")
	public void Select_any_duration_from_the_dropdown(String duration) throws InterruptedException
	{
		KPIreportObjects ko = new KPIreportObjects(driver);
		ko.duraclk().click();
		Thread.sleep(3000);
		List<WebElement> list = ko.durations();
		d = duration;
		Thread.sleep(5000);
		for (int i = 0; i < list.size(); i++) {
			try {
				String l = list.get(i).getText().replace("\n", " ");
				 //System.out.println(l);

				if (l.contains(d)) {
					list.get(i).click();
				}
			} catch (StaleElementReferenceException e) {

			}
		}
	}
	
	@Then("verify that selected duration is present")
	public void verify_that_selected_duration_is_present() throws InterruptedException
	{
		KPIreportObjects ko = new KPIreportObjects(driver);
		Thread.sleep(5000);
		String[] k = ko.seldate().getText().split(":");
		System.out.println(k[1].trim());
		if (d.equals(k[1].trim())) {
			System.out.println("both durations are same");
		}
		Thread.sleep(5000);
		driver.close();
	}
}
