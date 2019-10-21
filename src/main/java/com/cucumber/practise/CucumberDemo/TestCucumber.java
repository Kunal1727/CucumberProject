package com.cucumber.practise.CucumberDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCucumber 
{
	@FindBy(id="txtUsername")
	WebElement usernameLocator;
	@FindBy(id="txtPassword")
	WebElement passwordLocator;
	@FindBy(id="btnLogin")
	WebElement loginBtnLocator;
	WebDriver driver;
	
	@Given("^the site is up and running$")
	public void the_site_is_up_and_running() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}

	@When("^I provide correct credentials$")
	public void i_provide_correct_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		usernameLocator.sendKeys("admin");
		passwordLocator.sendKeys("admin123");
		loginBtnLocator.click();
	}

	@Then("^I validate I should logged in$")
	public void i_validate_I_should_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	}

	@When("^I provide (\\w+) and (\\w+)$")
	public void i_provide_incorrect_credentials(String username,String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		usernameLocator.sendKeys(username);
		passwordLocator.sendKeys(password);
		loginBtnLocator.click();
	}

	@Then("^I validate I should not logged in$")
	public void i_validate_I_should_not_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	}
}
