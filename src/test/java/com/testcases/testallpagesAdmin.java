package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.allpagesAdmin;

public class testallpagesAdmin {

	String driverPath = "./drivers/chromedriver";

	static WebDriver driver;


	allpagesAdmin objallpagesAdmin;


	@BeforeMethod

	public void setup(){

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();

		driver.get("localhost:8085/medicare/");
		driver.manage().window().maximize();

		WebElement linkLogin = driver.findElement(By.xpath("//*[@id=\"login\"]/a"));
		linkLogin.click();

		WebElement email = driver.findElement(By.id("username"));
		email.sendKeys("vk@gmail.com");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("admin");
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[3]/div/input[2]"));
		btn.click();

	}


	@Test(priority=0)

	public void test_all_Pages_Admin_Correct() throws InterruptedException{

		objallpagesAdmin=new allpagesAdmin(driver);
		objallpagesAdmin.viewAbout();
		objallpagesAdmin.viewContact();
		objallpagesAdmin.viewItems();
		objallpagesAdmin.viewHome();
		objallpagesAdmin.pagenavigations();
	}

	@AfterMethod
	public void tearDown(){
		driver.close();
		driver.quit();
	}


}
