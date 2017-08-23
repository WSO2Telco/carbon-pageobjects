package com.wso2telco.test.carbon.pageobjects.carbon.steps;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.wso2telco.test.framework.tests.TestBase;

abstract  public class BasicTestObject extends TestBase {
	
	//public static Properties CONFIG;
	
	public static boolean isInitialized;
	
	public static boolean isBrowserOpened=false;
	
	final static Logger logger = Logger.getLogger(BasicTestObject.class);
	
	private String headerName;
	
	private String headerValue;
	
	public static String environment;
	
	private String zipFileDir;
	
	public Long sleepTime = Long.parseLong(config.getValue("sleepTime"));
	
	public static String projectPath = System.getProperty("user.dir");
	
	public void initialize() throws Exception {
		if (!isInitialized) {
			// Initialize Logs
			logInstruction("Initializing Logs");
			String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.xml";
			DOMConfigurator.configure(log4jConfigFile);
			logInstruction("Initializing Logs Completed");
			// Initialize config
		/*	logInstruction("Initializing Config");
			CONFIG = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
			CONFIG.load(ip);
			*/
			if (System.getProperty("env") != null) {
				setEnvironment(System.getProperty("env"));
			} else {
				setEnvironment(config.getValue("Environment"));
			}
			setZipFileDir(System.getProperty("zipfiledir"));
			logInstruction("Initializing Config Completed");
			isInitialized = true;
		}
	}
	
	public void openBrowser() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		try {
			if (config.getValue("browser").equals("FIREFOX")) {
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/xls,text/csv,application/vnd.ms-excel");
				capabilities.setBrowserName("FIREFOX");
				capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				launchBrowser(capabilities);
			} else if (config.getValue("browser").equals("INTERNETEXPLORER")){
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, false);
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability("ie.ensureCleanSession", true);
				capabilities.setCapability("requireWindowFocus",true);
				capabilities.setCapability("IntroduceInstabilityByIgnoringProtectedModeSettings",true);
				launchBrowser(capabilities);
			}
			else if (config.getValue("browser").equals("CHROME")){
				capabilities = DesiredCapabilities.chrome();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("test-type");
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				launchBrowser(capabilities);
			}
			isBrowserOpened = true;
			String waitTime = config.getValue("default_implicitWait");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime), TimeUnit.SECONDS);
		} catch (Exception e) {
			logInstruction("Exception While Initializing browser 'openBrowser()'" + e.getMessage());
			throw new Exception("Exception While Initializing browser 'openBrowser()'" + e.getMessage());

		}
	}
	
	public void closeAllBrowsers() {
		driver.quit();
		driver = null;
		isInitialized = false;
		isBrowserOpened = false;
		System.out.println("After Test");
	}
	
	public void capturescreenshot(String filename) throws IOException {
		DateFormat df = new SimpleDateFormat("dd-MM-yy-HH-mm-ss");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils
				.copyFile(
						scrFile,
						new File(System.getProperty("user.dir")
								+ "\\screenshots\\" + filename + "-"
								+ df.format(calobj.getTime()) + ".jpg"));

	}
			
	public void logInstruction(String logMessage) {
		if (logger.isDebugEnabled()) {
			logger.debug(logMessage);
		}
	}
	
	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	public String getHeaderValue() {
		return headerValue;
	}

	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}
	

	@SuppressWarnings("static-access")
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getZipFileDir() {
		return zipFileDir;
	}
	
	public boolean isFileExists(String filepath){
		boolean flag = false;
		if (filepath == null){
			filepath = " ";
		}
		File file = new File(filepath);
		if (file.exists() && !file.isDirectory()) {
		    flag = true;
		}
		return flag;
	}

	public void setZipFileDir(String zipFileDir) {
		this.zipFileDir = zipFileDir;
	}

}
