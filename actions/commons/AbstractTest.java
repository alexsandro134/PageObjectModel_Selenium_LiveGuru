package commons;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	WebDriver driver;

	protected final Log log;

	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver openMultiBrowser(String browser, String browserVersion, String url) {
		if (browser.equals("chrome")) {
			ChromeDriverManager.getInstance().version(browserVersion).setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			// Firefox version 47.0.2 + Selenium 2.53.1 -> Dont need gecko
			// driver
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome_headless")) {
			ChromeDriverManager.getInstance().version(browserVersion).setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browser.equals("ie11")) {
			InternetExplorerDriverManager.getInstance().version(browserVersion).setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Can't init browser!");
		}
		log.info("Before Class: Open Url of Login Page");
		driver.get(url);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String generateEmail() {
		StringBuilder randomEmail = new StringBuilder();
		randomEmail.append(RandomStringUtils.random(10, "abcdefghijklmnopqrstuvxyz1234567890")).append("@gmail.com");
		return randomEmail.toString();
	}

	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("----------------- PASSED -----------------");
		} catch (Throwable e) {
			log.info("----------------- FAILED -----------------");
			pass = false;
			// Attach exception to ReportNG
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("----------------- PASSED -----------------");
		} catch (Throwable e) {
			log.info("----------------- FAILED -----------------");
			pass = false;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(actual + " is equals " + expected);
			log.info("----------------- PASSED -----------------");
		} catch (Throwable e) {
			log.info(actual + " is not equals " + expected);
			log.info("----------------- FAILED -----------------");
			pass = false;
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowser(WebDriver driver) {
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			driver.quit();
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver.exe*\"";
				}
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
