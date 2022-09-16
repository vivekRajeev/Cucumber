package fixtest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.KPIreportObjects;
import resources.Base;

public class KPIreport extends Base {

	public WebDriver driver;

	@Test
	public void validateDuration() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		KPIreportObjects ko = new KPIreportObjects(driver);
		Thread.sleep(3000);
		ko.getdashboard().click();
		ko.username().sendKeys(props.getProperty("adminusername"));
		ko.password().sendKeys(props.getProperty("adminpassword"));
		ko.submit().click();
		Thread.sleep(9000);
		ko.clkdash().click();
		Thread.sleep(9000);
		ko.clickcustomer().click();
		ko.kpi().click();
		Thread.sleep(3000);
		ko.duraclk().click();
		Thread.sleep(3000);
		List<WebElement> list = ko.durations();
		// System.out.println(list.size());

		String d = "Yesterday Sep 13 ' 22";
		Thread.sleep(5000);
		for (int i = 0; i < list.size(); i++) {
			try {
				String l = list.get(i).getText().replace("\n", " ");
				// System.out.println(l);

				if (l.contains(d)) {
					list.get(i).click();
				}
			} catch (StaleElementReferenceException e) {

			}
		}
		Thread.sleep(5000);
		String[] k = ko.seldate().getText().split(":");
		System.out.println(k[1].trim());
		if (d.equals(k[1].trim())) {
			System.out.println("both durations are same");
		}
	}

}
