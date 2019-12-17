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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vmg.pagefactory.AbstractPage;
import com.vmg.pagefactory.ForgotPasswordPage;
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

public class ForgotPasswordSteps {
	
	WebDriver driver;
	int waitTime=30;
	LoginSteps baseSteps;
	LoginPage loginPage ;
	MyDashboardPage dp ;
	AbstractPage abs ;
	HomePage hp;
	ForgotPasswordPage fp;
	
	public ForgotPasswordSteps(LoginSteps bs) {
		this.baseSteps = bs;
		driver = baseSteps.getDriver();
		dp = new MyDashboardPage(driver);
		loginPage = new LoginPage(driver);
		abs = new AbstractPage(driver);
		hp = new HomePage(driver);
		fp = new ForgotPasswordPage(driver);
		waitTime=abs.maxTimeOut.intValue();
	}
	
	@When("^User enter valid \"([^\"]*)\" and hits forgotten password$")
	public void user_enter_valid_and_hits_forgotten_password(String email) throws Throwable {
		loginPage.enterEmail(email);
		loginPage.clickNextButton();
		abs.switchToFrame(0, false);
	   fp.isForgottenPasswordLinkPresent();
	   fp.clickForgottenPasswordLink();		
	}

	@Then("^User is shared temporty password to login and reset password using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_is_shared_temporty_password_to_login_and_reset_password(String gmailId, String gmailPassword) throws Throwable {
		fp.clickSendTempPasswordBtn();
		fp.waitForConfirmationText();
		String temPassword=getTempPasswordFromGmail(gmailId, gmailPassword);
		//fp.clickSignInButton();
		loginPage.clickSignInButton();
		loginPage.login(gmailId, temPassword);
		abs.wait(waitTime);
		loginPage.enterPassword(abs.genaratePassword(8));
		fp.clickUpdatePasswordBtn();
		assertTrue(abs.isTextPresent("Are your details up-to-date?"));
	}
	
	public String getTempPasswordFromGmail(String gmailId, String gmailPassword) {
		String tempPsw="";
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriver d = new ChromeDriver(ops);
		d.manage().timeouts().implicitlyWait(abs.maxTimeOut, TimeUnit.SECONDS);
		d.get("https://mail.google.com");
		WebDriverWait wait = new WebDriverWait(d, abs.maxTimeOut);
		try {
		d.findElement(By.id("identifierId")).sendKeys(gmailId);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		d.findElement(By.xpath("//span[text()='Next']")).click();
		d.findElement(By.name("password")).sendKeys(gmailPassword);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		d.findElement(By.xpath("//span[text()='Next']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/descendant::table[contains(.,'Your Virgin Money Giving account')]/descendant::tr[1]")));
		d.findElement(By.xpath("//body/descendant::table[contains(.,'Your Virgin Money Giving account')]/descendant::tr[1]")).click();
		tempPsw=d.findElement(
				By.xpath("//body/descendant::td[contains(text(),'Your temporary password is:')][last()]/ancestor::table/following-sibling::table/descendant::td[last()]")).getText();
		System.out.println(tempPsw);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			d.quit();
		}
		return tempPsw;
	}
}
