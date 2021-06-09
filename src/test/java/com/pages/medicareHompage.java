package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class medicareHompage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("localhost:8085/medicare/");
		driver.manage().window().maximize();
		WebElement pagelabel = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/a"));
		
		String pagetitle=pagelabel.getText();
		Assert.assertEquals("Medicare", pagetitle);
		System.out.println("In the Homepage- It should be displaying: " + pagelabel.getText());
		
		System.out.println("Validate the list of categories in the Medicare Hompage:");


		List<WebElement> categories = driver.findElements(By.className("list-group"));
		
		for (WebElement itemlist : categories) {
			System.out.println(itemlist.getText());
			System.out.println("Congratulations, HomePage Test complete. Happy Testing Naresh!!!");
			driver.close();


		}

	}
}
