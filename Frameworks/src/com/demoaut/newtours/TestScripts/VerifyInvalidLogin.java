package com.demoaut.newtours.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoaut.newtours.Pages.Login;
import com.demoaut.newtours.Pages.SignOn;

import utils.GenericMethods;

public class VerifyInvalidLogin {

	WebDriver  driver; 
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.newtours.demoaut.com/");
	}

	@Test
	public void verifyInvalidLogin() throws IOException {
		Login lp = new Login(driver);
		SignOn so = new SignOn(driver);
		String[][] data = GenericMethods.getData("D:\\SelMar29\\TestData.xlsx", "Sheet1");
		for(int i = 1;i<data.length;i++) {
			lp.applicationLogin(data[i][0],data[i][1]);
			String actualMsg = so.getMessage();
			String expectedMsg = "Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.";

			Assert.assertEquals(actualMsg, expectedMsg);
			driver.navigate().back();
		}

	}

	@AfterTest
	public void closeApplication() {
		driver.close();
	}
}
