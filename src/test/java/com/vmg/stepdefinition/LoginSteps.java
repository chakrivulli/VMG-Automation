package com.vmg.stepdefinition;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.HomePage;
import com.vmg.pagefactory.LoginPage;
import com.vmg.pagefactory.MyDashboardPage;
import com.vmg.utilities.Configurator;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	public WebDriver driver;
	public Configurator configProps = new Configurator("config.properties");
	public Logger log = Logger.getLogger(LoginSteps.class);
	
	public Long maxTimeOut = Long.parseLong(String.valueOf(configProps.getProperty("GLOBAL_MAX_TIMEOUT_IN_SECONDS")));

	LoginPage loginPage ;
	MyDashboardPage dp ;
	AbstractPage abs ;
	HomePage hp;
	
	@Before
	public WebDriver setUp() {
		System.setProperty("log4j.configurationFile",configProps.getProperty("log4JPath"));
		DesiredCapabilities caps = new DesiredCapabilities();
		
		/*Proxy proxy = new Proxy();
        proxy.setHttpProxy("webproxy.virginmoney.com:8081");
        proxy.setSslProxy("webproxy.virginmoney.com:8081");
        caps.setCapability("proxy",proxy);*/
       
		String browser = configProps.getProperty("browser");

		if (browser.equalsIgnoreCase("firefox")) {
			File file = new File("Drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",file.getAbsolutePath() );
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("ie")) {
			File file = new File("Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();

		} else if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver = new ChromeDriver(ops);
			/*caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "76.0");
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("resolution", "1024x768");
			caps.setCapability("browserstack.local", "true");*/
			
			try {
				//driver = new RemoteWebDriver(new URL("https://michaeljames24:AezYipdyyWMXv6n8bdB7@hub-cloud.browserstack.com/wd/hub"),
				  //caps);
			log.info("Browser Invoked");
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		try {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		dp = new MyDashboardPage(driver);
		loginPage = new LoginPage(driver);
		abs = new AbstractPage(driver);
		hp = new HomePage(driver);
		return driver;
	}

	public WebDriver getDriver() {
	      return driver;
	   }
	
	@Given("^Open browser and start \"([^\"]*)\"$")
	public void open(String url) throws Throwable
	{
		loginPage = new LoginPage(driver);
		abs = new AbstractPage(driver);
		if(url.equals("<url>")) {
			url = configProps.getProperty("URL");
			System.out.println("URL1:"+url);
		}else if(url.contains("http")) {
			System.out.println("URL2:"+url);
		}else {
			System.out.println("URL3:"+url);
			url = configProps.getProperty("URL")+url;
		}
		abs.launchURL(url);
	}
	
	@When("^Navigate to url \"([^\"]*)\"$")
	public void navigateToUrl(String url) throws Throwable
	{
		if(!(url.contains("http"))) {
			url=driver.getCurrentUrl()+url;
			abs.launchURL(url);
		}else {
			abs.launchURL(url);
		}
	}
	
	 @And("^User clicks on signin button$")
	 public void signIn() throws Throwable {
	        loginPage.clickSignInButton();
		 
	    }
	 
	@When("^User enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userLogin(String uName, String pwd) throws Throwable {
		loginPage.login(uName, pwd);
	}
	
	@When("^User enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userLoginByClickingOnSignIn(String uName, String pwd) throws Throwable {
		loginPage.loginByClickingOnSignIn(uName, pwd);
	}
	
	@Then("^User is dispalyed My Account$")
	public void verifyLogin() {
		assertTrue(hp.isMyAccountPresent());
	}
	
	@Then("^Verify user is able to see error for invalid password$")
    public void verifyInvalidPasswordErrir() throws Throwable {
		assertTrue(abs.isTextPresent("The details you've entered do not match our records."));
    }
	
	@Then("^User account locked error message displayed$")
	public void user_account_locked_error_messaged_displayed() throws Throwable {
	    loginPage.isaccountLockedErrorMsgpresent();
	}
	
	@When("^User clicks on Forgot password link$")
	public void user_clicks_on_Forgot_password_link() throws Throwable {
	    loginPage.clickOnForgotPasswordLink();
	}

	@When("^User enter the invalid \"([^\"]*)\" address$")
	public void user_enter_the_invalid_address(String Email) throws Throwable {
	    loginPage.EnterInvalidEmailId(Email);
	}

	@When("^User clicks on Send Temporary password button$")
	public void user_clicks_on_Send_Temporary_password_button() throws Throwable {
	    loginPage.ClickOnSendTempPasswordButton();
	}

	@Then("^Verify system displayed Error message for invalid email$")
	public void verify_system_displayed_Error_message_for_invalid_email() throws Throwable {
	    loginPage.isInvalidEmailErrorMessagePresent();
	}
	
	
	

	@After
	public void quit()
	{
		driver.quit();
	}

}
