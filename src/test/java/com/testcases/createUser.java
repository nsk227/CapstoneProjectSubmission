package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.newUser;

public class createUser {

	String driverPath = "./drivers/chromedriver";

	static WebDriver driver;


	newUser objnewUser;

	@BeforeMethod

	public void setup(){

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("localhost:8085/medicare/");
		driver.manage().window().maximize();

		WebElement linkLogin = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		linkLogin.click();

	}

	@Test(priority=0)

	public void test_Create_User_Correct() throws InterruptedException{

		

		objnewUser=new newUser(driver);

		objnewUser.createNewUser();

	}


	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}

}
