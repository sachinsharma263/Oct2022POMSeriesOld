package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.trcrm.base.BasePage;
import com.qa.trcrm.utils.ElementUtil;
import com.qa.trcrm.utils.JavaScriptUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil util;
	JavaScriptUtil jsUtil;

	By emailId = By.id("_username");
	By password = By.id("_password");
	By loginBtn = By.xpath("//input[@type='submit']");

	By signUpNowLink = By.linkText("Sign Up Now2");
	By errorMsg=By.id("error");
	By userLogin=By.xpath("//h3[text()='User Login']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
		jsUtil=new JavaScriptUtil(driver);
	}

	public String getTitle() {
		return util.doGetTitle();
	}

	public boolean verifySignUpLink() {
		return util.doIsDisplayed(signUpNowLink);
		
	}

	public HomePage doLogin(String username, String pwd) {

		driver.findElement(emailId).clear();
		util.doSendKeys(emailId, username);
		driver.findElement(password).clear();
		util.doSendKeys(password, pwd);
		util.doClick(loginBtn);

		return new HomePage(driver);
	}
	public boolean errorMessage() {
		return util.doIsDisplayed(userLogin);
	}
}
