package com.guilttrip.frontEndSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jillian.wysoki\\Desktop\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://google.com");
	}

}
