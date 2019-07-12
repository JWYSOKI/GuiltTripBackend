package com.guilttrip.frontEndSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrontendAutomationTest {

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// this instantiates before class runs
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jillian.wysoki\\Desktop\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	@Test
	public void registerUserTest() {

		/**
		 * Landing page
		 */
		driver.get("http://localhost:8080/GuiltTrip_2/");

		/**
		 * Selects register new user option
		 */
		WebElement registerButton = driver.findElement(By.id("register-btn"));
		registerButton.click();

		/**
		 * Creates new user
		 */
		driver.findElement(By.id("newUsername")).sendKeys("jillybean");
		driver.findElement(By.id("newPassword")).sendKeys("supafly");

		WebElement registerNewUserButton = driver.findElement(By.id("registerNewUser-btn"));

		registerNewUserButton.click();

		// this will check that redirect to hello.jsp happened
		
		Assert.assertEquals("http://localhost:8080/GuiltTrip_2/hello", driver.getCurrentUrl());

	}

	@Test
	public void loginUserTest() {

		driver.get("http://localhost:8080/GuiltTrip_2/");

		WebElement welcomeButton = driver.findElement(By.id("login-btn"));

		welcomeButton.click();

		driver.findElement(By.id("username")).sendKeys("jillybean");
		driver.findElement(By.id("password")).sendKeys("supafly");
		driver.findElements(By.xpath("//*[@id=\'UserFirstName\']"));

		WebElement loggedInButton = driver.findElement(By.id("loggedIn-btn"));

		loggedInButton.click();
		
		Assert.assertEquals("http://localhost:8080/GuiltTrip_2/hello", driver.getCurrentUrl());

	}

	@Test
	public void createTaskTest() {

		driver.get("http://localhost:8080/GuiltTrip_2/hello");

		driver.findElement(By.id("activity")).sendKeys("Study Selenium!");
		driver.findElement(By.id("motivation")).sendKeys("Learning is the best");
		driver.findElement(By.id("reminderTime")).sendKeys("6");

		WebElement submitButton = driver.findElement(By.id("submit-btn"));

		submitButton.click();
		
		//WebElement dynamicMotivation = driver.findElement(By.id("task-{{guilt.motivation}}"));

		//Assert.assertEquals(true, dynamicMotivation);
	}

}
