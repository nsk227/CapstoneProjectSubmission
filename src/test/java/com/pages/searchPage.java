package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class searchPage {

	WebDriver driver;

	By productLink = By.xpath("//*[@id=\"listProducts\"]/a");

	By searchBox = By.xpath("//*[@id=\"productListTable_filter\"]/label/input");
	By productName = By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[2]");
	By productBrand = By.xpath("//*[@id=\"productListTable\"]/tbody/tr[1]/td[3]");

	public searchPage(WebDriver driver){

		this.driver = driver;

	}

	public void viewProduct() throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(productLink).click();
		
	}
	public void searchbyName() throws InterruptedException{
		driver.findElement(searchBox).sendKeys("Paracetamol"+ "\n");

		 String productname=driver.findElement(productName).getText();
		 System.out.println("The name column should be displaying" + " " +productname);
		
		 Thread.sleep(4000);
			WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"productListTable_filter\"]/label/input"));
			searchbox.clear();
		


	}

	public void searchbyBrand() throws InterruptedException{
		driver.findElement(searchBox).sendKeys("Sun Pharma"+ "\n");

		String productbrand=driver.findElement(productBrand).getText();
		System.out.println("The brand column should be displaying" + " " +productbrand);

		}

	public void productsSearch() throws InterruptedException{

		this.viewProduct();
		this.searchbyName();
		this.searchbyBrand();        
	}
}

