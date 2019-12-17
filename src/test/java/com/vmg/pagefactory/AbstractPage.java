package com.vmg.pagefactory;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vmg.utilities.Configurator;

public class AbstractPage  {
	
	WebDriver driver ;
	public Configurator configProps = new Configurator("config.properties");
	public Logger log = Logger.getLogger(AbstractPage.class);
	public Long maxTimeOut = Long.parseLong(String.valueOf(configProps.getProperty("GLOBAL_MAX_TIMEOUT_IN_SECONDS")));
	public AbstractPage(WebDriver d) {
		this.driver = d;
		System.setProperty("log4j.configurationFile",configProps.getProperty("log4JPath"));
	}
	// Gets the page title of the current page.
	public String getPageTitle(WebDriver driver ) {
		return driver.getTitle();
	}

	// Here the expected page title and the current page title are compared.
	public boolean verifyBasePageTitle(String expectedPageTitle, WebDriver driver) {
		return getPageTitle(driver).contains(expectedPageTitle);

	}

	

	public void captureScreenshot() {
		try {
			log.info("Screenshot Functionality invoked");
			String capturedScreenshot = configProps.getProperty("pathOfScreeshot")+"\\"
					+ configProps.getProperty("screenshotNaming") + getTimeStamp() + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(capturedScreenshot));

			log.info("Screenshot is captured");
			log.info("Path Of Screenshot :- " + capturedScreenshot);
			assertTrue(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isWebElementPresent(By locator) {
		boolean flag = false;
		try {
			flag = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			log.error("Element not found : " + e.getMessage());
		}
		return flag;
	}
	
	public boolean isWebElementSelected(By locator) {
		boolean flag = false;
		try {
			flag = driver.findElement(locator).isSelected();
		} catch (Exception e) {
			log.error("Element not found : " + e.getMessage());
		}
		return flag;
	}
	
	public boolean isWebElementPresent(WebElement we) {
		boolean flag = false;
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, maxTimeOut);
			if(wait1.until(ExpectedConditions.visibilityOf(we))!=null) {
				flag = true;
			}
			//flag = we.isDisplayed();
			log.info(we+" is Element Present "+flag);
		} catch (Exception e) {
			log.error(we+" is Element Present "+flag);
		}
		return flag;
	}
	
