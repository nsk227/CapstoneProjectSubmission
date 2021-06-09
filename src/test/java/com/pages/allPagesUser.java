package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class allPagesUser {

	WebDriver driver;

	By about = By.xpath("//*[@id=\"about\"]/a");
	By contact = By.xpath("//*[@id=\"contact\"]/a");
	By viewList = By.xpath("//*[@id=\"listProducts\"]/a");
	By Antipyretics=By.id("a_Antipyretics");
	By Analgesics=By.id("a_Analgesics");
	By Antibiotics=By.id("a_Antibiotics");
	By home=By.xpath("/html/body/div[2]/nav/div/div[1]/a");
	
	public allPagesUser(WebDriver driver){

		this.driver = driver;

	} 

	public void viewAbout() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(about).click();
		
		WebElement aboutUs=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/p"));
		String Result1=aboutUs.getText();
		
		
		
		if (Result1.equalsIgnoreCase("This is an about us page")) {
			System.out.println("About Page should display : "+Result1);	
		}


	}
	
	public void viewContact() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(contact).click();
		
		WebElement contactPage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/p"));
		String Result2=contactPage.getText();
		
		
		
		if (Result2.equalsIgnoreCase("This is an about us page")) {
			System.out.println("Contact Page should display : "+Result2);	
		}

	}
	
	public void viewItems() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(viewList).click();
		Thread.sleep(2000);
		driver.findElement(Antipyretics).click();
		Thread.sleep(2000);
				
		WebElement firstTable = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/thead/tr/th[2]"));

		//To find  rows of table (item name)
		WebElement productRow1 = firstTable.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]"));
		String row1 = productRow1.getText();
		System.out.println("First Item on the Antipyretics list is : "+row1);
		
		driver.findElement(Analgesics).click();
		Thread.sleep(2000);
		
		WebElement secondTable = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/thead/tr/th[2]"));

		//To find  rows of table (item name)
		WebElement productRow2 = secondTable.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]"));
		String row2 = productRow2.getText();
		System.out.println("First Item on the Analgesics list is : "+row2);
		
		
		driver.findElement(Antibiotics).click();
		Thread.sleep(3000);
		
		WebElement thirdTable = driver.findElement(By.xpath("//*[@id=\"productListTable\"]/thead/tr/th[2]"));

		//To find  rows of table (item name)
		WebElement productRow3 = thirdTable.findElement(By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]"));
		String row3 = productRow3.getText();
		System.out.println("First Item on the Antibiotics list is : "+row3);
	
	}
	
	public void viewHome() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(home).click();
		
		WebElement mainPage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/p"));
		String Result3=mainPage.getText();
		
		if (Result3.equalsIgnoreCase("Categories")) {
			System.out.println("Main Page should display : "+Result3);	
		}
		
	}
		
	public void pagenavigation() throws InterruptedException{

		this.viewAbout();
		this.viewContact();
		this.viewItems();
		this.viewHome();
		}
}