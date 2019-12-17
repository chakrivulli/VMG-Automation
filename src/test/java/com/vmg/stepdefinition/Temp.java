package com.vmg.stepdefinition;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Temp {

	public static void main(String[] args) {
		//Temp.getTempPasswordFromGmail("guzzmenow@gmail.com", "signmein1.");
		Date date = new Date();
		
		System.out.println(Calendar.getInstance().get(Calendar.YEAR));
	}
	
	public static String getTempPasswordFromGmail(String gmailId, String gmailPassword) {
		String tempPsw="";
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriver d = new ChromeDriver(ops);
		try {
			
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.get("https://mail.google.com");
		d.findElement(By.id("identifierId")).sendKeys(gmailId);
		d.findElement(By.xpath("//span[text()='Next']")).click();
		d.findElement(By.name("password")).sendKeys(gmailPassword);
		d.findElement(By.xpath("//span[text()='Next']")).click();
		WebDriverWait wait = new WebDriverWait(d, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/descendant::span[@email='theteam@virginmoneygiving.com']/../../..")));
		d.findElement(By.xpath("//body/descendant::span[@email='theteam@virginmoneygiving.com']/../../..")).click();
		tempPsw=d.findElement(
				By.xpath("//td[contains(text(),'Your temporary password is:')]/ancestor::table/following-sibling::table/descendant::td")).getText();
		System.out.println(tempPsw);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			d.quit();
		}
		return tempPsw;
	}
}