	public boolean isWebElementAbscent(WebElement we) {
		boolean flag = false;
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 1);
			if(wait1.until(ExpectedConditions.invisibilityOf(we))) {
				flag = true;
			}
			//flag = we.isDisplayed();
			log.info(we+" is Element Abscent "+flag);
		} catch (Exception e) {
			flag = true;
			log.error(we+" is Element Abscent "+flag);
		}
		return flag;
	}
	public void wait(int sec) {
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, sec);
			if(wait1.until(ExpectedConditions.urlToBe(""))) {
				log.info(" is waiting.. ");
			}
			
		} catch (Exception e) {
		}
	}
	public boolean isWebElementClickable(WebElement we) {
		boolean flag = false;
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, maxTimeOut);
			if(wait1.until(ExpectedConditions.elementToBeClickable(we))!=null) {
				flag = true;
			}
			//flag = we.isEnabled();
			log.info("is Element Clicable "+flag);
		} catch (Exception e) {
			log.error("is Element Clicable "+flag);
		}
		return flag;
	}
	
	public boolean isTextPresent(String text) {
		boolean flag = false;
		try {
			WebDriverWait wait1 = new WebDriverWait(driver,maxTimeOut);
			//flag = driver.findElement(By.xpath("//body")).getText().contains(text);
			List<WebElement> list = wait1.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),\"" + text + "\")]")));
			flag = list.size() > 0;
			log.info("Text found : " + text);
		} catch (Exception e) {
			log.error("Text not found : " + e.getMessage());
		}
		return flag;
	}

	
	public void type(By locator, String testData) {
		try {
			WebElement ele = driver.findElement(locator) /*waitForElementClicable(locator, maxTimeOut)*/;
			ele.clear();
			ele.sendKeys(testData);
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + locator);
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
			captureScreenshot();
			e.printStackTrace();
		}

	}
	
	public void type(WebElement we, String testData) {
		try {
			we.clear();
			we.sendKeys(testData);
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + we);
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
			captureScreenshot();
			e.printStackTrace();
		}

	}
	public void pressTab(WebElement we) {
		we.sendKeys(Keys.TAB);
	}
	public void updateText(WebElement we, String testData) {
		try {
			we.sendKeys(testData);
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + we);
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
			e.printStackTrace();
			captureScreenshot();
		}

	}

	public WebElement waitForElementClickable(By locator, Long waitTime) {
		WebElement ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
			log.info(locator+" is clickable now");
		} catch (Exception e) {
			log.error("Failed to execute step : " + e);
			e.printStackTrace();
			captureScreenshot();
		}
		return ele;
	}
	
	public WebElement waitForElementClickable(WebElement we1, Long waitTime) {
		WebElement we2 = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			we2 = wait.until(ExpectedConditions.elementToBeClickable(we1));
		} catch (Exception e) {
			log.error("Failed to execute step : " + e);
			e.printStackTrace();
			captureScreenshot();
			
		}
		return we2;
	}

	public WebElement waitForElementPresent(WebElement ele, int waitTime) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			ele = wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			log.error("Failed to execute step : " + e);
			e.printStackTrace();
			captureScreenshot();
		}
		return ele;
	}

	public void click(By locator) {
		try {
			waitForElementClickable(locator, maxTimeOut);
			driver.findElement(locator).click();
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + locator);
		} catch (StaleElementReferenceException e) {
			try {
				for (int i = 0; i < 2; i++) {
					if(isWebElementPresent(locator)) {
						click(locator);
						break;
					}
					//wait();
				}
			} catch (Exception exe) {
				log.error("Failed to execute step : " + exe.getMessage());
				captureScreenshot();
				throw e;
			}
		}
	}

	
	public void click(WebElement we) {
		try {
			we.click();
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + we);
		} catch (Exception e) {
			try {
				for (int i = 0; i < 2; i++) {
					if(waitForElementClickable(we, Long.valueOf(maxTimeOut)) != null) {
						click(we);
						break;
					}
				}
			} catch (Exception exe) {
				log.error("Failed to execute step : " + exe.getMessage());
				captureScreenshot();
				e.printStackTrace();
			}
		}
	}

	public void selectDropDownData(WebElement we, String option)
	{
		try
		{
			Select sel = new Select(we);
			sel.selectByValue(option);	
		} catch(Exception e)
		{
			log.error("Failed to execute step : "+e);
			//throw e;
			e.printStackTrace();
		}
			
	}
	
	public void selectDropDownDataByText(WebElement we, String option)
	{
		try
		{
			Select sel = new Select(we);
			sel.selectByVisibleText(option);	
		} catch(Exception e)
		{
			log.error("Failed to execute step : "+e);
			//throw e;
			e.printStackTrace();
		}
			
	}
	
	public void scrollToElement(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));

			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + locator);
		} catch (Exception exe) {
			log.error("Failed to execute step : " + exe.getMessage());
			captureScreenshot();
			exe.printStackTrace();
		}

	}

	public String getText(By locator) {
		String getText = "";
		try {
			getText = driver.findElement(locator).getText();
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + locator);
		} catch (Exception exe) {
			log.error("Failed to execute step : " + exe.getMessage());
			captureScreenshot();
			exe.printStackTrace();
		}
		return getText;

	}
	
	public String getText(WebElement we) {
		String getText = "";
		try {
			getText = we.getText();
			log.info("Test step executed successfully : " + 
			Thread.currentThread().getStackTrace()[1].getMethodName());
		} catch (Exception exe) {
			log.error("Failed to execute step : " + exe.getMessage());
			captureScreenshot();
			exe.printStackTrace();
		}
		return getText;

	}

	public String getAttributeValue(By locator, String value) {
		String getValue = "";
		try {
			getValue = driver.findElement(locator).getAttribute("value");
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + locator);
		} catch (Exception exe) {
			log.error("Failed to execute step : " + exe.getMessage());
			exe.printStackTrace();
		}
		return getValue;
	}

	public List<WebElement> getListOfdata(By locator) {
		List<WebElement> userData = null;
		try {
			userData = driver.findElements(locator);
			log.info("Test step executed successfully : " + Thread.currentThread().getStackTrace()[1].getMethodName()
					+ " " + locator);
		} catch (Exception exe) {
			log.error("Failed to execute step : " + exe.getMessage());
			captureScreenshot();
			exe.printStackTrace();
		}
		return userData;
	}

	public String getTimeStamp() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
		return ((String) dateFormat.format(date));
	}

	public void switchToFrame(int input, boolean defaultContent) {
		try {
			if (defaultContent) {
				driver.switchTo().defaultContent();
			} else
				driver.switchTo().frame(input);
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
		}
	}
	
	public void switchToFrame(By locator) {
		try {
			/*if (defaultContent) {
				driver.switchTo().defaultContent();
			} else
				driver.switchTo().frame(input);*/
			driver.switchTo().frame(driver.findElement(locator));
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
		}
	}

	
	
	public void launchURL(String url) {
		try {
			driver.get(url);
			log.info("Launched URL "+url);
		} catch (Exception e) {
			log.error("Exception occured while launching browser URL : " + e.getMessage());
		}
	}

	public void switchToWindowWithTitle(String title) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();

			for (String handle : allWindowHandles) {
				driver.switchTo().window(handle);
				driver.findElement(By.tagName("body"));
				if (driver.getTitle().length() > 0) {
					if (driver.getTitle().trim().equalsIgnoreCase(title.trim())) {
						System.out.println("Switched to window - > " + title);
						break;
					}
				}else {
					throw new WebDriverException("No Title");
				}
			}
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void switchToLatestWindow() {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			
			for (String handle : allWindowHandles) {
				driver.switchTo().window(handle);
				driver.findElement(By.tagName("body"));
				if(driver.getTitle().length() > 0)
				System.out.println(driver.getTitle());
			}
		} catch (Exception e) {
			log.error("Failed to execute step : " + e.getMessage());
			e.printStackTrace();
		}
	}
		public String genaratePassword (int length) {
		    if (length < 4) {
		        length = 6;
		    }
		    final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		    final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
		    final char[] numbers = "0123456789".toCharArray();
		    final char[] symbols = "$!".toCharArray();
		    final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789$!".toCharArray();
		    Random random = new SecureRandom();
		    StringBuilder password = new StringBuilder(); 
		    for (int i = 0; i < length-4; i++) {
		        password.append(allAllowed[random.nextInt(allAllowed.length)]);
		    }
		    password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
		    password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
		    password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
		    password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);
		    System.out.println("Generated Password : "+password);
		return password.toString();
	}
	
	public String genarateString(int length)
	{
		String genaratePwd = "";
		// int length = 8;
		
		String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
		"abcdefghijklmnopqrstuvwxyz" ;
		try {

			StringBuilder sb = new StringBuilder(length);
			for (int i = 0; i < length; i++) {
				int index = (int) (Alphabets.length() * Math.random());
				sb.append(Alphabets.charAt(index));
			}
			genaratePwd = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(genaratePwd);
		return genaratePwd;
	}
	
	public String genarateNumericString(int length)
	{
		String genaratePwd = "";
		// int length = 8;
		String digits = "0123456789";
		String AlphaNumerics = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
		"abcdefghijklmnopqrstuvwxyz" +digits;
		try {
			StringBuilder sb = new StringBuilder(length);
			for (int i = 0; i < length; i++) {
				int index = (int) (AlphaNumerics.length() * Math.random());
				sb.append(AlphaNumerics.charAt(index));
			}
			genaratePwd = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return genaratePwd;
	}
	
	public void setCookies(String Value1, String Value2)
	{	
		try
		{
			
			driver.manage().addCookie(new Cookie("vmgdc",Value2));
			driver.navigate().refresh();
			Cookie cookie = driver.manage().getCookieNamed("JSESSIONID");
			String CurrentString = cookie.getValue();
			String[] separated = CurrentString.split(":");
			for(String s:separated) {
				System.out.println("++++"+s+"++++");
			}
			String firstHalfVal = separated[0].substring(0, separated[0].length() - 5);
			System.out.println("firstHalfVal == "+firstHalfVal);
			separated[0] = (firstHalfVal) + Value1 ;
			String value1=separated[0]+":"+separated[1];
			System.out.println(value1);
			//driver.manage().deleteAllCookies();
			driver.manage().deleteCookieNamed("JSESSIONID");
			driver.manage().deleteCookieNamed("vmgdc");			
			Cookie newCookie = new Cookie.Builder("JSESSIONID", value1)
					   //.domain("uk.virginmoneygiving.com")
					   //.expiresOn(new Date(2022, 03, 13))
					   .isHttpOnly(true)
					   .isSecure(true)
					   .path("/fundraiser-portal")
					   .build();

			driver.manage().addCookie(new Cookie("vmgdc",Value2));
			driver.manage().addCookie(newCookie);
			//driver.navigate().refresh();
		
			driver.get(driver.getCurrentUrl());
			
			
			/*String vmgdc=driver.manage().getCookieNamed("vmgdc").getValue();
			String JsessionID=driver.manage().getCookieNamed("JSESSIONID").getValue();
			if(vmgdc.equals(Value2))
			{
			  if(JsessionID.contains("appprod"+Value1)||JsessionID.contains("appfail"+Value1))
			//	{
					System.out.println(driver.manage().getCookieNamed("JSESSIONID"));
					System.out.println(driver.manage().getCookieNamed("vmgdc"));
			//	}
			}*/
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("App Server Mismatch " +ex.getMessage());
			
		}	
		
	}
	
	
	public boolean isCookieeContainsVal(String name , String value)
	{	
		boolean result = false; 
		try
		{
			System.out.println("Cookiee Name === "+name);
			Cookie cookiee = driver.manage().getCookieNamed(name);
			String cookieeVal = cookiee.getValue();
			/*if(cookiee.getName().equals("JSESSIONID")) {
			
				String[] separated = cookieeVal.split(":");
				separated[0] = (separated[0].substring(0, separated[0].length() - 1)) ;
				String value1=separated[0]+":"+separated[1];
				System.out.println(value1);
			}*/
			System.out.println("Cookiee Value actual === "+cookieeVal + " exp == "+value);
			if(cookieeVal.contains(value)) {
				result = true;
				System.out.println("isCookieeContainsVal :--"+result);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("isCookieeContainsVal " +ex.getMessage());
		}	
		return result;
	}


}
