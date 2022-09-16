package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties props;

	public WebDriver initializeDriver() throws IOException {
		props = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		props.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: props.getProperty("browser");

		// props.getProperty("browser");
		if (browserName.equals("chrome")) {
			// run in chrome headless mode
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			// ChromeOptions options = new ChromeOptions();
			// options.addArguments("headless");
			// driver = new ChromeDriver(options);
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			// invoking internetExplorer
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	// fluent wait
	/*
	 * Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	 * .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(5))
	 * .ignoring(NoSuchElementException.class);
	 */

	// explicit wait
	// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".classlocator")));

	// implicit wait
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
