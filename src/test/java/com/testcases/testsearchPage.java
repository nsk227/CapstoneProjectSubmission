package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pages.loginPage;
import com.pages.searchPage;
import com.pages.userMainPage;

public class testsearchPage {
	
	String driverPath = "./drivers/chromedriver";

	static WebDriver driver;
	

	loginPage objLogin;

	userMainPage objmainPage;
	
	searchPage objsearchPage;
	
	
	
	@BeforeMethod
	
	public void setup(){

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("localhost:8085/medicare/");
		driver.manage().window().maximize();

		WebElement linkLogin = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		linkLogin.click();
		
		 WebElement email = driver.findElement(By.id("username"));
		    email.sendKeys("kn@gmail.com");
		    WebElement pwd = driver.findElement(By.id("password"));
		    pwd.sendKeys("12345");
		    WebElement btn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
		    btn.click();

	}
	
	@Test(priority=0)

	public void test_search_Page_User_Correct() throws InterruptedException{

		//Create Login Page object
		
		objsearchPage=new searchPage(driver);
		objsearchPage.productsSearch();
	}

		@AfterMethod
	 public void tearDown(){
	     driver.close();
	     driver.quit();
	 }

}
