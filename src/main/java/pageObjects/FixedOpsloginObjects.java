package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FixedOpsloginObjects {
	public WebDriver driver;

	private By dashboard = By.cssSelector("[class='MuiButton-label']");
	private By username = By.cssSelector("#username");
	private By password = By.cssSelector("#password");
	private By submit = By.cssSelector("[value='Sign In']");
	private By clickdashboard = By.xpath("(//span[@class='MuiButton-label'])[2]");
	private By profile = By.xpath("(//div[@class='MuiGrid-root'])[1]");
	private By profiledata = By.cssSelector("#nested-list-subheader");
	private By parts = By.xpath("(//span[@class='MuiButton-label'])[22]");
	private By partsworkmix = By.xpath("(//span[@class='MuiButton-label'])[24]");

	private By partsalecomp = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[26]");
	private By partssaledetail = By.xpath("(//*[name()='svg'])[64]");
	private By partsdetcomp = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[14]");
	private By back = By.cssSelector("[class='MuiTypography-root MuiTypography-body1 MuiTypography-alignLeft']");

	private By partsalemain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[39]");
	private By partsaledetmain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[27]");

	private By partsrepair = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[52]");
	private By partsdetrepair = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[40]");

	private By compvalue = By.xpath("(//tr//td)[3]");
	private By mainvalue = By.xpath("(//tr//td)[17]");
	private By repairvalue = By.xpath("(//tr//td)[31]");
	private By partsaletotals = By.xpath("(//tr//td)[45]");

	private By compgp_percentage = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[65]");
	private By grossprofitdetail = By.xpath("(//*[name()='svg'])[70]");
	private By compgp_detailpercentage = By
			.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[14]");

	private By grossmain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[78]");
	private By grossmaindet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[27]");

	private By grossrep = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[91]");
	private By grossrepdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[40]");

	private By partscostcomp = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[104]");
	private By partscostdetail = By.xpath("(//*[name()='svg'])[76]");
	private By partscostcompdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[14]");

	private By partscostmain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[117]");
	private By partscostmaindet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[27]");

	private By partscostrepair = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[130]");
	private By partscostrepdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[40]");

	private By partsmarkcomp = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[143]");
	private By partsmarkcompdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[14]");
	private By partsmarkdetailpage = By.xpath("(//*[name()='svg'])[82]");

	private By partsmarkupmain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[156]");
	private By partsmarkupmaindet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[27]");

	private By partsmarkrepair = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[169]");
	private By partsmarkrepairdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[40]");

	private By partsjobcountcomp = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[182]");
	private By partsjobcountcompdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[14]");
	private By partsjobcountdetpage = By.xpath("(//*[name()='svg'])[88]");

	private By partsjobcountmain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[195]");
	private By partsjobcountmaindet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[27]");

	private By partsjobcountrepair = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[208]");
	private By partsjobcountrepairdet = By
			.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[40]");

	private By partsworkmixcomp = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[221]");
	private By partsworkmixcompdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[14]");
	private By partsworkmixdetailpage = By.xpath("(//*[name()='svg'])[94]");

	private By partsworkmixmain = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[234]");
	private By partsworkmixmaindet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[27]");

	private By partsworkmixrepair = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[247]");
	private By partsworkmixrepairdet = By.xpath("(//*[name()='svg']//*[local-name()='g']//*[local-name()='path'])[40]");

	public FixedOpsloginObjects(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getdashboard() {
		return driver.findElement(dashboard);
	}

	public WebElement username() {
		return driver.findElement(username);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

	public WebElement clkdash() {
		return driver.findElement(clickdashboard);
	}

	public WebElement profile() {
		return driver.findElement(profile);
	}

	public WebElement profiledata() {
		return driver.findElement(profiledata);
	}

	public WebElement parts() {
		return driver.findElement(parts);
	}

	public WebElement partsworkmix() {
		return driver.findElement(partsworkmix);
	}

	public WebElement partscomp() {
		return driver.findElement(partsalecomp);
	}

	public WebElement partsaledetail() {
		return driver.findElement(partssaledetail);
	}

	public WebElement partsdetcomp() {
		return driver.findElement(partsdetcomp);
	}

	public WebElement back() {
		return driver.findElement(back);
	}

	public WebElement partsalemain() {
		return driver.findElement(partsalemain);
	}

	public WebElement partsaledetmain() {
		return driver.findElement(partsaledetmain);
	}

	public WebElement partsrepair() {
		return driver.findElement(partsrepair);
	}

	public WebElement partsdetrepair() {
		return driver.findElement(partsdetrepair);
	}

	public WebElement compval() {
		return driver.findElement(compvalue);
	}

	public WebElement mainval() {
		return driver.findElement(mainvalue);
	}

	public WebElement repairval() {
		return driver.findElement(repairvalue);
	}

	public WebElement partsaletotals() {
		return driver.findElement(partsaletotals);
	}

	public WebElement compgp_percentage() {
		return driver.findElement(compgp_percentage);
	}

	public WebElement grossprofitdetail() {
		return driver.findElement(grossprofitdetail);
	}

	public WebElement compgp_detailpercentage() {
		return driver.findElement(compgp_detailpercentage);
	}

	public WebElement grossmain() {
		return driver.findElement(grossmain);
	}

	public WebElement grossmaindet() {
		return driver.findElement(grossmaindet);
	}

	public WebElement grossrep() {
		return driver.findElement(grossrep);
	}

	public WebElement grossrepdet() {
		return driver.findElement(grossrepdet);
	}

	public WebElement partscostcomp() {
		return driver.findElement(partscostcomp);
	}

	public WebElement partscostdetail() {
		return driver.findElement(partscostdetail);
	}

	public WebElement partscostcompdetail() {
		return driver.findElement(partscostcompdet);
	}

	public WebElement partscostmain() {
		return driver.findElement(partscostmain);
	}

	public WebElement partscostmaindet() {
		return driver.findElement(partscostmaindet);
	}

	public WebElement partscostrepair() {
		return driver.findElement(partscostrepair);
	}

	public WebElement partscostrepairdet() {
		return driver.findElement(partscostrepdet);
	}

	public WebElement partsmarkcomp() {
		return driver.findElement(partsmarkcomp);
	}

	public WebElement partsmarkcompdet() {
		return driver.findElement(partsmarkcompdet);
	}

	public WebElement partsmarkdetailpage() {
		return driver.findElement(partsmarkdetailpage);
	}

	public WebElement partsmarkupmain() {
		return driver.findElement(partsmarkupmain);
	}

	public WebElement partsmarkupmaindet() {
		return driver.findElement(partsmarkupmaindet);
	}

	public WebElement partsmarkrepair() {
		return driver.findElement(partsmarkrepair);
	}

	public WebElement partsmarkrepairdet() {
		return driver.findElement(partsmarkrepairdet);
	}

	public WebElement partsjobcountcomp() {
		return driver.findElement(partsjobcountcomp);
	}

	public WebElement partsjobcountcompdet() {
		return driver.findElement(partsjobcountcompdet);
	}

	public WebElement partsjobcountmain() {
		return driver.findElement(partsjobcountmain);
	}

	public WebElement partsjobcountmaindet() {
		return driver.findElement(partsjobcountmaindet);
	}

	public WebElement partsjobcountrepair() {
		return driver.findElement(partsjobcountrepair);
	}

	public WebElement partsjobcountrepairdet() {
		return driver.findElement(partsjobcountrepairdet);
	}

	public WebElement partsjobcountdetailpage() {
		return driver.findElement(partsjobcountdetpage);
	}

	public WebElement partsworkmixcomp() {
		return driver.findElement(partsworkmixcomp);
	}

	public WebElement partsworkmixcompdet() {
		return driver.findElement(partsworkmixcompdet);
	}

	public WebElement partsworkmixdetailpage() {
		return driver.findElement(partsworkmixdetailpage);
	}

	public WebElement partsworkmixmain() {
		return driver.findElement(partsworkmixmain);
	}

	public WebElement partsworkmixmaindet() {
		return driver.findElement(partsworkmixmaindet);
	}

	public WebElement partsworkmixrepair() {
		return driver.findElement(partsworkmixrepair);
	}

	public WebElement partsworkmixrepairdet() {
		return driver.findElement(partsworkmixrepairdet);
	}
}
