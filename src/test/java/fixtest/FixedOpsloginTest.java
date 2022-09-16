package fixtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FixedOpsloginObjects;
import resources.Base;


public class FixedOpsloginTest extends Base
{
	public WebDriver driver;
	@Test(dataProvider = "getlogindata")
	public void login(String username, String password) throws InterruptedException, IOException {
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		fl.getdashboard().click();
		fl.username().sendKeys(username);
		fl.password().sendKeys(password);
		fl.submit().click();
		Thread.sleep(9000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.profile().click();
		Thread.sleep(3000);
		System.out.println(fl.profiledata().getText());
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}

	}

	@DataProvider
	public Object[][] getlogindata() throws IOException {
		props = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\windows\\eclipse-workspace\\SeleniumWithJava\\MyownFramework\\src\\main\\java\\resources\\config.properties");
		props.load(fis);
		Object[][] data = new Object[3][2];

		data[0][0] = props.getProperty("adminusername");
		data[0][1] = props.getProperty("adminpassword");

		data[1][0] = props.getProperty("clientusername");
		data[1][1] = props.getProperty("clientpassword");

		data[2][0] = props.getProperty("userusername");
		data[2][1] = props.getProperty("userpassword");

		return data;

	}

	@Test
	public void partsale() throws IOException, InterruptedException {
		
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		cal.add((GregorianCalendar.MONTH),-1);
		String s[]=cal.getTime().toString().split(" ");
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		Thread.sleep(3000);
		fl.getdashboard().click();
		fl.username().sendKeys(props.getProperty("adminusername"));
		fl.password().sendKeys(props.getProperty("adminpassword"));
		fl.submit().click();
		Thread.sleep(5000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.parts().click();
		Thread.sleep(3000);
		fl.partsworkmix().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		// competitive
		String comp = fl.partscomp().getAttribute("val");
		System.out.println(comp);
		Thread.sleep(3000);
		fl.partsaledetail().click();
		Thread.sleep(5000);
		String compdetail = fl.partsdetcomp().getAttribute("val");
		System.out.println(compdetail);
		if (comp.equals(compdetail)) {
			System.out.println("same comptitive values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		// maintenance
		String maintenance = fl.partsalemain().getAttribute("val");
		System.out.println(maintenance);
		Thread.sleep(3000);
		fl.partsaledetail().click();
		Thread.sleep(5000);
		String maindetail = fl.partsaledetmain().getAttribute("val");
		System.out.println(maindetail);
		if (maintenance.equals(maindetail)) {
			System.out.println("same maintenance values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		// Repair
		String repair = fl.partsrepair().getAttribute("val");
		System.out.println(repair);
		Thread.sleep(3000);
		fl.partsaledetail().click();
		Thread.sleep(5000);
		String repdetail = fl.partsdetrepair().getAttribute("val");
		System.out.println(repdetail);
		if (repair.equals(repdetail)) {
			System.out.println("same repair values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(5000);
		fl.partsdetrepair().click();
		Thread.sleep(5000);
		String compvalue = fl.compval().getText();
		compvalue = compvalue.startsWith("$") ? compvalue.substring(1) : compvalue;
		compvalue = compvalue.replaceAll(",", "");
		int compval = Integer.parseInt(compvalue);
		Thread.sleep(3000);
		String mainvalue = fl.mainval().getText();
		mainvalue = mainvalue.startsWith("$") ? mainvalue.substring(1) : mainvalue;
		mainvalue = mainvalue.replaceAll(",", "");
		int mainval = Integer.parseInt(mainvalue);
		Thread.sleep(3000);
		String repairvalue = fl.repairval().getText();
		repairvalue = repairvalue.startsWith("$") ? repairvalue.substring(1) : repairvalue;
		repairvalue = repairvalue.replaceAll(",", "");
		int repairval = Integer.parseInt(repairvalue);
		int totalvalue = compval + mainval + repairval;
		System.out.println(totalvalue);
		Thread.sleep(3000);
		String partsaletotals = fl.partsaletotals().getText();
		partsaletotals = partsaletotals.startsWith("$") ? partsaletotals.substring(1) : partsaletotals;
		partsaletotals = partsaletotals.replaceAll(",", "");
		int parts_sale_totals = Integer.parseInt(partsaletotals);
		System.out.println(parts_sale_totals);
		Thread.sleep(3000);
		if (totalvalue == parts_sale_totals) {
			System.out.println("parts sale total matches"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}
	}

	@Test
	public void grossprofit_percentage() throws InterruptedException, IOException {
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		cal.add((GregorianCalendar.MONTH),-1);
		String s[]=cal.getTime().toString().split(" ");
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		fl.getdashboard().click();
		fl.username().sendKeys(props.getProperty("adminusername"));
		fl.password().sendKeys(props.getProperty("adminpassword"));
		fl.submit().click();
		Thread.sleep(9000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.parts().click();
		Thread.sleep(3000);
		fl.partsworkmix().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		String compgp_percentage = fl.compgp_percentage().getAttribute("val");
		System.out.println(compgp_percentage);
		Thread.sleep(5000);
		fl.grossprofitdetail().click();
		Thread.sleep(5000);
		String comgp_detpercentage = fl.compgp_detailpercentage().getAttribute("val");
		System.out.println(comgp_detpercentage);
		if (compgp_percentage.equals(comgp_detpercentage)) {
			System.out.println("same competitive gross profit % in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		String grossmain = fl.grossmain().getAttribute("val");
		System.out.println(grossmain);
		Thread.sleep(5000);
		fl.grossprofitdetail().click();
		Thread.sleep(5000);
		String grossmaindet = fl.grossmaindet().getAttribute("val");
		System.out.println(grossmaindet);
		if (grossmain.equals(grossmaindet)) {
			System.out.println("same maintenance gross profit % in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(5000);
		String grossrep = fl.grossrep().getAttribute("val");
		System.out.println(grossrep);
		Thread.sleep(5000);
		fl.grossprofitdetail().click();
		Thread.sleep(5000);
		String grossrepdet = fl.grossrepdet().getAttribute("val");
		System.out.println(grossrepdet);
		if (grossrep.equals(grossrepdet)) {
			System.out.println("same repair gross profit % in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}
	}

	@Test
	public void partscost() throws InterruptedException, IOException {
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		cal.add((GregorianCalendar.MONTH),-1);
		String s[]=cal.getTime().toString().split(" ");
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		fl.getdashboard().click();
		fl.username().sendKeys(props.getProperty("adminusername"));
		fl.password().sendKeys(props.getProperty("adminpassword"));
		fl.submit().click();
		Thread.sleep(9000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.parts().click();
		Thread.sleep(3000);
		fl.partsworkmix().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String partscostcomp = fl.partscostcomp().getAttribute("val");
		System.out.println(partscostcomp);
		Thread.sleep(5000);
		fl.partscostdetail().click();
		Thread.sleep(5000);
		String partscostcompdet = fl.partscostcompdetail().getAttribute("val");
		System.out.println(partscostcompdet);
		if (partscostcomp.equals(partscostcompdet)) {
			System.out.println("same parts cost competitive values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String partscostmain = fl.partscostmain().getAttribute("val");
		System.out.println(partscostmain);
		Thread.sleep(5000);
		fl.partscostdetail().click();
		Thread.sleep(5000);
		String partscostmaindet = fl.partscostmaindet().getAttribute("val");
		System.out.println(partscostmaindet);
		if (partscostmain.equals(partscostmaindet)) {
			System.out.println("same parts cost maintenance values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String partscostrep = fl.partscostrepair().getAttribute("val");
		System.out.println(partscostrep);
		Thread.sleep(5000);
		fl.partscostdetail().click();
		Thread.sleep(5000);
		String partscostrepdet = fl.partscostrepairdet().getAttribute("val");
		System.out.println(partscostrepdet);
		if (partscostrep.equals(partscostrepdet)) {
			System.out.println("same parts cost repair values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		fl.partscostmain().click();
		Thread.sleep(5000);
		String compvalue = fl.compval().getText();
		compvalue = compvalue.startsWith("$") ? compvalue.substring(1) : compvalue;
		compvalue = compvalue.replaceAll(",", "");
		int compval = Integer.parseInt(compvalue);
		Thread.sleep(3000);
		String mainvalue = fl.mainval().getText();
		mainvalue = mainvalue.startsWith("$") ? mainvalue.substring(1) : mainvalue;
		mainvalue = mainvalue.replaceAll(",", "");
		int mainval = Integer.parseInt(mainvalue);
		Thread.sleep(3000);
		String repairvalue = fl.repairval().getText();
		repairvalue = repairvalue.startsWith("$") ? repairvalue.substring(1) : repairvalue;
		repairvalue = repairvalue.replaceAll(",", "");
		int repairval = Integer.parseInt(repairvalue);
		int totalvalue = compval + mainval + repairval;
		System.out.println(totalvalue);
		Thread.sleep(3000);
		String partcosttotals = fl.partsaletotals().getText();
		partcosttotals = partcosttotals.startsWith("$") ? partcosttotals.substring(1) : partcosttotals;
		partcosttotals = partcosttotals.replaceAll(",", "");
		int parts_cost_totals = Integer.parseInt(partcosttotals);
		System.out.println(parts_cost_totals);
		Thread.sleep(3000);
		if (totalvalue == parts_cost_totals) {
			System.out.println("parts cost total matches"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}
	}

	@Test
	public void partsmarkup() throws IOException, InterruptedException {
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		cal.add((GregorianCalendar.MONTH),-1);
		String s[]=cal.getTime().toString().split(" ");
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		fl.getdashboard().click();
		fl.username().sendKeys(props.getProperty("adminusername"));
		fl.password().sendKeys(props.getProperty("adminpassword"));
		fl.submit().click();
		Thread.sleep(9000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.parts().click();
		Thread.sleep(3000);
		fl.partsworkmix().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String partsmarkcomp = fl.partsmarkcomp().getAttribute("val");
		System.out.println(partsmarkcomp);
		Thread.sleep(5000);
		fl.partsmarkdetailpage().click();
		Thread.sleep(5000);
		String partsmarkcompdet = fl.partsmarkcompdet().getAttribute("val");
		System.out.println(partsmarkcompdet);
		if (partsmarkcomp.equals(partsmarkcompdet)) {
			System.out.println("same parts mark up competitive values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String partsmarkmain = fl.partsmarkupmain().getAttribute("val");
		System.out.println(partsmarkmain);
		Thread.sleep(5000);
		fl.partsmarkdetailpage().click();
		Thread.sleep(5000);
		String partsmarkmaindet = fl.partsmarkupmaindet().getAttribute("val");
		System.out.println(partsmarkmaindet);
		if (partsmarkmain.equals(partsmarkmaindet)) {
			System.out.println("same parts mark up maintenance values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		String partsmarkrepair = fl.partsmarkrepair().getAttribute("val");
		System.out.println(partsmarkrepair);
		Thread.sleep(5000);
		fl.partsmarkdetailpage().click();
		Thread.sleep(5000);
		String partsmarkrepairdet = fl.partsmarkrepairdet().getAttribute("val");
		System.out.println(partsmarkrepairdet);
		if (partsmarkrepair.equals(partsmarkrepairdet)) {
			System.out.println("same parts mark up repair values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}
	}

	@Test
	public void jobcount() throws InterruptedException, IOException {
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		cal.add((GregorianCalendar.MONTH),-1);
		String s[]=cal.getTime().toString().split(" ");
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		fl.getdashboard().click();
		fl.username().sendKeys(props.getProperty("adminusername"));
		fl.password().sendKeys(props.getProperty("adminpassword"));
		fl.submit().click();
		Thread.sleep(9000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.parts().click();
		Thread.sleep(3000);
		fl.partsworkmix().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(5000);
		String partsjobcountcomp = fl.partsjobcountcomp().getAttribute("val");
		System.out.println(partsjobcountcomp);
		Thread.sleep(5000);
		fl.partsjobcountdetailpage().click();
		Thread.sleep(5000);
		String partsjobcountdetcomp = fl.partsjobcountcompdet().getAttribute("val");
		System.out.println(partsjobcountdetcomp);
		if (partsjobcountcomp.equals(partsjobcountdetcomp)) {
			System.out.println("same parts job count competitive values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(5000);
		String partsjobcountmain = fl.partsjobcountmain().getAttribute("val");
		System.out.println(partsjobcountmain);
		Thread.sleep(5000);
		fl.partsjobcountdetailpage().click();
		Thread.sleep(5000);
		String partsjobcountmaindet = fl.partsjobcountmaindet().getAttribute("val");
		System.out.println(partsjobcountmaindet);
		if (partsjobcountmain.equals(partsjobcountmaindet)) {
			System.out.println("same parts job count maintenance values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(5000);
		String partsjobcountrepair = fl.partsjobcountrepair().getAttribute("val");
		System.out.println(partsjobcountrepair);
		Thread.sleep(5000);
		fl.partsjobcountdetailpage().click();
		Thread.sleep(5000);
		String partsjobcountreapirdet = fl.partsjobcountrepairdet().getAttribute("val");
		System.out.println(partsjobcountreapirdet);
		if (partsjobcountmain.equals(partsjobcountmaindet)) {
			System.out.println("same parts job count repair values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(5000);
		fl.partsjobcountrepairdet().click();
		Thread.sleep(5000);
		String compvalue = fl.compval().getText();
		int compval = Integer.parseInt(compvalue);
		Thread.sleep(3000);
		String mainvalue = fl.mainval().getText();
		int mainval = Integer.parseInt(mainvalue);
		Thread.sleep(3000);
		String repairvalue = fl.repairval().getText();
		int repairval = Integer.parseInt(repairvalue);
		int totalvalue = compval + mainval + repairval;
		System.out.println(totalvalue);
		Thread.sleep(3000);
		String partjobcounttotals = fl.partsaletotals().getText();
		int parts_jobcount_totals = Integer.parseInt(partjobcounttotals);
		System.out.println(parts_jobcount_totals);
		Thread.sleep(3000);
		if (totalvalue == parts_jobcount_totals) {
			System.out.println("parts job count total matches"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}
	}

	@Test
	public void workmix_percentage() throws InterruptedException, IOException {
		GregorianCalendar cal=(GregorianCalendar) GregorianCalendar.getInstance();
		cal.add((GregorianCalendar.MONTH),-1);
		String s[]=cal.getTime().toString().split(" ");
		driver = initializeDriver();
		driver.get(props.getProperty("fixedurl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		FixedOpsloginObjects fl = new FixedOpsloginObjects(driver);
		fl.getdashboard().click();
		fl.username().sendKeys(props.getProperty("adminusername"));
		fl.password().sendKeys(props.getProperty("adminpassword"));
		fl.submit().click();
		Thread.sleep(9000);
		fl.clkdash().click();
		Thread.sleep(5000);
		fl.parts().click();
		Thread.sleep(3000);
		fl.partsworkmix().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(5000);
		String partsworkmixcomp = fl.partsworkmixcomp().getAttribute("val");
		System.out.println(partsworkmixcomp);
		Thread.sleep(5000);
		fl.partsworkmixdetailpage().click();
		Thread.sleep(5000);
		String partsworkmixcomdet = fl.partsworkmixcompdet().getAttribute("val");
		System.out.println(partsworkmixcomdet);
		if (partsworkmixcomp.equals(partsworkmixcomdet)) {
			System.out.println("same parts workmix competitive values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(5000);
		String partsworkmixmain = fl.partsworkmixmain().getAttribute("val");
		System.out.println(partsworkmixmain);
		Thread.sleep(5000);
		fl.partsworkmixdetailpage().click();
		Thread.sleep(5000);
		String partsworkmixmaindet = fl.partsworkmixmaindet().getAttribute("val");
		System.out.println(partsworkmixmaindet);
		if (partsworkmixmain.equals(partsworkmixmaindet)) {
			System.out.println("same parts workmix maintenance values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		fl.back().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(5000);
		String partsworkmixrepair = fl.partsworkmixrepair().getAttribute("val");
		System.out.println(partsworkmixrepair);
		Thread.sleep(5000);
		fl.partsworkmixdetailpage().click();
		Thread.sleep(5000);
		String partsworkmixrepdet = fl.partsworkmixrepairdet().getAttribute("val");
		System.out.println(partsworkmixrepdet);
		if (partsworkmixmain.equals(partsworkmixmaindet)) {
			System.out.println("same parts workmix repair values in both graphs"+" "+s[1]+" "+"month");
		}
		Thread.sleep(3000);
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("socketexception");
		}
	}

}
