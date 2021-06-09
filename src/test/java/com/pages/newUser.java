package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class newUser {

	WebDriver driver;

	By userLink = By.xpath("/html/body/div/div[1]/div/div/div/div/div[3]/div/a");

	By firstName = By.id("firstName");
	By lastName = By.id("lastName");
	By email = By.id("email");
	By contactNum = By.id("contactNumber");
	By password = By.id("password");
	By Cpassword = By.id("confirmPassword");
	By nextBtn = By.xpath("//*[@id=\"registerForm\"]/div[8]/div/button");

	By addOne=By.id("addressLineOne");
	By addTwo=By.id("addressLineTwo");
	By city=By.id("city");
	By pCode=By.id("postalCode");
	By state=By.id("state");
	By country=By.id("country");
	By nextTab=By.xpath("//*[@id=\"billingForm\"]/div[7]/div/button[2]");
	By confirmBtn= By.linkText("Confirm");


	public newUser(WebDriver driver){

		this.driver = driver;

	}

	public void userlink(){

		driver.findElement(userLink).click();
	}

	public void newUserdetails(){

		driver.findElement(firstName).sendKeys("Naresh");
		driver.findElement(lastName).sendKeys("Khadka");
		driver.findElement(email).sendKeys("nkhadka@test.com");
		driver.findElement(contactNum).sendKeys("1237894560");
		driver.findElement(password).sendKeys("12345");
		driver.findElement(Cpassword).sendKeys("12345");
		driver.findElement(nextBtn).click();
		driver.findElement(addOne).sendKeys("123 Test Road");
		driver.findElement(addTwo).sendKeys("QA Lane");
		driver.findElement(city).sendKeys("TestCity");
		driver.findElement(pCode).sendKeys("12345");
		driver.findElement(state).sendKeys("IN");
		driver.findElement(country).sendKeys("US");
		driver.findElement(nextTab).click();
		

	}

	public void confirmdetails() throws InterruptedException{
		Thread.sleep(3000);
		
		WebElement cnfbtn=driver.findElement(confirmBtn);
		Assert.assertEquals(cnfbtn.getText(), "Confirm", "Confirm Button is active");
		System.out.println("In the Screen- It should be displaying: " + cnfbtn.getText());

		System.out.println("User Creation Complete");
	}


public void createNewUser() throws InterruptedException{

	this.userlink();
	this.newUserdetails();
	this.confirmdetails();        
}

}




