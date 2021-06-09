package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.homePage;
import com.pages.loginPage;

public class testLogin {
	
	String driverPath = "./drivers/chromedriver";

	static WebDriver driver;
	

	loginPage objLogin;

	homePage objHomePage;
	
	
	
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

	public void test_Home_Page_User_Correct(){

		//Create Login Page object

		objLogin=new loginPage(driver);

		Assert.assertTrue(objLogin.getLoginTitle().equalsIgnoreCase("Medicare - Login"));
		System.out.println("In the User Loginpage- It should be displaying: " + objLogin.getLoginTitle());

		

		//login to application

		objLogin.loginToMedicare("kn@gmail.com", "12345");

		// go the next page

		objHomePage = new homePage(driver);

		//Verify home page

		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().equalsIgnoreCase("Kavita Nigam"));
		System.out.println("In the User Homepage- It should be displaying: " + objHomePage.getHomePageDashboardUserName());
	}
	
	@Test(priority=1)

	public void test_Home_Page_AdminUser_Correct(){

		//Create Login Page object
		objLogin=new loginPage(driver);

		String loginPageTitle = objLogin.getLoginTitle();

		Assert.assertTrue(objLogin.getLoginTitle().equalsIgnoreCase("Medicare - Login"));
		System.out.println("In the Admin Loginpage- It should be displaying: " + loginPageTitle);

		objLogin.loginToMedicare("vk@gmail.com", "admin");

		// go the next page

		objHomePage = new homePage(driver);

		//Verify home page

		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().equalsIgnoreCase("Vikas Kashyap"));
		System.out.println("In the Admin Homepage- It should be displaying:" + objHomePage.getHomePageDashboardUserName());
	}

	@AfterMethod
	 public void tearDown(){
	     driver.close();
	     driver.quit();
	 }

}
